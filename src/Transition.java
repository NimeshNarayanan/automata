/**
 * Created by nimesh on 10/11/16.
 */
public class Transition {
    private final String current_state;
    private final String alphabet;
    private final String next_state;

    public Transition(String current_state, String alphabet, String next_state) {
        this.current_state = current_state;
        this.alphabet = alphabet;
        this.next_state = next_state;
    }
     public boolean isNextState(String current_state,String alphabet){
         return this.current_state.equals(current_state) && this.alphabet.equals(alphabet);
     }

    public String getNext_state() {
        return next_state;
    }
}
