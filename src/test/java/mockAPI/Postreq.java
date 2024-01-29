package mockAPI;

import Jsonutils.jsonReader;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import Rest_utils.PostRestutils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Postreq {

    @Test
    public void postReq() throws IOException {
        String env = System.getProperty("env") == null ? "Post" : System.getProperty("env");
        Map<String,String> data = jsonReader.getJsonAsMap("Post/ApiDetails.json");
        String endpoint =data.get("createPostEndpoint");
        Map requestPayload = Payloads.createPayloadfromMap("ASDZXC4","employee1");

        Response response =  PostRestutils.performPost(endpoint,requestPayload,new HashMap<>());

        Assert.assertEquals(response.statusCode(),201);

    }
}
