package Day8;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {
@Test
void getuser(ITestContext context)
{
	int id=(Integer) context.getAttribute("user_id");
	
	given()
	.pathParam("id", id)
	
	.when()
	.get("http://localhost:3000/Employee/{id}")
	
	.then()
	.log().all();
}
}
