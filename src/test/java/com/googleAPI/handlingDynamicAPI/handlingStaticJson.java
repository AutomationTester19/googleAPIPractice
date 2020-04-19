package com.googleAPI.handlingDynamicAPI;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class handlingStaticJson {

	
	@Test
	public void staticJsonPayload() throws IOException{
			
			RestAssured.baseURI = "http://216.10.245.166/";
			String response = given().log().all()
			.header("Content-Type","application/json")
			.body(bookDetails.generateJsonFile("C:\\Users\\DIGVIJAY\\Desktop\\book.json"))
			.when().post("Library/Addbook.php").then().assertThat().statusCode(200).extract().response().prettyPrint();		
			
			JsonPath js = new JsonPath(response);
			String id = js.getString("ID");
			System.out.println("ID ---> " +id);
		}
	}

