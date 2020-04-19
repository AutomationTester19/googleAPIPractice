package com.googleAPI.handlingDynamicAPI;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class handlingDynamicJSON_First {
	
	@DataProvider(name="bookDetails")
	public Object[][] generateBookDetails(){
				
		return new Object[][] {{"WC19","hfgs","0183","Virat"},{"WC11","udif","0183","Dhoni"}};
		}
	

	@Test(dataProvider="bookDetails")
	public void validateHandlingDynamicJson(String bookName,String isbn,String aisle,String author){
		
		RestAssured.baseURI = "http://216.10.245.166/";
		String response = given().log().all()
		.header("Content-Type","application/json")
		.body(bookDetails.getbookDetails(bookName,isbn,aisle,author))
		.when().post("Library/Addbook.php").then().assertThat().statusCode(200).extract().response().prettyPrint();		
		
		JsonPath js = new JsonPath(response);
		String id = js.getString("ID");
		System.out.println("ID ---> " +id);
	}
	
	
}
