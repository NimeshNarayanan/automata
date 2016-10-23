package helper;

import org.junit.Test;
import parser.DataHolder;
import parser.JSONParserHelper;

import java.util.List;

import static org.junit.Assert.*;

public class TestRunnerTest {
    @Test
    public void runTest() throws Exception {
        List<DataHolder> dataHolders = JSONParserHelper.parseJson();
        TestRunner testRunner = new TestRunner(dataHolders);
        assertTrue(testRunner.runTest());
    }

}