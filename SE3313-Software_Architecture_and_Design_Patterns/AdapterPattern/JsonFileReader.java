import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

import java.io.IOException;

public class JsonFileReader implements Service {
    @Override
    public String readDataFile(String filepath) {
        ObjectMapper mappter = new ObjectMapper();
        try {
            Object json = mappter.readValue(new File(filepath), Object.class);
            return mappter.writerWithDefaultPrettyPrinter().writeValueAsString(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
