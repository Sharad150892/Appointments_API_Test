package apiVerifications;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import io.restassured.response.Response;
import utils.ExtentReportListner;

public class APIVerification extends ExtentReportListner {

	public static void responseCodeValidation(Response response, int statusCode) {
		try {
			Assert.assertEquals(statusCode, response.getStatusCode());
			test.log(Status.PASS, "Successfully validated Status Code, Status Code is : " + response.getStatusCode());
		} catch (AssertionError e) {
			test.log(Status.FAIL,
					"Expected status code is : " + statusCode + " instead of getting : " + response.getStatusCode());
		} catch (Exception e) {
			test.log(Status.FAIL, e.fillInStackTrace());
		}
	}

	public static void responseKeyValidationFromArray(Response response, String key) {

		try {
			JSONArray array = new JSONArray(response.getBody().asString());

			for (int i = 0; i < array.length(); i++) {
//				System.out.println(array.get(i));

				JSONObject obj = array.getJSONObject(i);
				test.log(Status.INFO, "Validated values are = " + obj.get(key));

			}

		} catch (Exception e) {
			test.log(Status.FAIL, e.fillInStackTrace());
		}
	}
	
	
	public static void responseKeyValidationFromJsonObject(Response response, String key) {
		
		try {
			JSONObject json = new JSONObject(response.getBody().asString());
			if(json.has(key) && json.get(key)!= null) {
				test.log(Status.PASS, "Successfully validate value of "+ key +" It is "+json.get(key));				
			}
			else {
				test.log(Status.FAIL, "Key is not available");
			}
			
		} catch (Exception e) {
			test.log(Status.FAIL, e.fillInStackTrace());
		}
		
	}
	
	public static void responseTimeValidation(Response response) {
		
		try {
			long time = response.getTime();
			
			test.log(Status.INFO, "Response time is : "+time);
		} catch(Exception e) {
			test.log(Status.FAIL, e.fillInStackTrace());
		}
	}

}
