package Jsonutils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class jsonReader {
    private static ObjectMapper objectMapper = new ObjectMapper(); //import from jackson not from restassuresd

    public static Map<String,String> getJsonAsMap(String jsonFileName) throws IOException {
        String jsonFilePath = System.getProperty("user.dir")+"/src/test/resources/"+ jsonFileName;
        Map<String,String> data =objectMapper.readValue(new File(jsonFilePath),new TypeReference<>(){});
        return data;
    }
}
