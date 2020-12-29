package StepDefenation;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;
import pojo.AddPlace;
import Resource.Utils;
import Resource.APIResource;
import Resource.TestDataBuild;

public class StepDefenation {
		ResponseSpecification resspec;
		RequestSpecification requestspec;
		Response response;
	
		
		@Given("Add Place Payload")
		public void add_place_payload() throws IOException {
		 // Write code here that till given() API method 
			
			RestAssured.baseURI="https://rahulshettyacademy.com";

			TestDataBuild data = new TestDataBuild();                 
            AddPlace jsonPayload=  data.AddPlaceLoad();
            
            Utils ut = new Utils();
            RequestSpecification rs= ut.RequestSpec();
            
            RequestSpecification requestspec = given().spec(rs).body(jsonPayload);
				
		
		}


		@When("user calls {string} with post http method")
		public void user_calls_with_post_http_method(String resourceName) {
		    // Write code here that when() API Metod
		
				
			//APIResource resource= APIResource.valueOf("addPlaceAPI");
			APIResource resource= APIResource.valueOf(resourceName);
			String apiResource = resource.getresource();
			
			Utils ut = new Utils();
			Response response =requestspec.when().post(apiResource).
					then().spec(ut.ResponseSpec()).extract().response();
		
		
		}
		@Then("the API call got success with status code {int}")
		public void the_api_call_got_success_with_status_code(Integer int1) {
		    // Write code here that validate status code sent in Args in API Json response 
		   
			String resp = response.asString();
			System.out.println(resp);
			JsonPath jp =new JsonPath(resp);
		                      
			
		}
		
		
		@Then("{string} in response body is {string}")
		public void in_response_body_is(String string, String string2) {
		    // Write code here that validate Scope and status code sent in Args in API Json response 
		    
		
			String resp = response.asString();
			System.out.println(resp);
			JsonPath jp =new JsonPath(resp);
		                      
		
		}


@Given("Add Place Payload with DataDriven {string} {string} {string}")
public void add_place_payload_with_data_driven(String name, String language, String address) throws IOException {
    
	
	RestAssured.baseURI="https://rahulshettyacademy.com";

	TestDataBuild data = new TestDataBuild();                 
    AddPlace jsonPayload=  data.AddPlaceLoad(name,language,address);
    
    Utils ut = new Utils();
    RequestSpecification rs= ut.RequestSpec();
    
    RequestSpecification requestspec = given().spec(rs).body(jsonPayload);
	
	
}


@When("verify place_Id created maps to {string} using getPalceAPI")
public void verify_place_Id_created_maps_to_using_getPalceAPI(String place_Idname)
{
	
	
	APIResource resource= APIResource.valueOf("resourceName"); //using Enum class we are retrviwing the resource 
	String apiResource = resource.getresource();    //using Enum class we are retrviwing the resource 
	
	Utils ut= new Utils();                     //Using Utils class metod geting the Json value of last POSTAPI run Keyvalue
 	String POSTplace_Id_Key= ut.getJSONPathValue(response, "place_Id");  //Using Utils class metod geting the Json value of last POSTAPI run Keyvalue
  	
 	
    
    Response rsp  = given().queryParam("key",POSTplace_Id_Key). //GET API code
 	when().get(apiResource).then().extract().response();   
    			
     String GETplace_Id_Keyname=  ut.getJSONPathValue(rsp, "place_Id");	 //Using Utils class metod geting the Json value of last GETAPI run Keyvalue	
     Assert.assertEquals(POSTplace_Id_Key, GETplace_Id_Keyname);     //Validating the POSTAPI and GETAPI place is added correctly 
	
	
	
}	


//==========================API-given() using Serilaztioncode==============================================

@Given("DeletePlace payload")
public void delete_place_payload() throws IOException {
   
	
	RestAssured.baseURI="https://rahulshettyacademy.com";

	TestDataBuild data = new TestDataBuild();                 
    AddPlace jsonPayload=  data.AddPlaceLoad();
    
    Utils ut = new Utils();
    RequestSpecification rs= ut.RequestSpec();
    
    RequestSpecification requestspec = given().spec(rs).body("addJSONPaybody");
    

}

//==========================API-when() and then() code using Serilaztioncode==============================================

@When("When user calls {String} with post http method")
public void When_user_calls_with_post_http_method(String resourceName) {
	
	
	APIResource resource= APIResource.valueOf("resourceName"); //using Enum class we are retrviwing the resource 
	String apiResource = resource.getresource();    //using Enum class we are retrviwing the resource 
	
	response= requestspec.when().post(apiResource).then().extract().response();
	
		
}

//==========================Validating the API-using the Jsonpath() class as per the test case==============================================
@Then ("Then the API call got success with status code 200")
public void Then_the_API_call_got_success_with_status_code_200() {
	
	
	Utils ut = new Utils();
	String JsonCode=  ut.getJSONPathValue(response, "statuscode");
	Assert.assertEquals("OK", JsonCode);
}











}
