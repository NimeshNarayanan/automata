package helper;

import automata.DFA;
import parser.Tuple;
import tuple.Alphabets;
import tuple.States;
import tuple.Transition;

import java.util.*;

public class DFAGenerator {
    private final Tuple tuple;

    public DFAGenerator(Tuple tuple) {
        this.tuple = tuple;
    }

    public DFA generateDFA() throws Exception {
        Alphabets alphabets = new Alphabets(tuple.getAlphabets());
        States states = new States(tuple.getStates());
        Map<String, Map<String, String>> delta = tuple.getDelta();
        String initialState = tuple.getInitialState();
        Set<String> finalStates = tuple.getFinalStates();
        DFA dfa = DFA.factory(alphabets,states,delta,initialState,finalStates);
        return dfa;
    }


}
