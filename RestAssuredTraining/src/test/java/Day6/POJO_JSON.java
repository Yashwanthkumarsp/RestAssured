package Day6;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class POJO_JSON {
//@Test
void pojo() throws JsonProcessingException
{
	//Serilization----> POJO to JSON
	POJO_Class po=new POJO_Class();
	po.setName("Yashwanth");
	po.setSalary(30000);
	String[] arr= {"Manual Testing", "Automation Testing", "Core Java", "API Testing"};
	po.setSkills(arr); 
	
	ObjectMapper om=new ObjectMapper();
	String jsonformat = om.writerWithDefaultPrettyPrinter().writeValueAsString(po);
	System.out.println(jsonformat);
}
@Test
void JSON_POJO() throws JsonMappingException, JsonProcessingException {
	String data="{\r\n"
			+ "  \"name\" : \"Yashwanth\",\r\n"
			+ "  \"salary\" : 30000,\r\n"
			+ "  \"skills\" : [ \"Manual Testing\", \"Automation Testing\", \"Core Java\", \"API Testing\" ]\r\n"
			+ "}";
	
	ObjectMapper om=new ObjectMapper();
	POJO_Class getdata = om.readValue(data, POJO_Class.class);
	//System.out.println(getdata.getClass());
	System.out.println(getdata.getName());
	System.out.println(getdata.getSalary());
	System.out.println(getdata.getSkills());
	System.out.println(getdata.getSkills()[0]);
}
}
