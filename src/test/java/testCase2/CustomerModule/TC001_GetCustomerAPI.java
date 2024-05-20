package testCase2.CustomerModule;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import baseTest.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.ValidatableResponse;
import pojo.TC001_GetCustomerListPOJO;
import pojo.TC001_GetCustomerListResultPOJO;
import resources.ReusableMethod;

public class TC001_GetCustomerAPI extends TestBase {
	
	
	TestBase tb;
	TC001_GetCustomerListPOJO getCustomerList;

	@BeforeClass
	public void getCustomerList() throws IOException {
		tb = new TC001_GetCustomerAPI();

		httpRequest = RestAssured.given().spec(ReusableMethod.baseURI()).log().all().
				queryParam("vendor_id", ReusableMethod.vendorId()).
				header("Content-Type", "application/json").
				header("Authorization", "Bearer "+tb.loginHubWalletAppointments());

		response = httpRequest.request(Method.GET, "/customer/get");

		ValidatableResponse validateResponse = response.then().log().all();
		validateResponse.statusCode(200);
		String body = response.getBody().asString();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		getCustomerList = objectMapper.readValue(body, TC001_GetCustomerListPOJO.class);
	}

	@Test // validate Response Body
	public void getCustomerList_API_checkResponseBody() {
		String responseBody = response.getBody().asString();
		System.out.println("Response Body :- " + responseBody);
		Assert.assertTrue(responseBody != null);
		
		List<TC001_GetCustomerListResultPOJO> result = getCustomerList.getResult();
		
		for(int i=0; i<result.size(); i++) {
			System.out.println("Customer ID :-"+result.get(i).getCustomer_id());
			System.out.println("Customer Name :-"+result.get(i).getCustomer_name());
		}
	}

	@Test // Validate Status Code
	public void getCustomerList_API_checkStatusCode() {
		int statusCode = response.getStatusCode();
		System.out.println("Status Code :- " + statusCode);
		Assert.assertEquals(statusCode, ReusableMethod.statusCode());
	}

	@Test // Validate Status Line
	public void getCustomerList_API_checkStatusLine() {
		String statusLine = response.getStatusLine();
		System.out.println("Status Line :- " + statusLine);
		Assert.assertEquals(statusLine, ReusableMethod.statusLine());
	}

	@Test // Validate Response Time
	public void getCustomerList_API_checkResponseTime() {
		long responseTime = response.getTime();
		System.out.println("Response Time :- " + responseTime);
		Assert.assertTrue(responseTime < ReusableMethod.responseTime());
	}

	@Test // Validate Content Type
	public void getCustomerList_API_checkContentType() {
		String contentType = response.header("Content-Type");
		System.out.println("Content-Type :- " + contentType);
		Assert.assertEquals(contentType, ReusableMethod.contentType());
	}

	@Test // Validate Server Type
	public void getCustomerList_API_checkServerType() {
		String serverType = response.header("Server");
		System.out.println("Server-Type :- " + serverType);
		Assert.assertEquals(serverType, ReusableMethod.serverType());
	}

	@Test // Print all Header
	public void getCustomerList_API_printAllHeader() {
		Headers allheaders = response.headers(); // capture all header from response
		System.out.println("<------------------------------------------------------------>");
		for (Header header : allheaders) {
			System.out.println(header.getName() + "  :-  " + header.getValue());

		}
		System.out.println("<------------------------------------------------------------>");
	}


}
