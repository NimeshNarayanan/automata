package parser;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;
import java.util.Map;
import java.util.Set;

//@RequiredArgsConstructor
//@AllArgsConstructor
//@Setter
//@Getter
//@EqualsAndHashCode
//@ToString
public class Tuple {
    private List<String> states;
    private List<String> alphabets;
    private Map<String, Map<String, String>> delta;
    @JsonProperty("start-state") String initialState;
    @JsonProperty("final-states")Set<String> finalStates;

    public List<String> getStates() {
        return states;
    }

    public void setStates(List<String> states) {
        this.states = states;
    }

    public List<String> getAlphabets() {
        return alphabets;
    }

    public void setAlphabets(List<String> alphabets) {
        this.alphabets = alphabets;
    }

    public Map<String, Map<String, String>> getDelta() {
        return delta;
    }

    public void setDelta(Map<String, Map<String, String>> delta) {
        this.delta = delta;
    }

    public String getInitialState() {
        return initialState;
    }

    public void setInitialState(String initialState) {
        this.initialState = initialState;
    }

    public Set<String> getFinalStates() {
        return finalStates;
    }

    public void setFinalStates(Set<String> finalStates) {
        this.finalStates = finalStates;
    }
}