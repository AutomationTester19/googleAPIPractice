package com.googleAPI.practiceDemo;

import org.testng.annotations.Test;

import com.googleAPI.testOne.generateBodyPayload;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;


public class EndTOEnd_Validations {

	@Test
	public void verifyUpdatedValuesUsingAllMethods(){
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all()
		.queryParam("key", "qaclick123").header("Content-Type","application/json").
		when().body(generateBodyPayload.addPayload())
		.post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().asString();
		
		JsonPath js = new JsonPath(response);
		String place_id = js.getString("place_id");
		System.out.println("Place ID --------> " +place_id);
		
		String getResponse = given().log().all()
				.queryParam("key", "qaclick123").queryParam("place_id", place_id).
				header("Content-Type","application/json").
				when().body(generateBodyPayload.addPayload())
				.get("maps/api/place/get/json")
				.then().assertThat().statusCode(200).extract().asString();
		
	JsonPath js1 = new JsonPath(getResponse);
		String oldAddress = js1.getString("address");
		System.out.println("OLD Address ----------> " +oldAddress);
		
		String newAddress = "LingamPally Hyderabad 500019";
		
				given().log().all().
				queryParam("key", "qaclick123").queryParam("place_id", place_id).
				header("Content-Type","application/json").
				when().body(generateBodyPayload.updatePayload(newAddress,place_id))
				.put("maps/api/place/update/json")
				.then().assertThat().statusCode(200).
				body("msg", equalTo("Address successfully updated"));
				
		
	}
}
