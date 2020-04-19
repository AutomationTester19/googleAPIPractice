package com.googleAPI.practiceDemo;

import org.testng.annotations.Test;

import com.googleAPI.testOne.generateBodyPayload;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;


public class validationsOnPostCall {

	@Test
	public void verifyStatusCode(){
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all()
		.queryParam("key", "qaclick123").header("Content-Type","application/json").
		when().body(generateBodyPayload.addPayload())
		.log().all().post("maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200);
	}
	
	@Test(description="Verify Updated Address Using Put Method With Get Method")
	public void verifyUpdatedAddress(){
		/*RestAssured.baseURI = "https://rahulshettyacademy.com";
		 given().log().all()
		.queryParam("key", "qaclick123").header("Content-Type","application/json").
		when().body(generateBodyPayload.addPayload())
		.log().all().get("maps/api/place/get/json");
		
		JsonPath jsonpath = new JsonPath(response);
		String oldAddress = jsonpath.getString("address");
		System.out.println("Old Address -----------> " +oldAddress);*/
	}
}
