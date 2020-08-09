package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
	//1. GET Method without Headers:
		public void get(String url) throws ClientProtocolException, IOException{
		System.out.println("Lets Start");
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url); //http get request
		//httpClient.execute(httpget);
		CloseableHttpResponse closebaleHttpResponse =  httpClient.execute(httpget); //hit the GET URL
		
		//1. Status Code
		int statusCode = closebaleHttpResponse.getStatusLine().getStatusCode();
		System.out.println("status Code--:"+statusCode);
		
		//2. JSon String
		String responseString = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");
		JSONObject responsejson = new JSONObject(responseString);
		System.out.println("Response Json from API--:"+responsejson);
		
		//3. All Header
		Header [] headersArray = closebaleHttpResponse.getAllHeaders();
		HashMap <String, String> allHeaders = new HashMap <String, String>();
		
		for(Header header : headersArray ){
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println("Headers Array from API--:"+allHeaders);			
		
	}
}