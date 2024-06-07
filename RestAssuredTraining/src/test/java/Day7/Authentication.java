package Day7;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Authentication {
	@Test
	void auth() {
		given().auth().basic("postman", "password")

				.when().get("https://postman-echo.com/basic-auth")

				.then()
				// .statusCode(200)
				// .body("authenticated", equalTo(true))
				.log().all();
	}

	// @Test(priority = 1)
	void auth1() {
		given().auth().digest("postman", "password")

				.when().get("https://postman-echo.com/basic-auth")

				.then().statusCode(200).body("authenticated", equalTo(true)).log().all();
	}

	// @Test(priority = 2)
	void auth2() {
		given().auth().preemptive().basic("postman", "password")

				.when().get("https://postman-echo.com/basic-auth")

				.then().statusCode(200).body("authenticated", equalTo(true)).log().all();
	}

	// @Test //(priority = 3)
	void bearertoken() {
		String token = "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";
		given().headers("Authorization", "Bearer " + token)

				.when().get("https://api.github.com/user/repos")

				.then().statusCode(200).log().all();
	}

	// @Test //(priority = 3)
	void oauth2() {
		String token = "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";
		given().auth().oauth2(token)

				.when().get("https://api.github.com/user/repos")

				.then().statusCode(200).log().all();
	}
}
