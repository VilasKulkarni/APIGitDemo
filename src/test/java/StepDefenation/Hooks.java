package StepDefenation;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@delete_placeAPI")
	public void beforeScenario() throws IOException {
		
	// Write here all pre-condtion code as: pre condtion we will run stepdefenation.java file and call methods which is required to create add_placeAPI	
	
		StepDefenation m = new StepDefenation();
		m.add_place_payload();
		m.user_calls_with_post_http_method("add_placeResource");
		
		
	}





}
