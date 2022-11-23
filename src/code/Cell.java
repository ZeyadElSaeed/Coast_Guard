package code;

public class Cell {
    int i;
    int j;
}
class Ship extends Cell{
    int no_of_passengers;
    boolean is_wreck;
    boolean has_blackbox;
    int blackbox_health;
}
class Station extends Cell{

}
class Agent extends Cell{
    int max_capacity;
    int remaining_capacity;
}
