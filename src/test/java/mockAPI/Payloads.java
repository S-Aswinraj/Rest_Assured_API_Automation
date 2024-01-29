package mockAPI;

import java.util.HashMap;
import java.util.Map;

public class Payloads {
    public static String createPayloadfromString(String name,String job){
        String payload = "{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"job\": \""+job+"\"\n" +
                "}";
        return payload;
    }
    public static Map<String, Object> createPayloadfromMap(String name, String job){
        Map<String,Object> payload = new HashMap<>();
        payload.put("name",name);
        payload.put("job",job);
        return payload;
    }
}
