package tuple;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Transitions {
    Map<String,Map<String,String>> transitions;


    private ArrayList<Transition> transition;

    public Transitions() {
        this.transitions = new HashMap<>();
    }
    public void addPath(String currentState,String alphabet,String nextState){
        if (this.transitions.containsKey(currentState)){
            Map<String,String> path = this.transitions.get(currentState);
            path.put(alphabet,nextState);
            return;
        }
        Map<String,String> path = new HashMap<>();
        path.put(alphabet,nextState);
        this.transitions.put(currentState,path);
    }

    public Map<String,Map<String,String>> getTransitions(){
        return transitions;
    }

}
