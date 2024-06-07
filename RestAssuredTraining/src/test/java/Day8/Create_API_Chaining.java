package Day8;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class Create_API_Chaining {

	@Test
	void CreateUser(ITestContext context) {
		
		Faker f=new Faker();
		
		JSONObject jo = new JSONObject();
		jo.put("name", f.name().fullName());
		jo.put("salary", f.number().numberBetween(25000, 30000));
		String[] Skills = {"Java", "Manual Testing", "Automation Testing"};
		jo.put("skills", Skills);

		int id = given().contentType("application/json").body(jo.toString())

				.when().post("http://localhost:3000/Employee").jsonPath().getInt("id");

		context.setAttribute("user_id", id);

	}

}
