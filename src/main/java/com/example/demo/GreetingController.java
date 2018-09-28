package com.example.demo;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


@RestController
public class GreetingController {
   @RequestMapping("/tree")
   public String sayHello() throws JsonParseException, JsonMappingException, IOException, ParseException {
	   
	   /*final String uri = "https://jsonplaceholder.typicode.com/todos/1";

	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);

	    System.out.println(result);
	    
	    			JSONParser jsonParser = new JSONParser();
	                JSONObject jsonObject = (JSONObject) jsonParser.parse(result);

	                // get a String from the JSON object
	                String firstName = (String) jsonObject.get("title");
	                System.out.println("The first name is title: " + firstName);*/
	   
	   String firstName = "MArR";
	   
      return firstName + " || jest!!!  ||  "+System.currentTimeMillis(); //result;
   }
}