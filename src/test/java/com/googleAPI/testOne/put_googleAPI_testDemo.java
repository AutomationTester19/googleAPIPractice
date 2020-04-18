package com.googleAPI.testOne;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.*;


public class put_googleAPI_testDemo {

	
	@Test
	public void validatePlaceID(){
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		 RestAssured.baseURI = "https://rahulshettyacademy.com";
		    String response = given().log().all().
		    queryParam("key", "qaclick123").
		    header("Content-Type","application/json").
		    body(generateBodyPayload.addPayload()).when().post("maps/api/place/add/json")
		                .then().assertThat().statusCode(200)
		                .header("Server" ,"Apache/2.4.18 (Ubuntu)").extract().asString();
		    JsonPath js = new JsonPath(response);
		    String place_Id = js.getString("place_id");
		    System.out.println("************* GET PLACE ID************* " +place_Id);
		    
		    String newAddress = "Lingampally";
		    
	     given().log().all().
	    queryParam("key", "qaclick123").
	    header("Content-Type","application/json").
	    body("{\r\n" + 
	    		"\"place_id\":\""+place_Id+"\",\r\n" + 
	    		"\"address\":\""+newAddress+"\",\r\n" + 
	    		"\"key\":\"qaclick123\"\r\n" + 
	    		"}\r\n" + 
	    		"").when().
	    put("maps/api/place/update/json").then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
	    
	     
	     // to check place id is updated and get the updated place id using GET
	     String placeResponce = given().log().all().
		    queryParam("key", "qaclick123").
		    queryParam("place_id", place_Id).
		   when().get("maps/api/place/get/json").then().log().all().assertThat().statusCode(200).extract().response().asString();
	     
	     JsonPath js1 = new JsonPath(placeResponce);
	     String oldAddress = js1.getString("address");
	     Assert.assertEquals(newAddress, oldAddress);
	}
}
