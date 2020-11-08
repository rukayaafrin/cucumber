package com.ce.web;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TodoSteps {
	private final OkHttpClient httpClient = new OkHttpClient();
	private String myurl = "http://";
	
	@Given("todo application is up")
	public void todo_rest_endpoint_of_is_up() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		String url = System.getProperty("base.url");
		myurl += url;
		myurl +="/";
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

	

	@When("the client calls \\/todos")
	public void the_client_calls_todos() {
	    // Write code here that turns the phrase above into concrete actions
		 Request request = new Request.Builder()
	                .url(myurl+"/todos")
	                .build();
		 try (Response response = httpClient.newCall(request).execute()) {

			// response.body().contentType().
	            //if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
	             assertTrue(response.body()!=null);
	            
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}


	@Then("the client receives status code of {int}")
	public void the_client_receives_status_code_of(Integer int1) {
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
}

