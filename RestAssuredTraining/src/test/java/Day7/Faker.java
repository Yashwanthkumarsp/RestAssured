package Day7;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.github.javafaker.Animal;

public class Faker {
@Test
void randomdata()
{
	com.github.javafaker.Faker f=new com.github.javafaker.Faker();
	String firstname = f.name().firstName();
	String lastname = f.name().lastName();
	String fullname = f.name().fullName();
	
	String ani = f.animal().name();
	
	
	
	System.out.println(firstname);
	System.out.println(lastname);
	System.out.println(fullname);
	System.out.println(ani);
	
}
}
