package com.googleAPI.testOne;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class post_googleAPI_testDemo {

	@Test
	public void validateStatusCode(){
		
		    RestAssured.baseURI = "https://rahulshettyacademy.com";
		    given().log().all().
		    queryParam("key", "qaclick123").
		    header("Content-Type","application/json").
		    body(generateBodyPayload.addPayload()).when().post("maps/api/place/add/json")
		                .then().log().all().assertThat().statusCode(200);
		    
		}
	
	@Test
	public void validateScope(){
		 RestAssured.baseURI = "https://rahulshettyacademy.com";
		    given().log().all().
		    queryParam("key", "qaclick123").
		    header("Content-Type","application/json").
		    body(generateBodyPayload.addPayload()).when().post("maps/api/place/add/json")
		                .then().log().all().assertThat().statusCode(200)
		                .body("scope", equalTo("APP"));
		    
	}
	
	@Test
	public void validateParticularHeader(){
			 RestAssured.baseURI = "https://rahulshettyacademy.com";
			    given().log().all().
			    queryParam("key", "qaclick123").
			    header("Content-Type","application/json").
			    body(generateBodyPayload.addPayload()).when().post("maps/api/place/add/json")
			                .then().log().all().assertThat().statusCode(200)
			                .header("Server" ,"Apache/2.4.18 (Ubuntu)");
			    
	}
	
	@Test
	public void extractCompleteResponseAsString(){
		 RestAssured.baseURI = "https://rahulshettyacademy.com";
		    String response = given().log().all().
		    queryParam("key", "qaclick123").
		    header("Content-Type","application/json").
		    body(generateBodyPayload.addPayload()).when().post("maps/api/place/add/json")
		                .then().assertThat().statusCode(200)
		                .header("Server" ,"Apache/2.4.18 (Ubuntu)").extract().asString();
		    
		    System.out.println(response);
	}
	
	@Test
	public void getParticularStringValueUsingJsonPath(){
		
		 RestAssured.baseURI = "https://rahulshettyacademy.com";
		    String response = given().log().all().
		    queryParam("key", "qaclick123").
		    header("Content-Type","application/json").
		    body(generateBodyPayload.addPayload()).when().post("maps/api/place/add/json")
		                .then().assertThat().statusCode(200)
		                .header("Server" ,"Apache/2.4.18 (Ubuntu)").extract().asString();
		    
		    JsonPath js = new JsonPath(response);
		   System.out.println("Get place_id value ---> " + js.getString("place_id"));
		    
	}
}
