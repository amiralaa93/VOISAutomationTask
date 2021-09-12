package cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import cucumber.runtime.model.CucumberFeature;
import tests.GET_Test;

import java.net.URISyntaxException;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

@CucumberOptions(
        //Run
        features = {"src/test/java/cucumber/features/"},
        glue = {"cucumber.steps"},
        plugin = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"},
        monochrome = true,
        publish = true)

public class TestRunner extends AbstractTestNGCucumberTests {
    private TestNGCucumberRunner testNGCucumberRunner;
    public static RemoteWebDriver connection;

    @BeforeClass(alwaysRun = true)
    public void setUpCucumber() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpClass() {
        baseURI = "http://www.colourlovers.com/";
        basePath = "api/";
    }

    @Test
    public void feature() throws URISyntaxException {
        GET_Test.test_01();
        GET_Test.test_02();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }
}