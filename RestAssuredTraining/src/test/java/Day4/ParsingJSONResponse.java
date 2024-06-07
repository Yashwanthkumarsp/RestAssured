package Day4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJSONResponse {

	// Approach 1
	// @Test
	void response() {
		given().contentType("ContentType.json").when().get("http://localhost:3000/Company").then()// .log().all();
				.header("Content-Type", "application/json; charset=utf-8").body("Employee[0].name", equalTo("Chethan"));

	}

	// Approach 2

	// @Test
	void resvariable() {
		Response res = given().when().get("http://localhost:3000/Company");
		Assert.assertEquals(res.getStatusCode(), 200);
		Object actual = res.jsonPath().get("Employee[0].name");
		Assert.assertEquals(actual, "Chethan");
	}

	// To fetch single field value from all the jsonobjects
	@Test
	void jsonobject() {
		Response res = given()// .contentType(ContentType.JSON)
				.when().get("http://localhost:3000/Company");
		int totalsal = 0;
		// boolean status = false;
		JSONObject jo = new JSONObject(res.asString());
		for (int i = 0; i < jo.getJSONArray("Employee").length(); i++) {
			String sal = jo.getJSONArray("Employee").getJSONObject(i).get("salary").toString();
			totalsal = totalsal + Integer.parseInt(sal);

//			if(name.equals("Yashwanth"))
//			{
//				status=true;
//				break;
//			}

		}
		System.out.println(totalsal);
		// Assert.assertEquals(status, true);

	}

}
