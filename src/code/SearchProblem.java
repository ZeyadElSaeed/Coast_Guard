package code;

public class SearchProblem {
    String [] operators;
    StateNode initial_state;
    StateNode[] state_space;
    public boolean goal_test(StateNode node){
        return true;
    }
    public int path_cost(StateNode node){
        return 0;
    };
}
