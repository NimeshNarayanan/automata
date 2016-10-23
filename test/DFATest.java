import automata.DFA;
import org.junit.Test;
import tuple.Alphabets;
import tuple.States;
import tuple.Transition;
import tuple.Transitions;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DFATest {
    @Test
    public void test_dfa_will_return_false_for_empty_string() throws Exception {
        List<String> alphabets = new ArrayList<>();
        alphabets.add("0");
        alphabets.add("1");
        Alphabets alphabets1 = new Alphabets(alphabets);
        List<String> states = new ArrayList<>();
        states.add("q0");
        states.add("q1");
        States states1 = new States(states);
        Transitions transitionsTable = new Transitions();
        transitionsTable.addPath("q0", "0", "q0");
        transitionsTable.addPath("q0", "1", "q1");
        Map<String, Map<String, String>> transitions = transitionsTable.getTransitions();
        HashSet<String> finalStates = new HashSet();
        finalStates.add("q1");

        DFA dfa = DFA.factory(alphabets1, states1, transitions, "q0", finalStates);
        assertFalse(dfa.isLanguagePasses(""));

    }
    @Test
    public void test_dfa_will_return_false_for_invalid_string() throws Exception {
        List<String> alphabets =new ArrayList<>();
        alphabets.add("0");
        alphabets.add("1");
        Alphabets alphabets1 = new Alphabets(alphabets);
        List<String> states = new ArrayList<>();
        states.add("q0");
        states.add("q1");
        States states1 = new States(states);
        Transitions transitionsTable = new Transitions();
        transitionsTable.addPath("q0", "0", "q0");
        transitionsTable.addPath("q0", "1", "q1");
        Map<String, Map<String, String>> transitions = transitionsTable.getTransitions();
        HashSet<String> finalStates = new HashSet();
        finalStates.add("q1");
        DFA dfa = DFA.factory(alphabets1, states1, transitions, "q0", finalStates);
        assertFalse(dfa.isLanguagePasses("ab"));

    }
    @Test
    public void test_dfa_will_return_true_if_string_passes() throws Exception {
        List<String> alphabets = new ArrayList<>();
        alphabets.add("1");
        alphabets.add("0");
        Alphabets alphabets1 = new Alphabets(alphabets);
        List<String> states = new ArrayList<>();
        states.add("q0");
        states.add("q1");
        States states1 = new States(states);
        Transitions transitionsTable = new Transitions();
        transitionsTable.addPath("q0", "1", "q0");
        transitionsTable.addPath("q0", "0", "q1");
        Map<String, Map<String, String>> transitions = transitionsTable.getTransitions();
        HashSet<String> finalStates = new HashSet();
        finalStates.add("q1");
        DFA dfa = DFA.factory(alphabets1, states1, transitions, "q0", finalStates);
        assertTrue(dfa.isLanguagePasses("10"));

    }
@Test
    public void test_dfa_will_return_true_if_string_passes_have_self_loops() throws Exception {
        List<String> alphabets = new ArrayList<>();
        alphabets.add("0");
        alphabets.add("1");
        Alphabets alphabets1 = new Alphabets(alphabets);
        List<String> states = new ArrayList<>();
        states.add("q0");
        states.add("q1");
        States states1 = new States(states);
        Transitions transitionsTable = new Transitions();
        transitionsTable.addPath("q0", "1", "q0");
        transitionsTable.addPath("q0", "0", "q1");
        transitionsTable.addPath("q1", "0", "q1");
        transitionsTable.addPath("q1", "1", "q1");
        Map<String, Map<String, String>> transitions = transitionsTable.getTransitions();
        HashSet<String> finalStates = new HashSet();
        finalStates.add("q1");
        DFA dfa = DFA.factory(alphabets1, states1, transitions, "q0", finalStates);
        assertTrue(dfa.isLanguagePasses("01"));

    }
@Test
    public void test_dfa_will_return_true_if_string_passes_for_even_number_of_1_have_more_than_two_states() throws Exception {
        List<String> alphabets = new ArrayList<>();
        alphabets.add("1");
        alphabets.add("0");
        Alphabets alphabets1 = new Alphabets(alphabets);
        List<String> states = new ArrayList<>();
        states.add("q0");
        states.add("q1");
        states.add("q2");
        States states1 = new States(states);
        Transitions transitionsTable = new Transitions();
        transitionsTable.addPath("q0", "1", "q1");
        transitionsTable.addPath("q0", "0", "q0");
        transitionsTable.addPath("q1", "0", "q1");
        transitionsTable.addPath("q1", "1", "q2");
        transitionsTable.addPath("q2", "1", "q1");
        transitionsTable.addPath("q2", "0", "q2");
        Map<String, Map<String, String>> transitions = transitionsTable.getTransitions();

    HashSet<String> finalStates = new HashSet();
    finalStates.add("q2");
        DFA dfa = DFA.factory(alphabets1, states1, transitions, "q0", finalStates);
        assertTrue(dfa.isLanguagePasses("110"));

    }
@Test
    public void test_dfa_will_return_false_if_string_not_passes_for_even_number_of_1_have_more_than_two_states() throws Exception {
        List<String> alphabets = new ArrayList<>();
        alphabets.add("1");
        alphabets.add("0");
        Alphabets alphabets1 = new Alphabets(alphabets);
        List<String> states = new ArrayList<>();
        states.add("q0");
        states.add("q1");
        states.add("q2");
        States states1 = new States(states);

        Transitions transitionsTable = new Transitions();
        transitionsTable.addPath("q0", "1", "q1");
        transitionsTable.addPath("q0", "0", "q0");
        transitionsTable.addPath("q1", "0", "q1");
        transitionsTable.addPath("q1", "1", "q2");
        transitionsTable.addPath("q2", "1", "q1");
        transitionsTable.addPath("q2", "0", "q2");
        Map<String, Map<String, String>> transitions = transitionsTable.getTransitions();

        HashSet<String> finalStates = new HashSet();
        finalStates.add("q2");
        DFA dfa = DFA.factory(alphabets1, states1, transitions, "q0", finalStates);
        assertFalse(dfa.isLanguagePasses("111"));

    }
    @Test
    public void test_dfa_will_return_true_if_string_passes_for_All_strings_whose_decimal_representation_is_an_even_number() throws Exception {
        List<String> alphabets = new ArrayList<>();
        alphabets.add("1");
        alphabets.add("0");
        Alphabets alphabets1 = new Alphabets(alphabets);
        List<String> states = new ArrayList<>();
        states.add("q0");
        states.add("q1");
        states.add("q2");
        States states1 = new States(states);
        Transitions transitionsTable = new Transitions();
        transitionsTable.addPath("q0", "1", "q2");
        transitionsTable.addPath("q0", "0", "q1");
        transitionsTable.addPath("q1", "0", "q1");
        transitionsTable.addPath("q1", "1", "q2");
        transitionsTable.addPath("q2", "1", "q1");
        transitionsTable.addPath("q2", "0", "q2");
        Map<String, Map<String, String>> transitions = transitionsTable.getTransitions();

        HashSet<String> finalStates = new HashSet();
        finalStates.add("q1");
        DFA dfa = DFA.factory(alphabets1, states1, transitions, "q0", finalStates);
        assertTrue(dfa.isLanguagePasses("110"));

    }
    @Test
    public void test_dfa_will_return_false_if_string_not_passes_for_All_strings_whose_decimal_representation_is_an_even_number() throws Exception {
        List<String> alphabets = new ArrayList<>();
        alphabets.add("1");
        alphabets.add("0");
        Alphabets alphabets1 = new Alphabets(alphabets);
        List<String> states = new ArrayList<>();
        states.add("q0");
        states.add("q1");
        states.add("q2");
        States states1 = new States(states);
        Transitions transitionsTable = new Transitions();

        transitionsTable.addPath("q0", "1", "q2");
        transitionsTable.addPath("q0", "0", "q1");
        transitionsTable.addPath("q1", "0", "q1");
        transitionsTable.addPath("q1", "1", "q2");
        transitionsTable.addPath("q2", "1", "q1");
        transitionsTable.addPath("q2", "0", "q2");
        Map<String, Map<String, String>> transitions = transitionsTable.getTransitions();

        HashSet<String> finalStates = new HashSet();
        finalStates.add("q1");
        DFA dfa = DFA.factory(alphabets1, states1, transitions, "q0", finalStates);
        assertFalse(dfa.isLanguagePasses("111"));

    }
    @Test
    public void test_odd_number_of_zeroes() throws Exception {
        List<String> alphabets = new ArrayList<>();
        alphabets.add("0");
        alphabets.add("1");
        Alphabets alphabets1 = new Alphabets(alphabets);
        List<String> states = new ArrayList<>();
        states.add("q1");
        states.add("q2");
        States states1 = new States(states);
        Transitions transitionsTable = new Transitions();
        transitionsTable.addPath("q2", "1", "q2");
        transitionsTable.addPath("q2", "0", "q1");
        transitionsTable.addPath("q1", "1", "q1");
        transitionsTable.addPath("q1", "0", "q2");
        Map<String, Map<String, String>> transitions = transitionsTable.getTransitions();
        HashSet<String> finalStates = new HashSet();
        finalStates.add("q1");
        DFA dfa = DFA.factory(alphabets1, states1, transitions, "q2", finalStates);
        assertFalse(dfa.isLanguagePasses("001100"));
//        assertTrue(dfa.isLanguagePasses("01"));
//        assertTrue(dfa.isLanguagePasses("01"));
    }
}