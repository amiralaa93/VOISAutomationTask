package BasePackage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import static io.restassured.RestAssured.*;

public class BaseTest{


    @BeforeClass
    public void setup() {
        baseURI = "http://www.colourlovers.com/";
        basePath = "api/";
    }


    @AfterTest
    public synchronized void tearDown() {
    }
}
