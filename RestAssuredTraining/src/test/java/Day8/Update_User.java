package Day8;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

@Test
public class Update_User {
@Test
	void updateuser(ITestContext context) {
		int id = (Integer) context.getAttribute("user_id");
		JSONObject jo = new JSONObject();
		jo.put("name", "Test");
		jo.put("salary", 30000);
		String[] arr = { "Java", "Selenium", "Postman" };
		jo.put("skills", arr);

		given().contentType("application/json").body(jo.toString()).pathParam("id", id)

				.when().put("http://localhost:3000/Employee/{id}");
	}

}
