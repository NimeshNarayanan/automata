import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DFATest {
    @Test
    public void test_dfa_will_return_false_for_empty_string() throws Exception {
        ArrayList<String> alphabets = new ArrayList<>();
        alphabets.add("");
        alphabets.add("");
        ArrayList<String> states = new ArrayList<>();
        states.add("q0");
        states.add("q1");
        Transition transition = new Transition("q0", "0", "q0");
        Transition transition1 = new Transition("q0", "1", "q1");
        ArrayList<Transition> transitions = new ArrayList<>();
        transitions.add(transition);
        transitions.add(transition1);
        DFA dfa = new DFA(alphabets, states, transitions, "q0", "q1");
        assertFalse(dfa.isLanguagePasses());

    }
    @Test
    public void test_dfa_will_return_true_if_string_passes() throws Exception {
        ArrayList<String> alphabets = new ArrayList<>();
        alphabets.add("1");
        alphabets.add("0");
        ArrayList<String> states = new ArrayList<>();
        states.add("q0");
        states.add("q1");
        Transition transition = new Transition("q0", "1", "q0");
        Transition transition1 = new Transition("q0", "0", "q1");
        ArrayList<Transition> transitions = new ArrayList<>();
        transitions.add(transition);
        transitions.add(transition1);
        DFA dfa = new DFA(alphabets, states, transitions, "q0", "q1");
        assertTrue(dfa.isLanguagePasses());

    }
@Test
    public void test_dfa_will_return_true_if_string_passes_have_self_loops() throws Exception {
        ArrayList<String> alphabets = new ArrayList<>();
        alphabets.add("0");
        alphabets.add("1");
        ArrayList<String> states = new ArrayList<>();
        states.add("q0");
        states.add("q1");
        Transition transition = new Transition("q0", "1", "q0");
        Transition transition1 = new Transition("q0", "0", "q1");
        Transition transition2 = new Transition("q1", "0", "q1");
        Transition transition3 = new Transition("q1", "1", "q1");
        ArrayList<Transition> transitions = new ArrayList<>();
        transitions.add(transition);
        transitions.add(transition1);
        transitions.add(transition2);
        transitions.add(transition3);
        DFA dfa = new DFA(alphabets, states, transitions, "q0", "q1");
        assertTrue(dfa.isLanguagePasses());

    }
@Test
    public void test_dfa_will_return_true_if_string_passes_for_even_number_of_1_have_more_than_two_states() throws Exception {
        ArrayList<String> alphabets = new ArrayList<>();
        alphabets.add("1");
        alphabets.add("1");
        alphabets.add("0");
        ArrayList<String> states = new ArrayList<>();
        states.add("q0");
        states.add("q1");
        states.add("q2");
        Transition transition = new Transition("q0", "1", "q1");
        Transition transition1 = new Transition("q0", "0", "q0");
        Transition transition2 = new Transition("q1", "0", "q1");
        Transition transition3 = new Transition("q1", "1", "q2");
        Transition transition4 = new Transition("q2", "1", "q1");
        Transition transition5 = new Transition("q2", "0", "q2");
        ArrayList<Transition> transitions = new ArrayList<>();
        transitions.add(transition);
        transitions.add(transition1);
        transitions.add(transition2);
        transitions.add(transition3);
        transitions.add(transition4);
        transitions.add(transition5);
        DFA dfa = new DFA(alphabets, states, transitions, "q0", "q2");
        assertTrue(dfa.isLanguagePasses());

    }
@Test
    public void test_dfa_will_return_true_if_string_not_passes_for_even_number_of_1_have_more_than_two_states() throws Exception {
        ArrayList<String> alphabets = new ArrayList<>();
        alphabets.add("1");
        alphabets.add("1");
        alphabets.add("1");
        ArrayList<String> states = new ArrayList<>();
        states.add("q0");
        states.add("q1");
        states.add("q2");
        Transition transition = new Transition("q0", "1", "q1");
        Transition transition1 = new Transition("q0", "0", "q0");
        Transition transition2 = new Transition("q1", "0", "q1");
        Transition transition3 = new Transition("q1", "1", "q2");
        Transition transition4 = new Transition("q2", "1", "q1");
        Transition transition5 = new Transition("q2", "0", "q2");
        ArrayList<Transition> transitions = new ArrayList<>();
        transitions.add(transition);
        transitions.add(transition1);
        transitions.add(transition2);
        transitions.add(transition3);
        transitions.add(transition4);
        transitions.add(transition5);
        DFA dfa = new DFA(alphabets, states, transitions, "q0", "q2");
        assertFalse(dfa.isLanguagePasses());

    }
    @Test
    public void test_dfa_will_return_true_if_string_passes_for_All_strings_whose_decimal_representation_is_an_even_number() throws Exception {
        ArrayList<String> alphabets = new ArrayList<>();
        alphabets.add("1");
        alphabets.add("1");
        alphabets.add("0");
        ArrayList<String> states = new ArrayList<>();
        states.add("q0");
        states.add("q1");
        states.add("q2");
        Transition transition = new Transition("q0", "1", "q2");
        Transition transition1 = new Transition("q0", "0", "q1");
        Transition transition2 = new Transition("q1", "0", "q1");
        Transition transition3 = new Transition("q1", "1", "q2");
        Transition transition4 = new Transition("q2", "1", "q1");
        Transition transition5 = new Transition("q2", "0", "q2");
        ArrayList<Transition> transitions = new ArrayList<>();
        transitions.add(transition);
        transitions.add(transition1);
        transitions.add(transition2);
        transitions.add(transition3);
        transitions.add(transition4);
        transitions.add(transition5);
        DFA dfa = new DFA(alphabets, states, transitions, "q0", "q1");
        assertTrue(dfa.isLanguagePasses());

    }
    @Test
    public void test_dfa_will_return_false_if_string_not_passes_for_All_strings_whose_decimal_representation_is_an_even_number() throws Exception {
        ArrayList<String> alphabets = new ArrayList<>();
        alphabets.add("1");
        alphabets.add("1");
        alphabets.add("1");
        ArrayList<String> states = new ArrayList<>();
        states.add("q0");
        states.add("q1");
        states.add("q2");
        Transition transition = new Transition("q0", "1", "q2");
        Transition transition1 = new Transition("q0", "0", "q1");
        Transition transition2 = new Transition("q1", "0", "q1");
        Transition transition3 = new Transition("q1", "1", "q2");
        Transition transition4 = new Transition("q2", "1", "q1");
        Transition transition5 = new Transition("q2", "0", "q2");
        ArrayList<Transition> transitions = new ArrayList<>();
        transitions.add(transition);
        transitions.add(transition1);
        transitions.add(transition2);
        transitions.add(transition3);
        transitions.add(transition4);
        transitions.add(transition5);
        DFA dfa = new DFA(alphabets, states, transitions, "q0", "q1");
        assertFalse(dfa.isLanguagePasses());

    }
}