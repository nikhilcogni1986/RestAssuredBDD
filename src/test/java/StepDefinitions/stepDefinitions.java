package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestDataBuild;
import resources.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class stepDefinitions extends Utils {
  RequestSpecification complete_request;
  ResponseSpecification resspec;
  Response response;
  TestDataBuild T1 = new TestDataBuild();

  @Given("Add Place Payload with {string} {string} {string}")
  public void add_place_payload(String name, String address, String language) throws IOException {
    complete_request = given().spec(createRequestSpecification()).body(T1.addPlaceData(name, address, language));
  }

  @When("User calls {string} with Post http request")
  public void user_calls_with_post_http_request(String string) {
    resspec =
            new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

    response =
        complete_request
            .when()
            .post("/maps/api/place/add/json")
            .then()
            .spec(resspec)
            .extract()
            .response();
  }

  @Then("API returns a success with the status code {int}")
  public void api_returns_a_success_with_the_status_code(Integer int1) {
    assertEquals(response.getStatusCode(), 200);
  }

  @Then("{string} in response body is {string}")
  public void in_response_body_is(String keyValue, String expectedValue) {
    String r = response.asString();
    System.out.println(r);
    JsonPath js = new JsonPath(r);
    assertEquals(js.get(keyValue).toString(), expectedValue);
  }
}
