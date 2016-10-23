package parser;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JSONParserHelper {

    public static List<DataHolder> parseJson() throws IOException, ParseException {
        ObjectMapper mapper = new ObjectMapper();
        List<DataHolder> data = mapper.readValue(parseToJonString(), new TypeReference<List<DataHolder>>(){});
        return data;
    }

    private static String parseToJonString() throws IOException, ParseException {
        String out = String.join("\n", Files.readAllLines(Paths.get("./data/test_data.json")));
        String jsonString = out.replace("\\", "");
        return jsonString.substring(1,jsonString.length()-1);
    }
}
