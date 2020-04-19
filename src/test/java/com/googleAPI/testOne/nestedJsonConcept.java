package com.googleAPI.testOne;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class nestedJsonConcept {

	@Test(description="Verify Number Of Courses")
	public void validateNumberOfCoursesInPayload(){
		
		JsonPath js = new JsonPath(coursePayload.getCourseDetails());
		int count = js.getInt("courses.size()");
		System.out.println("Number of Courses ---> " +count);

	}
	
	@Test(description="Verify First Title of the Course")
	public void validatefirstTitle(){
		JsonPath js = new JsonPath(coursePayload.getCourseDetails());
		int count = js.getInt("courses.size()");
        for(int i=0;i<count;i++){
	                  String courseName = js.getString("courses["+i+"].title");
	                  if(courseName.equalsIgnoreCase("Selenium Python")){
	                	  System.out.println(courseName+" is at the First position ");
	                	  break;
	                  }
            }
	}
	
	@Test(description="Verify All the Course Titles && Respective Prices")
	public void validateRespectiveCourseAndPrices(){
		JsonPath js = new JsonPath(coursePayload.getCourseDetails());
		int count = js.getInt("courses.size()");
        for(int i=0;i<count;i++){
	             String courseName = js.getString("courses["+i+"].title");
	             System.out.print(courseName);
	             System.out.print(" -----> ");
	             int price  = js.getInt("courses["+i+"].price");
	             System.out.println(price);
        }
        
        System.out.println();
	}
	
	@Test(description="Verify Number Of Copies for RPA Course")
	public void validateRPACourseCopies(){
		JsonPath js = new JsonPath(coursePayload.getCourseDetails());
		int count = js.getInt("courses.size()");
		  for(int i=0;i<count;i++){
	             String courseName = js.getString("courses["+i+"].title");
	             if(courseName.equalsIgnoreCase("RPA")){
	            	 int copies = js.getInt("courses["+i+"].copies");
	            	 System.out.println("Number Of Copies "+copies+" for Course "+courseName);
	             break;
	             }
		  }
	}
	
	@Test(description="Verify the Purchase Amount")
	public void validatePurchaseAmount(){
		
		JsonPath js = new JsonPath(coursePayload.getCourseDetails());
		int purchaseAmnt = js.getInt("dashboard.purchaseAmount");
		System.out.println("Purchase Amount ------> " +purchaseAmnt);
	}
	
	
	
	@Test(description="Verify Sum of All the Course Price is Equal to PurchaseAmount")
	public void validateSumofAllCourses(){
		
		int sum=0;
		int price,copies,totalAmnt = 0,purchaseAmnt=0;
		JsonPath js = new JsonPath(coursePayload.getCourseDetails());
        int count = js.getInt("courses.size()");
		for(int i=0;i<count;i++){
			price = js.getInt("courses["+i+"].price");
			copies = js.getInt("courses["+i+"].copies");
			totalAmnt = price*copies;
			sum = sum+totalAmnt;
			
		}
		System.out.println("Total Amount of all the courses -------> " +sum);
		purchaseAmnt = js.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseAmnt);
		if(sum==purchaseAmnt)
			System.out.println("Sum of all the courses is equal to purchase Amount");
				
		Assert.assertEquals(sum, purchaseAmnt);
		
	}
}
