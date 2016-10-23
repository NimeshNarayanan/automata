package automata;

import tuple.Alphabets;
import tuple.States;
import tuple.Transition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DFA {

    private final Alphabets alphabets;
    private final States states;
    private Map<String, Map<String, String>> transitions;
    private final String initialState;
    private final Set<String> finalStates;

    private DFA(Alphabets alphabets, States states, Map<String, Map<String, String>> transitions, String initialState, Set<String> finalState) {

        this.alphabets = alphabets;
        this.states = states;
        this.transitions = transitions;
        this.initialState = initialState;
        this.finalStates = finalState;
    }
    public static DFA factory(Alphabets alphabets, States states, Map<String, Map<String, String>> transitions, String initialState, Set<String> finalStates) throws Exception {
        if (alphabets.isEmpty() || states.isEmpty()){
            throw new Exception("Invalid dfa.DFA");
        }
        return new DFA(alphabets,states,transitions,initialState, finalStates);
    }


    public boolean isLanguagePasses(String string) {
        String currentState = initialState;

        String[] alphabets  = string.split("");

        for (String alphabet : alphabets) {
            if (!this.alphabets.isValidAlphabet(alphabet))
                return false;
            currentState = this.transitions.get(currentState).get(alphabet);

        }
        return this.finalStates.contains(currentState);

    }
}
