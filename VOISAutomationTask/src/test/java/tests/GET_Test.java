package tests;

import BasePackage.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.greaterThan;

public class GET_Test extends BaseTest {

    @Test
    public static Response test_01() {

        Response response = get(baseURI + basePath);
        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());
        return response;
    }

    @Test
    public static Response test_02() throws URISyntaxException {

        System.out.println(baseURI + basePath);
        given()
                .accept(ContentType.ANY)
                .when()
                .get(new URI("patterns"))
                .then()
                .body("patterns.pattern.numViews", greaterThan(4000))
                .log().body();
        return null;
    }
}
