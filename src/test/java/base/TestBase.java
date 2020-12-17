package base;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;

import static io.restassured.RestAssured.*;


public class TestBase {


	public  JSONObject request;
	public  Header source ;
	public  Header corrId ;
	public  Header contentType ;
	public  Headers headers ;
	public final String endPoint="https://credapi.credify.tech/api/brportorch/v2/login";
	
	@SuppressWarnings("unchecked")
	public void initialization() throws Throwable
	{
		
		request= new JSONObject();
		request.put("username", "coding.challenge.login@upgrade.com");
		request.put("password", "On$3XcgsW#9q");
		request.put("recaptchaToken","coding_challenge");
		source = new Header("x-cf-source-id", "coding-challenge");
		corrId = new Header("x-cf-corr-id", "7cff4a37-74bb-4b9c-a1f1-8266f60fc469");
		contentType = new Header("Content-Type","application/json");
		headers = new Headers(source, corrId,contentType);


	}

}
