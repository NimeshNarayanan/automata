package parser;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.System.out;

public class JSONParserHelper {

    public static List<DataHolder> parseJson(String s) throws Exception {
        if (s.isEmpty())
            throw new Exception("No content error.");
        ObjectMapper mapper = new ObjectMapper();
        List<DataHolder> data = mapper.readValue(parseToJonString(s), new TypeReference<List<DataHolder>>(){});
        return data;
    }

    private static String parseToJonString(String s) throws IOException, ParseException {
        String dataString = s;
        if(new File(s).exists()) {
            File file = new File(s);
            dataString = String.join("\n", Files.readAllLines(Paths.get(String.valueOf(file))));
        }
        if (dataString.contains("\\")) {
            String jsonString = dataString.replace("\\", "");
            dataString = jsonString.substring(1, jsonString.length() - 1);
            return dataString;
        }
        return dataString;
    }
}
