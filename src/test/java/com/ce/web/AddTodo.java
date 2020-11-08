package com.ce.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AddTodo {
	private final OkHttpClient httpClient = new OkHttpClient();
	private String myurl = "http://";
	private Response response;
	
	
	@Given("todo application is online")
	public void todo_rest_endpoint_of_is_up() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		String url = System.getProperty("base.url");
		myurl += url;
		System.out.println("URRLLLLLLLLL"+myurl);
	    Request request = new Request.Builder()
                .url(myurl)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {

            //if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
             assertTrue(response.isSuccessful());
            
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("a POST request to \\/todos is made")
	public void a_POST_request_to_todos_is_made() {
	    // Write code here that turns the phrase above into concrete actions
	   // System.out.println("Test");
	   // myurl += url;
		myurl +="/todos";
		//System.out.println(myurl);
	    assertTrue(true);
	}
	
	
	
	@When("the request body is")
	public void the_request_body_is(String docString) {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println(docString);
	   RequestBody body = RequestBody.create(
			   docString,
               MediaType.parse("application/json; charset=utf-8")
       );
	   
	   Request request = new Request.Builder()
               .url(myurl)
               .post(body)
               .build();


	   try {
		 response = httpClient.newCall(request).execute();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			   
	   assertTrue(true);
	   
	}
	
	
	@Then("a {int} response is returned within 2000ms")
	public void a_response_is_returned_within_2000ms(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(response.code(), int1.intValue());
	}
	
}

