package resources;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import baseTest.TestBase;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class ReusableMethod extends TestBase{
	
	public static RequestSpecification req;

	public static JsonPath rawToJson(String response) {

		JsonPath js1 = new JsonPath(response);

		return js1;
	}
		
	public static RequestSpecification baseURI() throws IOException
	{
		if(req==null) {
			PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
			req =new RequestSpecBuilder().setBaseUri(("https://dev.hubwallet.com/salon/dev_get_post")).
					addFilter(RequestLoggingFilter.logRequestTo(log))
					 .addFilter(ResponseLoggingFilter.logResponseTo(log))
			.setContentType(ContentType.JSON).build();
			 return req;
		}
		return req;
	}
	
	public static int vendorId() {
		int vendorId = 71;
		return vendorId;
	}
	
	public static String businessName() {
		String businessName = "Look's Salon";
		return businessName;
	}
	
	public static int statusCode() {
		int statusCode = 200;
		return statusCode;
	}
	
	public static String statusLine() {
		String statusLine = "HTTP/1.1 200 OK";
		return statusLine;
	}
	
	public static String contentType() {
		String contentType = "application/html";
		return contentType;
	}
	
	public static String serverType() {
		String serverType = "nginx/1.18.0 (Ubuntu)";
		return serverType;
	}
	
	public static int responseTime() {
		int time = 5000;
		return time;
	}


}
