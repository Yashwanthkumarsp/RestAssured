package Day1;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HTTPRequest {

	int id;

	@Test(priority = 1)
	void getusers() {
		given()

				.when().get("http://localhost:3000/Employee/2")

				.then().statusCode(200).log().all();
	}

	// @Test(priority = 2)
	void createuser() {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("employee_name", "Salaar");
		data.put("employee_salary", 25000);
		data.put("employee_age", 25);

		id = given().contentType("application/json").body(data)

				.when().post("http://localhost:3000/Employee").jsonPath().getInt("id");

		// .then().statusCode(201).log().all();
	}

	// @Test(priority = 3, dependsOnMethods = {"createuser"})
	void updateuser() {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("employee_name", "Salaar");
		data.put("employee_salary", 26000);
		data.put("employee_age", 26);

		given().contentType("application/json").body(data)

				.when().put("http://localhost:3000/Employee/" + id)

				.then().statusCode(200).log().all();
	}

	// @Test(priority = 4)
	void deleteuser() {
		given()

				.when().delete("http://localhost:3000/Employee/" + id)

				.then().statusCode(200).log().all();
	}
}
