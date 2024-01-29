package mockAPI;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.octomix.josson.Josson;
import com.octomix.josson.Jossons;
import com.octomix.josson.exception.UnresolvedDatasetException;
import org.testng.Assert;
import org.testng.collections.Maps;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;


public class compareApiResponse {

    public static void main(String[] args) throws UnresolvedDatasetException, JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        JsonNode api1 = mapper.readTree("{\n" +
                "\"name\": \"name12\",\n" +
                "\"address\": \"\",\n" +
                "\"skillset\": [\n" +
                "  {\n" +
                "    \"lang\": \"java\",\n" +
                "    \"projectName\": \"project1\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"lang\": \"c++\",\n" +
                "    \"projectName\": \"project2\"\n" +
                "  }\n" +
                "]\n" +
                "}");
        JsonNode api2 = mapper.readTree("{\n" +
                "\"name\": \"name12\",\n" +
                "\"address\": \"\",\n" +
                "\"skillset\": [\n" +
                "  \n" +
                "  {\n" +
                "    \"lang\": \"c++\",\n" +
                "    \"projectName\": \"project2\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"lang\": \"java\",\n" +
                "    \"projectName\": \"project1\"\n" +
                "  }\n" +
                "]\n" +
                "}");


        System.out.println(api1); // -> false
        Jossons jossons = new Jossons();
        jossons.putDataset("api1", Josson.create(api1));
        jossons.putDataset("api2", Josson.create(api2));
        System.out.println(api2);
        System.out.println(jossons.evaluateQuery("api1 = api2"));
        




    }



}



