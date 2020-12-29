Feature: Validating Place APIs

Scenario: Verify if Palce is being Succesfully added using AddPlaceAPI
Given Add Place Payload
When user calls "AddPlaceAPI" with post http method
Then the API call got success with status code 200
And "status" in response body is "OK"
And "Scope" in response body is "APP"