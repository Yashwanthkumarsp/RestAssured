package Day3;


import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeaderDemo {

	//@Test
	void header()
	{
		 Response res = given()
		
		.when()
		.get("https://www.google.com/");
		 
		 System.out.println(res.getHeader("Content-Type"));
		
		//.then()
		//.header("Content-Type", "text/html; charset=ISO-8859-1");
	}
	
	@Test
	void allheader()
	{
		Response res = given()
		
		.when()
		.get("https://www.google.com/");
		
		Headers allheader = res.getHeaders();
		for (Header hd:allheader) 
		{
			System.out.println(hd.getName()+"----> "+hd.getValue());
		}
		
		
	}
	
}
