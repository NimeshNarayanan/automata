import java.util.ArrayList;

public class DFA {

    private final ArrayList<String> alphabets;
    private final ArrayList<String> states;
    private final ArrayList<Transition> transitions;
    private final String initialState;
    private final String finalState;
    private String currentState;

    public DFA(ArrayList<String> alphabets, ArrayList<String> states, ArrayList<Transition> transitions, String initialState, String finalState) {

        this.alphabets = alphabets;
        this.states = states;
        this.transitions = transitions;
        this.initialState = initialState;
        this.finalState = finalState;
        this.currentState = null;
    }

    public boolean isLanguagePasses() {
        if (alphabets.isEmpty() || states.isEmpty()){
            return false;
        }
        for (int i = 0; i < alphabets.size(); i++) {
            if (currentState == null)
                this.currentState =this.getNextState(initialState,alphabets.get(i),transitions);
            else
                this.currentState = this.getNextState(currentState,alphabets.get(i),transitions);

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
