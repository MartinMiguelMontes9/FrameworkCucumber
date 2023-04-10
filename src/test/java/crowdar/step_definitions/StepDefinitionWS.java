package crowdar.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class StepDefinitionWS {

    private Response response;

    @Given("I make a GET request to url")
    public void i_make_a_get_request_to() {
        response = RestAssured.get("https://www.mercadolibre.com.ar/menu/departments");
    }

    @Then("The response status code should be {int}")
    public void the_response_status_code_should_be(int expectedStatusCode) {
        Assertions.assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @And("The response should contain the key {string}")
    public void the_response_should_contain_the_key(String key) {
        Assertions.assertTrue(response.getBody().asString().contains(key));
    }

    @And("The {string} field should not be empty")
    public void the_field_should_not_be_empty(String field) {
        JsonPath jsonPath = response.jsonPath();
        String fieldValue = jsonPath.getString(field);
        Assertions.assertNotNull(fieldValue);
        Assertions.assertFalse(fieldValue.isEmpty());
    }
}