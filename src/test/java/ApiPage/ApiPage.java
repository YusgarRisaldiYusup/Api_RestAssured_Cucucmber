package ApiPage;

import helper.utility;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

import static helper.endPoint.CREATE_NEW_USER;
import static helper.endPoint.GET_ALL_USERS;
import static helper.model.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiPage {

    Response res;
    String basicUrl;
    String globalId;

    public void prepareUrlFor(String url_Active) {
        switch (url_Active){
            case "GET_ALL_USERS":
              basicUrl =  GET_ALL_USERS;
             break;
            case "CREATE_NEW_USER":
                basicUrl =  CREATE_NEW_USER;
            break;
            default:
                System.out.println("input Url yang benar");
        }

    }

    public void hitApiGetListUsers() {
        res = getAllUser(basicUrl);
        System.out.println(res.getBody().asString());
    }

    public void verifyStatusCodeIs(int status_Code) {
        assertThat(res.statusCode()).isEqualTo(status_Code);
    }

    public void verifyResponseBodyGetListUsers() {
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).allMatch(g -> g.equals("male") || g.equals("female"));
        assertThat(status).allMatch(s -> s.equals("active") || s.equals("inactive"));
    }

    public void hitApiForGetUserById() {
        res = getUserById(globalId, basicUrl);
        System.out.println(res.getBody().asString());
    }

    public void verifyBodyResponseForGetUserById() {
        Integer id = res.jsonPath().getInt("id");
        String name = res.jsonPath().getString("name");
        String email = res.jsonPath().getString("email");
        String gender = res.jsonPath().getString("gender");
        String status = res.jsonPath().getString("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("male", "female");
        assertThat(status).isIn("active", "inactive");
    }

    public void verifyUsingJsonSchema(String file_Name) {
        File fileJsonValidator = utility.jsonSchema(file_Name);
    }

    public void hitApiForCreateNewUser() {
        res = createNewUser(basicUrl);
    }

    public void verifyBodyResponseForCreateNewUser() {
        Integer id = res.jsonPath().getInt("id");
        String name = res.jsonPath().getString("name");
        String email = res.jsonPath().getString("email");
        String gender = res.jsonPath().getString("gender");
        String status = res.jsonPath().getString("status");

        assertThat(id).isNotNull();
        assertThat(name).isEqualTo("Yussgar Risaldi Yusup");
        assertThat(email).isNotNull();
        assertThat(gender).isIn("male", "female");
        assertThat(status).isIn("active", "inactive");
        globalId = Integer.toString(id);
    }

    public void hitApiForUpdateDataActiveUser() {
        res = createNewUser(globalId, basicUrl);
    }

    public void verifyBodyResponseForUpdateDataActiveUser() {
        Integer id = res.jsonPath().getInt("id");
        String name = res.jsonPath().getString("name");
        String email = res.jsonPath().getString("email");
        String gender = res.jsonPath().getString("gender");
        String status = res.jsonPath().getString("status");

        assertThat(id).isNotNull();
        assertThat(name).isEqualTo("Yussgar Risaldi Yusup Edited");
        assertThat(email).isNotNull();
        assertThat(gender).isIn("male", "female");
        assertThat(status).isIn("active", "inactive");
    }

    public void hitApiForDeleteActiveUser() {
        res = deletedUser(globalId, basicUrl);
    }

    public void getPostFromSpesificUserWithId() {
    }

    public void verifyBodyResponseForGetPostFromActiveUser() {
    }
}
