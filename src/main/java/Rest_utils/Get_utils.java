package Rest_utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Get_utils {
    public  static Response getPerform(String endpoint, Map<String,String> header){
        return  RestAssured.given()
                .baseUri(endpoint)
                .get()
                .then().log().all().extract().response();



    }
}
