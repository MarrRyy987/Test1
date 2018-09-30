package com.example.demo;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.client.RestTemplate;

public class restCALL {
	
	public String makeAcall() throws ParseException {
		///////////// prosty rest
		 String uri = "https://jsonplaceholder.typicode.com/todos/1";
		
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		
		System.out.println(result);
		
					JSONParser jsonParser = new JSONParser();
		            JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
		
		            // get a String from the JSON object
		String firstName = (String) jsonObject.get("title");
		System.out.println("The first name is title: " + firstName);
		
		return firstName;
	}

}
