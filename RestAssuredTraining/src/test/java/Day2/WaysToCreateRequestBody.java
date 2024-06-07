package Day2;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class WaysToCreateRequestBody {

	//@Test(priority = 1)
	void getuser() {

		given().when().get("http://localhost:3000/Employee").then().statusCode(200).log().all();
	}

	//@Test //PostrequestBody using HaspMap
	void hashmap() {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("name", "Yash");
		data.put("salary", 25000);
		String[] Skills = { "Javascript", "Playright", "Postman" };
		data.put("skills", Skills);

		given().contentType("application/json").body(data)

				.when().post("http://localhost:3000/Employee")

				.then().statusCode(201).log().all();

	}
	//@Test
	void deleteuser()
	{
		given()
		
		.when()
		.delete("http://localhost:3000/Employee/5");
	}
	
	@Test //PostrequestBody using org.json
		void orgjson() {
			JSONObject data=new JSONObject();
			data.put("name", "Karthi");
			data.put("salary", 25000);
			String[] Skills = { "Javascript", "Playright", "Postman" };
			data.put("skills", Skills);

			given().contentType("application/json").body(data.toString())

					.when().post("http://localhost:3000/Company")

					.then().statusCode(201).log().all();
}
		
		//@Test //PostrequestBody using POJO Class
		void POJO() {
			POJO_PostRequest data=new POJO_PostRequest();
			data.setName("Puni");
			data.setSalary("25000");
			String[] Skills = { "Javascript", "Playright", "Postman" };
			data.setSkills(Skills);

			given().contentType("application/json").body(data)

					.when().post("http://localhost:3000/Employee")

					.then().statusCode(201).log().all();
		}
		
		
		//@Test //PostrequestBody using External
				void External() throws FileNotFoundException {
					File f=new File(".\\Data.json");
					
					FileReader fr=new FileReader(f);
					
					JSONTokener jt=new JSONTokener(fr);
					
					JSONObject data=new JSONObject(jt);

					given().contentType("application/json").body(data.toString())

							.when().post("http://localhost:3000/Employee")

							.then().statusCode(201).log().all();
				}
}
