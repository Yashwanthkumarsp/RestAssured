package Day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Iterator;
import java.util.Map;

public class CookiesDemo {

	// @Test
	void cookie()

	{
		given()

				.when().get("https://www.google.com/")

				.then().cookie("AEC", "Ae3NU9Nx8zw1B7Qpb9UiDEOmIUdBRJuRvyzY8FyQVDZcDcTXdwD3sMN2BlQ");
	}

	// @Test
	void cookieinfo() {
		Response res = given()

				.when().get("https://www.google.com/");

		String cookie_value = res.getCookie("AEC");
		System.out.println("Cookie value is -----> " + cookie_value);
	}

	// @Test
	void getallcookies() {
		Response res = given()

				.when().get("https://www.google.com/");

		Map<String, String> allcookies = res.getCookies();
		System.out.println(allcookies.keySet());

		for (String k : allcookies.keySet()) {
			System.out.println(k + "     " + res.getCookie(k));

		}
	}

	@Test
	void getallCookies() {
		Response res = given().when().get("https://www.google.com/");

		Map<String, String> all_Cookies = res.getCookies();
		for (String k : all_Cookies.keySet()) {
			System.out.println(k + "       " + res.getCookie(k));
		}

	}

}
