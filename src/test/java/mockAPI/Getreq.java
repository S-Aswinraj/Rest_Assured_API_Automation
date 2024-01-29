package mockAPI;

import Jsonutils.jsonReader;
import Rest_utils.Get_utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Getreq {
    @Test
    public void getReq() throws IOException {
        String env = System.getProperty("env") == null ? "Get" : System.getProperty("env");
        Map<String,String> data = jsonReader.getJsonAsMap("Get/ApiDetails.json");
        String endpoint = data.get("createGetEndpoint");

        Response response = Get_utils.getPerform(endpoint,new HashMap<>());
        Assert.assertEquals(response.statusCode(),200);


    }
}
