package Day7;

import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class FetchData_JSON_Ob_Ar {
	// @Test
	void test1() {
		Response res = given()
				.when().get("http://localhost:3000/Company");

		JSONObject ob = new JSONObject(res.asString());
		String name = ob.getJSONArray("Employee").getJSONObject(1).get("name").toString();
		System.out.println("Name is " + name);
	}

	@Test
	void test2() {
		Response res = given()
				.when().get("http://localhost:3000/Employee");

		JSONArray jr = new JSONArray(res.asString());
		String name = jr.getJSONObject(1).get("employee_name").toString();
		System.out.println("Name is " + name);

	}

}
