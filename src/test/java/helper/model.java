package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static helper.utility.pembuatEmail;

public class model {
    public static RequestSpecification request;

    public static void setUpHeader() {
         request = RestAssured.given()
                 .headers("Accept", "application/json")
                 .headers("Content-Type", "application/json")
                 .headers("Authorization", "Bearer d14bf113a205a9972f2d06ed8c01f53f2071f0a7d6d601c1c6e5578f77d42392");
    }

    public static Response getAllUser(String endpoint){
        setUpHeader();
        return request.when().get(endpoint);
    }

    public static Response getUserById(String globalId, String endpoint){
        setUpHeader();
        String finalEndPoint = endpoint + "/" + globalId;
        return request.when().get(finalEndPoint);
    }

    public static Response createNewUser(String endpoint){

        String name = "Yussgar Risaldi Yusup";
        String email = pembuatEmail();
        String gender = "male";
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("email", email);
        payload.put("gender", gender);
        payload.put("status", status);
        setUpHeader();
        return request.when().body(payload.toString()).post(endpoint);
    }

    public static Response createNewUser(String globalId, String endpoint){
        String name = "Yussgar Risaldi Yusup Edited";
        String email = pembuatEmail();
        String gender = "male";
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("email", email);
        payload.put("gender", gender);
        payload.put("status", status);
        setUpHeader();
        String  finalEndpPoint = endpoint + "/" + globalId;
        return request.when().body(payload.toString()).put(finalEndpPoint);
    }

    public static Response deletedUser(String globalId, String endpoint){
        setUpHeader();
        String  finalEndpPoint = endpoint + "/" + globalId;
        return request.when().delete(finalEndpPoint);
    }
}
