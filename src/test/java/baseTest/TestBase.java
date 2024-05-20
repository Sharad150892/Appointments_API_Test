package baseTest;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Listeners;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import utils.ExtentReportListner;

@Listeners(ExtentReportListner.class)
public class TestBase extends ExtentReportListner{
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public static String token;
	
	
	
	public String loginHubWalletAppointments() {
		Map<String, Object> credentialBody = new HashMap<>();
		credentialBody.put("pin", "61548237");
		credentialBody.put("device_id", "F693B865-6B54-403C-AE89-C0EB4F019177");

		RestAssured.baseURI = "https://dev.hubwallet.com/salon/dev_get_post";

		httpRequest = RestAssured.given().log().all().header("Content-Type", "application/json").
				body(credentialBody);

		response = httpRequest.request(Method.POST, "/login/LoginPin");

		String responseBody = response.getBody().asString();

		JsonPath js = new JsonPath(responseBody);
		token = js.getString("token");
		System.out.println("Token after Login :- " + token);
		
		ValidatableResponse validateResponse = response.then().log().all();
		validateResponse.statusCode(200);
		
		return token;
	}

}
