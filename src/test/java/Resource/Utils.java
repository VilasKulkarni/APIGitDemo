package Resource;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {

public static RequestSpecification req;
public RequestSpecification RequestSpec() throws IOException {
	
	
	if(req == null)
	{
	
		PrintStream log = new PrintStream(new FileOutputStream("loging.txt"));
	req =new RequestSpecBuilder().setBaseUri(getInputKey("BaseURI")).addQueryParam("key", "qaclick123").
	setContentType(ContentType.JSON).
	addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log)).
	build();
	return req;
	}
	
	return req;
	
}

public ResponseSpecification ResponseSpec() {
	
	ResponseSpecification resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    return resspec;

}


public static String getInputKey(String Key) throws IOException {
	
	
	FileInputStream fi = new FileInputStream("LoginDetails.properties");
    Properties p=new Properties();
    p.load(fi);
    String Value = p.getProperty(Key);
    return Value;
	
	
}


public String getJSONPathValue(Response rs, String jsonPath) {
	
	
	JsonPath jp = new JsonPath(rs.toString());
	String JsonValue = jp.get(jsonPath);
	
	return JsonValue;
	
}




}
