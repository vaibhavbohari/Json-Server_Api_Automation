package restAssuredCRUD;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Rest_Comments {
	public static RequestSpecification request;
    public static Response response;

 @Test(priority = 1)
 public void getTest_Comments() {
     response = RestAssured.get( "http://localhost:3000/comments");
     response.prettyPrint();
         System.out.println("Status Code:" + response.getStatusCode());
     Assert.assertEquals(response.getStatusCode(),  200);
 }

 @Test(priority = 2)
 public void postTest_Comments(){
     request = RestAssured.given();
     request.header("Content-Type", "application/json");
         JSONObject jsonObject = new JSONObject();
         jsonObject.put("id", 2);
         jsonObject.put("body", "XYZ");
         jsonObject.put("postId", 1);
     request.body(jsonObject.toJSONString());
     response = request.post("http://localhost:3000/comments");
         System.out.println("Status Code:" + response.getStatusCode());
     response.prettyPrint();
     Assert.assertEquals(response.getStatusCode(),  201);
 }

 @Test(priority = 3)
 public void putTest_Comments(){
     request = RestAssured.given();
     request.header("Content-type", "application/json");
         JSONObject jsonObject = new JSONObject();
         jsonObject.put("id", 2);
         jsonObject.put("body", "Games");
         jsonObject.put("postId", 1);
     request.body(jsonObject.toJSONString());
     response = request.put( "http://localhost:3000/comments/2");
         System.out.println("Status Code:" + response.getStatusCode());
     response.prettyPrint();
     Assert.assertEquals(response.getStatusCode(),  200);
 }

 @Test(priority = 4)
 public void deleteTest_Comments(){
     request = RestAssured.given();
     response = request.delete("http://localhost:3000/comments/2");
         System.out.println("Status Code:" + response.getStatusCode());
     response.prettyPrint();
     Assert.assertEquals(response.getStatusCode(),  200);
 }

}
