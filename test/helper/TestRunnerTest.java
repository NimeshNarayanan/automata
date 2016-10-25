package helper;

import org.junit.Test;
import parser.DataHolder;
import parser.JSONParserHelper;

import java.util.List;

import static org.junit.Assert.*;

public class TestRunnerTest {
    @Test
    public void runTest() throws Exception {
        String s = "[{\"name\":\"odd number of zeroes\",\"type\":\"dfa\",\"tuple\":{\"states\":[\"q1\",\"q2\"],\"alphabets\":[\"1\",\"0\"],\"delta\":{\"q1\":{\"0\":\"q2\",\"1\":\"q1\"},\"q2\":{\"0\":\"q1\",\"1\":\"q2\"}},\"start-state\":\"q1\",\"final-states\":[\"q2\"]},\"pass-cases\":[\"0\",\"000\",\"00000\",\"10\",\"101010\",\"010101\"],\"fail-cases\":[\"00\",\"0000\",\"1001\",\"1010\",\"001100\"]}]";
        List<DataHolder> dataHolders = JSONParserHelper.parseJson(s);
        TestRunner testRunner = new TestRunner(dataHolders);
        assertTrue(testRunner.runTest());
    }

}