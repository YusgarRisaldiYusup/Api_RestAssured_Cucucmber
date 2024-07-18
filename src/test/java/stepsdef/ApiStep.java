package stepsdef;

import ApiPage.ApiPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ApiStep {
    ApiPage apiPage;
    public ApiStep(){
        this.apiPage = new ApiPage();
    }
    @Given("Prepare Url for {string}")
    public void prepareUrlFor(String url_Active) {
        apiPage.prepareUrlFor(url_Active);
    }

    @And("hit api get list users")
    public void hitApiGetListUsers() {
        apiPage.hitApiGetListUsers();
    }

    @And("verify status code is {int}")
    public void verifyStatusCodeIs(int status_Code) {
        apiPage.verifyStatusCodeIs(status_Code);
    }

    @Then("verify response body get list users")
    public void verifyResponseBodyGetListUsers() {
        apiPage.verifyResponseBodyGetListUsers();
    }

    @Then("Hit api for get user by id")
    public void hitApiForGetUserById() {
        apiPage.hitApiForGetUserById();
    }

    @And("verify body response for get user by id")
    public void verifyBodyResponseForGetUserById() {
        apiPage.verifyBodyResponseForGetUserById();
    }

    @And("verify using json schema {string}")
    public void verifyUsingJsonSchema(String file_Name) {
        apiPage.verifyUsingJsonSchema(file_Name);
    }

    @Then("Hit api for Create new user")
    public void hitApiForCreateNewUser() {
        apiPage.hitApiForCreateNewUser();
    }

    @And("verify body response for create new user")
    public void verifyBodyResponseForCreateNewUser() {
        apiPage.verifyBodyResponseForCreateNewUser();
    }

    @Then("Hit api for update data active user")
    public void hitApiForUpdateDataActiveUser() {
        apiPage.hitApiForUpdateDataActiveUser();
    }

    @And("verify body response for update data active user")
    public void verifyBodyResponseForUpdateDataActiveUser() {
        apiPage.verifyBodyResponseForUpdateDataActiveUser();
    }

    @Then("Hit api for Delete Active User")
    public void hitApiForDeleteActiveUser() {
        apiPage.hitApiForDeleteActiveUser();
    }

    @And("Get post from spesific user with id {int}")
    public void getPostFromSpesificUserWithId(int id_User) {
        apiPage.getPostFromSpesificUserWithId();
    }

    @And("verify body response for get post from active user")
    public void verifyBodyResponseForGetPostFromActiveUser() {
        apiPage.verifyBodyResponseForGetPostFromActiveUser();
    }
}
