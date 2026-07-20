import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class LoginTest {

    public void loginToApplication() {
        // Set the base URI for the API
        RestAssured.baseURI = "https://example.com/api";

        // Perform POST request to login endpoint with credentials
        given()
            .header("Content-Type", "application/json")
            .body("{\"username\": \"testuser\", \"password\": \"testpass\"}")
        .when()
            .post("/login")
        .then()
            .statusCode(200)
            .body("token", notNullValue());
    }
}