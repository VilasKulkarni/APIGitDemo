Feature: Validating Place APIs using DataDriven

@add_placeAPI  @Regrasion
Scenario Outline: Verify if Palce is being Succesfully added using AddPlaceAPI
Given Add Place Payload with DataDriven "<name>" "<language>" "<address>"
When user calls "addPlaceAPI" with post http method
Then the API call got success with status code 200
And "status" in response body is "OK"
And "Scope" in response body is "APP"
And verify place_Id created maps to "<name>" using getPalceAPI # Writing the test case to verify add_PleaseId created using GET-API

Examples:
 
 |name    |language   |address  |
 |Vilas   |Kanada     | Banglore |
# |Swati   |Hindi      | Banglore |
# |Samarth |Kanada     | Banglore |
# |Samruddh|Hindi      | Banglore |
 
 # Writing the test case to remove created add_PleaseId using delete-API
 
 @delete_placeAPI @Regrasion
 Scenario: Verify if delete Place functionality is working
 Given DeletePlace payload
 When user calls "addPlaceAPI" with post http method
 Then the API call got success with status code 200
 And "status" in response body is "OK"
