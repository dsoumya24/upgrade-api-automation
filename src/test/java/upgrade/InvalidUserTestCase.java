package upgrade;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;


import static io.restassured.RestAssured.*;


public class InvalidUserTestCase extends TestBase{


	@BeforeTest
	public void setUp() throws Throwable {
		initialization();

	}

	@SuppressWarnings("unchecked")
	@Test(priority=1)
	void testResponseWithInValidUser() throws Throwable
	{

		request.put("username", "abc@abc.com");
		given().
		headers(headers).
		body(request.toJSONString()).
		when().
		post(endPoint).
		then().
		statusCode(401);

	}
	
	@SuppressWarnings("unchecked")
	@Test(priority=1)
	void testResponseWithInValidPassword() throws Throwable
	{

		request.put("password", "On$3");
		given().
		headers(headers).
		body(request.toJSONString()).
		when().
		post(endPoint).
		then().
		statusCode(401);
	}
	
	@SuppressWarnings("unchecked")
	@Test(priority=1)
	void testResponseWithInValidToken() throws Throwable
	{

		request.put("recaptchaToken","xy");
		given().
		headers(headers).
		body(request.toJSONString()).
		when().
		post(endPoint).
		then().
		statusCode(401);

	}
}
