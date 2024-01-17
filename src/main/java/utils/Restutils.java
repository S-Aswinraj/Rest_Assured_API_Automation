package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.Map;

public class Restutils {
    public static Response performPost(String endPoint, String requestPayoad, Map<String,String> header){
      return  RestAssured.given()
                .baseUri(endPoint)
                .contentType(ContentType.JSON)
                .body(requestPayoad)
                .post()
                .then().log().all().extract().response();


    }
}
