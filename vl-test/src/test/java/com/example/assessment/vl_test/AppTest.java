package com.example.assessment.vl_test;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    
  @Test
  public void addNewDeviceTest() {
	  
	  RestAssured.baseURI = "https://api.restful-api.dev/objects";
	  
	  String requestBody = "{\n" + "\"name\" : \"Apple Max Pro 1TB\" ,\n"
	  		+ "\"data\" : {\n" + "\"year\": 2023,\n"
			  +"\"price\" : 7999.99,\n"
	  		+"\"CPU model\":\"Apple ARM A7\" , \n"
			  +"\"Hard disk size\" : \"1 TB\"\n"
	  		+"}\n"
			  +"}";
	  Response response = given().contentType("application/json").body(requestBody).post();
	  
	  Assert.assertEquals(response.getStatusCode(), 200);
	  Assert.assertNotNull(response.jsonPath().getString("id"), "ID should not be null");
	  Assert.assertNotNull(response.jsonPath().getString("createdAt"), "createdAt should not be null");
	  Assert.assertEquals(response.jsonPath().getString("name"), "Apple Max Pro 1TB");
	  Assert.assertEquals(response.jsonPath().getString("year"), "2023");
	  Assert.assertEquals(response.jsonPath().getString("price"), "7999.99");
	  Assert.assertEquals(response.jsonPath().getString("CPU model"), "Apple ARM A7");
	  Assert.assertEquals(response.jsonPath().getString("Hard disk size"), "1 TB");
	  
  }
}
