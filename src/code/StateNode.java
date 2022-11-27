package code;

public class StateNode {
    String state;
    StateNode parent;
    String operator;
    int depth;
    int path_cost;
    public StateNode(String state, StateNode parent, String operator, int depth, int path_cost){
        this.state = state;
        this.parent = parent;
        this.operator = operator;
        this.depth = depth;
        this.path_cost = path_cost;
    }
}
