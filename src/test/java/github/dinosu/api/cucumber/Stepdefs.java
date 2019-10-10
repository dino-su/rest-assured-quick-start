package github.dinosu.api.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class Stepdefs {
    private String username;
    private Response response;

    @Given("username is {string}")
    public void username_is(String string) {
        username = string;
    }

    @When("I access end point: \\/users\\/:username")
    public void i_access_end_point_users_username() {
        response = given().get(String.format("https://api.github.com/users/%s", username));
    }

    @When("I access end point: \\/users\\/:username\\/repo")
    public void i_access_end_point_users_username_repo() {
        response = given().get(String.format("https://api.github.com/users/%s/repos", username));
    }

    @Then("I receive JSON object contains the following")
    public void i_receive_JSON_object_contains_the_following(Map<String, String> responseFields) {
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            response.then().assertThat().body(field.getKey(), equalTo(field.getValue()));
        }
    }

    @Then("I receive JSON array contains the following")
    public void i_receive_JSON_array_contains_the_following(Map<String, String> responseFields) {
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            response.then().assertThat().body(String.format("find {it.name == '%s'}.description", field.getKey()), equalTo(field.getValue()));
        }
    }
}