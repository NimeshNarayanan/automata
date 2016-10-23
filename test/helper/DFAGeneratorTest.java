package helper;

import automata.DFA;
import org.junit.Test;
import parser.DataHolder;
import parser.JSONParserHelper;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by nimesh on 10/20/16.
 */
public class DFAGeneratorTest {

    @Test
    public void generateDFA_will_generate_dfa_from_the_tuple() throws Exception {
        List<DataHolder> dataHolders = JSONParserHelper.parseJson();
        DFAGenerator dfaGenerator = new DFAGenerator(dataHolders.get(0).getTuple());
        DFA dfa = dfaGenerator.generateDFA();
        assertTrue(dfa instanceof DFA);

    }

}