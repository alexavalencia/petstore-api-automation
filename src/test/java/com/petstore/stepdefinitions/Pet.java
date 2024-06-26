package com.petstore.stepdefinitions;



import com.petstore.constants.BasePaths;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;
import org.hamcrest.Matchers;


import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class Pet extends UIInteractions {

    private EnvironmentVariables environmentVariables;
    private String endpointBaseUrl;

    @Given("user has access to the endpoint {string}")
    public void user_has_access_to_the_endpoint(String endpoint) {
        endpointBaseUrl= EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("base.url");
        given().baseUri(endpointBaseUrl)
                .basePath(BasePaths.valueOf(endpoint).getBasePath())
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON).log().everything();

    }
    @When("user makes a request to get the pet with id {int}")
    public void user_makes_a_request_to_get_the_pet_with_id(int id) {
        when().get(String.valueOf(id));

    }
    @Then("user should get the response code {int}")
    public void user_should_get_the_response_code(int statusCode) {
        then().assertThat().statusCode(statusCode).log().everything();

    }
    @Then("user validates the response with JSON schema {string}")
    public void user_validates_the_response_with_json_schema(String path) {
        then().log().everything().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/"+path));
    }



    @Then("Error message should be {string}")
    public void error_message_should_be(String errorMessage) {
        String actualErrorMessageResponse= then().log().everything().extract().asString();
        assertThat(actualErrorMessageResponse,Matchers.equalTo(errorMessage));
    }


    @When("user perform a request to the endpoint {string} with the params")
    public void user_perform_a_request_to_the_endpoint_with_the_params(String path, DataTable dataTable) {
        List<String> rows = dataTable.asList(String.class);
        endpointBaseUrl= EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("base.url");
        given().baseUri(endpointBaseUrl)
                .basePath(BasePaths.valueOf(path).getBasePath())
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON).log().everything()
                .queryParams(rows.get(0),rows.stream().skip(1).collect(Collectors.toList()))
                .get();

    }




}
