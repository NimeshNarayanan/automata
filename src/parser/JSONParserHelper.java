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

    public static List<DataHolder> parseJson(String data) throws Exception {
        if (data.isEmpty())
            throw new Exception("No content error.");
        ObjectMapper mapper = new ObjectMapper();
        List<DataHolder> dataHolders = mapper.readValue(parseToJonString(data), new TypeReference<List<DataHolder>>(){});
        return dataHolders;
    }

    private static String parseToJonString(String data) throws IOException, ParseException {
        String dataString = data;
        if(new File(data).exists()) {
            File file = new File(data);
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
