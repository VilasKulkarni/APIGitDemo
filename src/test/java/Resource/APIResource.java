package Resource;

public enum APIResource {
//enum is special class in java which has the collection of constants and Methods
	
	addPlaceAPI("/maps/api/place/add/json"),      // Methods conatns the resource values 
	getPlaceAPI("/maps/api/place/get/json"),      // Methods conatns the resource values 
    deletePlaceAPI("/maps/api/place/delete/json");  // Methods conatns the resource values 
    private String resource; 

	APIResource(String resource) {    //constuctor used to call Method which will store the Resource value in Instance varibale "resource"
		
		this.resource = resource;
		
	}
	
	
public String getresource() {    // We have implemented this geterMethod to retrivew t=stored resource values form "resource" instance varibale 
	
	
	return resource;
}


}


