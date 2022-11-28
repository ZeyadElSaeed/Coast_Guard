package code;

public class Cell {
    int i;
    int j;
    public Cell(int i, int j){
        this.i = i;
        this.j = j;
    }
    public String toString(){
        String type = " Em";
        if (this instanceof Agent) type = " Ag";
        if (this instanceof Station) type = " St";
        if (this instanceof Ship) type = " Sh";
        return type;
    }
}
class Ship extends Cell{
    int no_of_passengers;
    boolean is_wreck;
    boolean has_blackbox;
    int blackbox_health = 20;
    public Ship(int i, int j, int no_of_passengers){
        super(i,j);
        this.no_of_passengers = no_of_passengers;
        is_wreck = false;
        has_blackbox = true;
    }
}
class Station extends Cell{
    public Station(int i, int j){
        super(i,j);
    }
}
class Agent extends Cell{
    int max_capacity;
    int remaining_capacity;
    public Agent(int i, int j, int max_capacity){
        super(i,j);
        this.max_capacity = max_capacity;
        remaining_capacity = max_capacity;
    }
}
