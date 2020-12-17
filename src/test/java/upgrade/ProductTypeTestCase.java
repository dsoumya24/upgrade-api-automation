package upgrade;

import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ProductTypeTestCase  extends TestBase{

	@BeforeTest
	public void setup() throws Throwable
	{
		initialization();
	}

	
	@Test
	public void validateProductType()
	{
	
		Response response=given().
				headers(headers).
				body(request.toJSONString()).
				when().
				post(endPoint).
				then().contentType(ContentType.JSON).extract().response();
		List<Map<String, String>> loansInReview = response.jsonPath().getList("loansInReview");
		
		Assert.assertEquals(loansInReview.get(0).get("productType"), "PERSONAL_LOAN", "Values dont match");

		//}
	}

}
