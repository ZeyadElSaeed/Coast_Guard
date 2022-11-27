package code;

import java.lang.Math;

public class CoastGuard extends SearchProblem{
    static int grid_min = 5;
    static int grid_max = 15;
    static int agent_min = 30;
    static int agent_max = 100;
    static int passenger_min = 1;
    static int passenger_max = 100;
    static int black_box_life = 20;


    public CoastGuard(Cell[][]grid){
        this.operators = new String[]{"up","down","right","left","pickup","drop","retrieve"};
        //
        this.initial_state = new StateNode("",null,null,0,0);
        this.state_space = new StateNode[2*grid.length];
    }
    public static  int GenerateRandomNumber( int max , int min ){
        return (int)(Math.random()*(max-min+1)+min);
    }
    public boolean goal_test(StateNode node){
        return true;
    }
    public static String genGrid(){
        // Initialize The size of the grid
        int m = GenerateRandomNumber( grid_max , grid_min );
        int n = GenerateRandomNumber( grid_max , grid_min );
        int cells_number = m * n;
        int [][] grid = new int [m][n];
        System.out.println("Cells Number: "+ cells_number);

        // Generate the capacity of coast guard ship
        int agent_capacity = GenerateRandomNumber( agent_max , agent_min );
        System.out.println("agent_capacity: "+ agent_capacity);

        // Generate the location of the coast guard ship
        int agent_row_loc = GenerateRandomNumber( m-1 , 0 );
        int agent_col_loc = GenerateRandomNumber( n-1 , 0 );
        grid[ agent_row_loc ][ agent_col_loc ] = -1; // here

        // Generate the number of the ships
        int ship_number = GenerateRandomNumber( cells_number-2 , 1 );
        System.out.println("ship_number: "+ ship_number);
        // Generate the number of the stations ( The remaining number after ships and agent)
        int remain_locations = cells_number - ship_number ;
        int station_number = GenerateRandomNumber( remain_locations , 1 );
        System.out.println("station_number: "+ station_number);

        for ( int i = 0; i < ship_number; i++){
            int passenger_number = GenerateRandomNumber( passenger_max , passenger_min );
            boolean flag = true;
            while (flag) {
                int row = GenerateRandomNumber(m - 1, 0);
                int col = GenerateRandomNumber(n - 1, 0);
                if ( grid[row][col] == 0){
                    grid[row][col] = passenger_number;
                    flag = false;
                }
            }

        }

        for ( int i = 0; i < station_number; i++){
            boolean flag = true;
            while (flag) {
                int row = GenerateRandomNumber(m - 1, 0);
                int col = GenerateRandomNumber(n - 1, 0);
                if ( grid[row][col] == 0){
                    grid[row][col] = -55; //troll
                    flag = false;
                }
            }

        }

        String str_first = m+","+n+";"+ agent_capacity + ";" + agent_row_loc + "," + agent_col_loc + ";";
        String str_second = "";
        String str_third = "";
        for ( int i = 0; i<m; i++){
            for ( int j = 0; j<n; j++){
                if ( grid[i][j] > 0){
                    str_third += i+"," +j+ "," + grid[i][j] + "," ;
                }
                else if ( grid[i][j] == -55 ){
                    str_second += i + "," + j + "," ;
                }
            }
        }
        str_second = str_second.substring(0,str_second.length()-1)+";";
        str_third = str_third.substring(0,str_third.length()-1)+";";
        String result = str_first + str_second + str_third;
        System.out.println(result);
        for (int [] x:
                grid) {
            for (int y:
                    x) {
                System.out.print(y + " ");
            }
            System.out.println(" ");
        }
        return result;
    }

    public static Cell [][] instantiateGrid(String grid_string){
        String [] grid_split = grid_string.split(";");
        // Initiate grid dimensions
        String [] dimensions = grid_split[0].split(",");
        Cell [][] grid = new Cell[Integer.parseInt(dimensions[0])][Integer.parseInt(dimensions[1])];


        // creating and localizing agent
        int agent_capacity = Integer.parseInt(grid_split[1]);
        String [] agent_position = grid_split[2].split(",");
        grid[Integer.parseInt(agent_position[0])][Integer.parseInt(agent_position[1])] =
                new Agent(Integer.parseInt(agent_position[0]), Integer.parseInt(agent_position[1]), agent_capacity);


        // creating and localizing Stations
        String [] stations_position = grid_split[3].split(",");
        for(int i =0;i<stations_position.length;i=i+2){
            grid[Integer.parseInt(stations_position[i])][Integer.parseInt(stations_position[i+1])] =
                    new Station(Integer.parseInt(stations_position[i]), Integer.parseInt(stations_position[i+1]));
        }
        // creating and localizing ships
        String [] ships_position = grid_split[4].split(",");
        for(int i =0;i<ships_position.length;i=i+3){
            grid[Integer.parseInt(ships_position[i])][Integer.parseInt(ships_position[i+1])] =
                    new Ship(Integer.parseInt(ships_position[i]), Integer.parseInt(ships_position[i+1]), Integer.parseInt(ships_position[i+2]));
        }
        // Initializing Empty cells
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==null)grid[i][j] = new Cell(i,j);
            }
        }
        // print
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        return grid;
    }
    public static String solve(String grid_string, String strategy, boolean visualize){
        Cell [][] grid = instantiateGrid(grid_string);
        CoastGuard problem = new CoastGuard(grid);
        switch(strategy){
            case "BF":// implement breadth-first search
                break;
            case "DF":// implement depth-first search
                break;
        }
        return "";
    }
    public static void main(String[] args) {
         solve(genGrid(),"",false);
    }
}