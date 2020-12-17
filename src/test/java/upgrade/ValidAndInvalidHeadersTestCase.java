package upgrade;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.http.Header;
import io.restassured.http.Headers;

import static io.restassured.RestAssured.*;

public class ValidAndInvalidHeadersTestCase extends TestBase{



	@BeforeTest
	public void setUp() throws Throwable {
		initialization();

	}
	
	@SuppressWarnings("unchecked")
	@Test(priority = 1)
	void testResponseWithValidHeaders() throws Throwable
	{
		request.put("username", "coding.challenge.login@upgrade.com");
		request.put("password", "On$3XcgsW#9q");
		request.put("recaptchaToken","coding_challenge");
		source = new Header("x-cf-source-id", "coding-challenge");
		corrId = new Header("x-cf-corr-id", "7cff4a37-74bb-4b9c-a1f1-8266f60fc469");
		contentType = new Header("Content-Type","application/json");
		headers = new Headers(source, corrId,contentType);
		given().
		headers(headers).
		body(request.toJSONString()).
		when().
		post(endPoint).
		then().
		statusCode(200);



	}
	
	
	@Test(priority = 2)
	void testResponseWithInvlidHeadersInvaildCorrID() throws Throwable
	{
		
		corrId = new Header("x-cf-corr-id", "abc");
		headers = new Headers(source, corrId,contentType);

		given().
		headers(headers).
		body(request.toJSONString()).
		when().
		post(endPoint).
		then().
		statusCode(500);
	}
	
	
	@Test(priority = 2)
	void testResponseWithInvlidHeadersInvaildSourceCode()throws Throwable
	{

		
		source = new Header("x-cf-source-id", "source");
		headers = new Headers(source, corrId,contentType);

		given().
		headers(headers).
		body(request.toJSONString()).
		when().
		post(endPoint).
		then().
		statusCode(500);
	}
	
	
	@Test(priority = 2)
	void testResponseWithInvlidHeadersInvaildContent()throws Throwable
	{
		
		contentType = new Header("Content-Type","application/xml");
		headers = new Headers(source, corrId,contentType);


		given().
		headers(headers).
		body(request.toJSONString()).
		when().
		post(endPoint).
		then().
		statusCode(500);
	}
}
