package com.qa.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;
import org.testng.annotations.BeforeMethod;

import com.qa.client.RestClient;
import com.qa.testbase.TestBase;

public class GetApiTest extends TestBase{
	
	TestBase testBase;
	String serviceUrl;
	String apiUrl;
	String url;
	RestClient restClient;

	@BeforeMethod
	
	public void setUp() throws ClientProtocolException, IOException{
		testBase = new TestBase();
		serviceUrl = prop.getProperty("URL");
		apiUrl = prop.getProperty("ServiceUrl");
		url = serviceUrl + apiUrl;	
	}	
	
	@Test
	public void getApiTest() throws ClientProtocolException, IOException{
		restClient = new RestClient();
		restClient.get(url);
	}
}
