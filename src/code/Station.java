package code;

public class Station extends Cell{
    public Station(int i, int j){
        super(i,j);
    }
    public Station clone() {
    	return new Station(i,j);
    }
}
