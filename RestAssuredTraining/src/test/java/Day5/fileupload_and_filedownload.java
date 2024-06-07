package Day5;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

public class fileupload_and_filedownload {
	//@Test
	void uploadsinglefile()
	{
		File f=new File("C:/Users/HP/Downloads/Testing Data/PPE/1.jpg");
		given()
		.multiPart("file",f)
		.contentType("multipart/form-data")
		.when()
		.post("http://localhost:8080/uploadFile")
		
		.then()
		.statusCode(200)
		.body("fileName", equalTo("1.jpg"))
		.log().all();
		
	}

	//@Test
	void uploadmultipltfile() {
		File f1 = new File("C:/Users/HP/Downloads/Testing Data/PPE/1.jpg");
		File f2 = new File("C:/Users/HP/Downloads/Testing Data/PPE/2.jpg");
		
		given().multiPart("files", f1)
		.multiPart("files", f2)
		.contentType("multipart/form-data")
		
		.when()
		.post("http://localhost:8080/uploadMultipleFiles")

		.then()
		.statusCode(200)
		.body("[0].fileName", equalTo("1.jpg"))
		.body("[1].fileName", equalTo("2.jpg"))
		.log().all();
	}
	
	@Test
	void filedownload()
	{
		given()
		
		.when()
		.get("http://localhost:8080/downloadFile/1.jpg")

		.then()
		.statusCode(200)
		.log().all();
	}
	
}
