package mockAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Restutils;

import java.util.HashMap;

public class Postreq {

    @Test
    public void postReq(){
        String endpoint ="https://reqres.in/api/users";
        String requestPayload = "{\n" +
                "    \"name\": \"ABCDXYZ555\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        Response response =  Restutils.performPost(endpoint,requestPayload,new HashMap<>());

        Assert.assertEquals(response.statusCode(),201);

    }
}
