package com.googleAPI.handlingDynamicAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class bookDetails {

	
	public static String getbookDetails(String bookname,String isbn,String aisle,String author){
		
		String book = "{\r\n" + 
				"	\"name\": \""+bookname+"\",\r\n" + 
				"	\"isbn\": \""+isbn+"\",\r\n" + 
				"	\"aisle\": \""+aisle+"\",\r\n" + 
				"	\"author\": \""+author+"\"\r\n" + 		
				"}";
		
		return book;
	}
	
	public static String generateJsonFile(String path) throws IOException{
		
			return 	new  String(Files.readAllBytes(Paths.get(path)));
		
	}
}
