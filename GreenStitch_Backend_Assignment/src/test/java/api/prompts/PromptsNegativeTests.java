package api.prompts;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PromptsNegativeTests {

    /**
     * methodName: verifyGetPromptReturns404WhenPromptIdDoesNotExist
     * Test: Verify that the API returns a 404 status code when a non-existent prompt ID is provided.
     */
    @Test
    @Tag("api")
    @Tag("negative")
    public void verifyGetPromptReturns404WhenPromptIdDoesNotExist() {
        // Use a very unlikely/non-existent ID; prefer a UUID-like value to avoid collisions.
        final String nonExistentPromptId = "00000000-0000-0000-0000-000000000000";

        // Assumes RestAssured.baseURI/basePath and auth are configured globally per blueprint.
        Response response = RestAssured
            .given()
                .accept(ContentType.JSON)
            .when()
                .get("/prompts/{promptId}", nonExistentPromptId)
            .then()
                .extract()
                .response();

        assertThat("Expected HTTP 404 for non-existent prompt ID", response.statusCode(), is(404));

        // Optional defensive checks (do not assume exact error contract).
        // If the API returns JSON error bodies, validate it's not a successful payload.
        String contentType = response.getHeader("Content-Type");
        if (contentType != null) {
            assertThat(contentType.toLowerCase(), containsString("application/json"));
        }
    }
}
