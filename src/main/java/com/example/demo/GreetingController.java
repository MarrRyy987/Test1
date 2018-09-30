package com.example.demo;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverPropertyInfo;



@RestController
public class GreetingController {
	
	private final String url = "jdbc:postgresql://qgrpxxclzflgqb:c80bc47f7c64ea617e553ab2825da39d509bbdc5bb283be7a3579f7a18aeb3d3@ec2-54-247-101-205.eu-west-1.compute.amazonaws.com:5432/dc0l2m58psg7rg?sslmode=require&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
	private final String user = "qgrpxxclzflgqb";
	private final String password = "c80bc47f7c64ea617e553ab2825da39d509bbdc5bb283be7a3579f7a18aeb3d3";
	
	static {
	    try {
	      Class.forName("org.postgresql.Driver");
	    } catch (ClassNotFoundException e) {
	      System.err.println("PostgreSQL DataSource unable to load PostgreSQL JDBC Driver");
	    }
	  }
	
   @RequestMapping("/tree")
   public String sayHello() throws JsonParseException, JsonMappingException, IOException, ParseException, URISyntaxException, Exception {
	   
	   ///////////// prosty rest
	   final String uri = "https://jsonplaceholder.typicode.com/todos/1";

	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);

	    System.out.println(result);
	    
	    			JSONParser jsonParser = new JSONParser();
	                JSONObject jsonObject = (JSONObject) jsonParser.parse(result);

	                // get a String from the JSON object
	                String firstName = (String) jsonObject.get("title");
	                System.out.println("The first name is title: " + firstName);
	   
	   //String firstName = "MArR";
	                Connection conn = null;
	                
	                String resulte = firstName + " || jest!!!  ||  "+System.currentTimeMillis();
	                resulte = resulte + "\n";
	                Properties props = new Properties();
	                //props.setProperty("ssl","true");

	                String usernamee = "qgrpxxclzflgqb";
	                String passwordd = "c80bc47f7c64ea617e553ab2825da39d509bbdc5bb283be7a3579f7a18aeb3d3";
	                String dbUrll = "jdbc:postgresql://ec2-54-247-101-205.eu-west-1.compute.amazonaws.com:5432/dc0l2m58psg7rg";

	                try {
						conn = DriverManager.getConnection(dbUrll, usernamee, passwordd);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						System.out.println(e1.getMessage());
						e1.printStackTrace();
						
					}
	                
	  ///////////// podlaczenie pod DB Postgre SQL
	                
	                //conn = DriverManager.getConnection(url, user, password);
					//conn = DriverManager.getConnection(url, props);
					System.out.println("Connected to the PostgreSQL server successfully.");   
	                
	                String SQL = "SELECT count(*) FROM Persons";
	                int count = 0;
	         
	                System.out.println("Przed select");
	                
	                try (
	                        Statement stmt = conn.createStatement();
	                        ResultSet rs = stmt.executeQuery(SQL)) {
	                    rs.next();
	                    count = rs.getInt(1);
	                } catch (SQLException ex) {
	                    System.out.println(ex.getMessage());
	                }
	                
	                System.out.println("Po select");
	                
	                resulte = resulte + "Persons licznik::" + count;
	   
      return resulte; //result;
   }
}