import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import parser.DataHolder;
import parser.JSONParserHelper;
import static org.junit.Assert.*;

import java.util.List;

/**
 * Created by nimesh on 10/15/16.
 */
public class JSONParserHelperTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void Test_should_parse_json_String_to_an_object() throws Exception {
        String s = "[{\"name\":\"odd number of zeroes\",\"type\":\"dfa\",\"tuple\":{\"states\":[\"q1\",\"q2\"],\"alphabets\":[\"1\",\"0\"],\"delta\":{\"q1\":{\"0\":\"q2\",\"1\":\"q1\"},\"q2\":{\"0\":\"q1\",\"1\":\"q2\"}},\"start-state\":\"q1\",\"final-states\":[\"q2\"]},\"pass-cases\":[\"0\",\"000\",\"00000\",\"10\",\"101010\",\"010101\"],\"fail-cases\":[\"00\",\"0000\",\"1001\",\"1010\",\"001100\"]}]";
        List<DataHolder> dataHolders = JSONParserHelper.parseJson(s);
        assertEquals(dataHolders.size(),1);
        assertTrue(dataHolders.get(0) instanceof DataHolder);
    }
    @Test
    public void Test_should_parse_json_file_to_an_object() throws Exception {
        String s = "./data/test_data.json";
        List<DataHolder> dataHolders = JSONParserHelper.parseJson(s);
        assertEquals(dataHolders.size(),1);
        assertTrue(dataHolders.get(0) instanceof DataHolder);
    }

    @Test
    public void Test_should_parse_json_formated_string_to_an_object() throws Exception {
        String path = "./data/test_json.json";
        List<DataHolder> dataHolders = JSONParserHelper.parseJson(path);
        assertEquals(dataHolders.size(),1);
        assertTrue(dataHolders.get(0) instanceof DataHolder);
    }

    @Test
    public void Test_should_parse_json_through_exception_for_no_file() throws Exception {
        String path = "";
        exception.expectMessage("No content error.");
        List<DataHolder> dataHolders = JSONParserHelper.parseJson(path);
    }
}