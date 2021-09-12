package cucumber.steps;

import cucumber.runner.TestRunner;
import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.remote.RemoteWebDriver;
import tests.GET_Test;

public class GetRequestTest extends TestRunner {
    public RemoteWebDriver driver = connection;

    @Given("^I want to execute all colour lovers pattern$")
    public void i_want_to_execute_all_colour_lovers_pattern() throws Throwable {
        RestAssured.baseURI = "http://www.colourlovers.com/";
        RestAssured.basePath = "api/patterns";
    }

    @When("^I submit the GET request$")
    public void i_submit_the_get_request() throws Throwable {
        GET_Test.test_01();
    }

    @Then("^I should get 200 Success Status Code$")
    public void i_should_get_200_success_status_code() throws Throwable {
        Response response = GET_Test.test_01();
        System.out.println(response.getStatusCode());
    }

    @After
    public void close_the_browser(Scenario scenario) {
        driver.executeScript("lambda-status=" + (scenario.isFailed() ? "failed" : "passed"));
        driver.quit();
    }
}