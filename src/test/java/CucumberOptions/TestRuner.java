package CucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Feature",plugin ="json:target/jsonReports/cucumber-report.json", glue= {"StepDefenation"})
public class TestRuner {

}


//tags= {"@delete_placeAPI"}