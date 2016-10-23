import jdk.nashorn.internal.parser.JSONParser;
import org.junit.Test;
import parser.DataHolder;
import parser.JSONParserHelper;
import static org.junit.Assert.*;

import java.util.List;

/**
 * Created by nimesh on 10/15/16.
 */
public class JSONParserHelperTest {
    @Test
    public void Test_should_parse_json_to_an_object() throws Exception {
        List<DataHolder> dataHolders = JSONParserHelper.parseJson();
        assertEquals(dataHolders.size(),1);
        assertTrue(dataHolders.get(0) instanceof DataHolder);
    }
}