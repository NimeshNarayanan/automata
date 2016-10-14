import java.util.ArrayList;

public class DFA {

    private final ArrayList<String> alphabets;
    private final ArrayList<String> states;
    private final ArrayList<Transition> transitions;
    private final String initialState;
    private final String finalState;
    private String currentState;

    private DFA(ArrayList<String> alphabets, ArrayList<String> states, ArrayList<Transition> transitions, String initialState, String finalState) {

        this.alphabets = alphabets;
        this.states = states;
        this.transitions = transitions;
        this.initialState = initialState;
        this.finalState = finalState;
        this.currentState = null;
    }
    public static DFA factory(ArrayList<String> alphabets, ArrayList<String> states, ArrayList<Transition> transitions, String initialState, String finalState) throws Exception {
        if (alphabets.isEmpty() || states.isEmpty()){
            throw new Exception("Invalid DFA");
        }
        return new DFA(alphabets,states,transitions,initialState,finalState);
    }


    public boolean isLanguagePasses(String string) {
        if(string.isEmpty()) {
            return false;
        }
        String[] alphabets  = string.split("");

        for (int i = 0; i < alphabets.length; i++) {
            if(!this.alphabets.contains(alphabets[i]))
                return false;
            if (currentState == null)
                this.currentState =this.getNextState(initialState, alphabets[i],transitions);
            else
                this.currentState = this.getNextState(currentState, alphabets[i],transitions);

        }
        if (currentState == this.finalState)
            return true;
        return false;
    }

    private String getNextState(String currentState, String alphabet, ArrayList<Transition> transitions) {
        for (Transition transition:transitions) {
            if (transition.isNextState(currentState,alphabet)) {
                currentState = transition.getNext_state();
                return currentState;
            }
        }
        return currentState;
    }

}
