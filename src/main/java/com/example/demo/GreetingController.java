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
	   
/////////// WYKONAJ STRZAL REST
	   
				   restCALL rest = new restCALL();
				   String retFirtsName = rest.makeAcall();
				   
				   
/////////// OBROB WYNIKI
				   
	               String resulte = retFirtsName + " || jest!!!  ||  "+System.currentTimeMillis();
	               resulte = resulte + "\n";
	                
	               
/////////// POBIERZ POLACZENIE DO BAZY
	                
	                getDBConn getDB = new getDBConn();
	                Connection conn = getDB.getConn();
	                System.out.println("Connected to the PostgreSQL server successfully.");   
	                
	                
/////////// WYKONAJ ZAPYTANIE
	                
					makeDBStmt DB = new makeDBStmt();
					int count = DB.makeQuery(conn);
					
					
/////////// SKLEJ WYNIKI
					
	                resulte = resulte + "Persons licznik 2::" + count;
	   
      return resulte; //result;
   }
}