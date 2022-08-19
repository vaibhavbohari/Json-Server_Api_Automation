package restAssuredCRUD;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Rest_Profile {
	
	public static RequestSpecification request;
    public static Response response;

@Test
public void getTest_Profile() {
    response = RestAssured.get( "http://localhost:3000/profile");
    response.prettyPrint();
        System.out.println("Status Code:" + response.getStatusCode());
    Assert.assertEquals(response.getStatusCode(),  200);
	}
}



