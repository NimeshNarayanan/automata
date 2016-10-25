package helper;

import automata.DFA;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONObject;
import org.junit.Test;
import parser.DataHolder;
import parser.JSONParserHelper;

import java.io.PrintWriter;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by nimesh on 10/20/16.
 */
public class DFAGeneratorTest {

    @Test
    public void generateDFA_will_generate_dfa_from_the_tuple() throws Exception {
        String s = "[{\"name\":\"odd number of zeroes\",\"type\":\"dfa\",\"tuple\":{\"states\":[\"q1\",\"q2\"],\"alphabets\":[\"1\",\"0\"],\"delta\":{\"q1\":{\"0\":\"q2\",\"1\":\"q1\"},\"q2\":{\"0\":\"q1\",\"1\":\"q2\"}},\"start-state\":\"q1\",\"final-states\":[\"q2\"]},\"pass-cases\":[\"0\",\"000\",\"00000\",\"10\",\"101010\",\"010101\"],\"fail-cases\":[\"00\",\"0000\",\"1001\",\"1010\",\"001100\"]}]";
//        PrintWriter printWriter = new PrintWriter("testjson.json");
//        printWriter.println(s);
//        printWriter.close();
        List<DataHolder> dataHolders = JSONParserHelper.parseJson(s);
        DFAGenerator dfaGenerator = new DFAGenerator(dataHolders.get(0).getTuple());
        DFA dfa = dfaGenerator.generateDFA();
        assertTrue(dfa instanceof DFA);

    }

}