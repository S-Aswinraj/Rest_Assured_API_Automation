package Rest_utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

public class PostRestutils {
    //using object for requestPayload because it is super class of both string and map
    public static Response performPost(String endPoint, Object requestPayoad, Map<String,String> header){
      return  RestAssured.given()
                .baseUri(endPoint)
                .contentType(ContentType.JSON)
                .body(requestPayoad)
                .post()
                .then().log().all().extract().response();


    }
}
