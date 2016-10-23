package tuple;

import java.util.List;

public class States {

    private final List<String> states;

    public States(List<String> state) {
        this.states = state;
    }

    public boolean isEmpty() {
        return this.states.isEmpty();
    }
}
