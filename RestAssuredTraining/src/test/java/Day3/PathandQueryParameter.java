package Day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class PathandQueryParameter {
//http://localhost:3000/Employee?id=2
	
	@Test
	void param()
	{
		given()
		.pathParam("mypath", "Employee")
		.queryParam("id", 2 )
		
		.when()
		.get("http://localhost:3000/{mypath}")
		
		.then()
		.log().all();
		
	}
}
