package tuple;

import java.util.List;

/**
 * Created by nimesh on 10/11/16.
 */
public class Alphabets{

    private final List<String> alphabets;

    public Alphabets(List<String> alphabets ) {
        this.alphabets = alphabets;
    }
    public boolean isValidAlphabet(String alphabet){
        return this.alphabets.contains(alphabet);
    }
    public boolean isEmpty(){
       return this.alphabets.isEmpty();
    }
}
