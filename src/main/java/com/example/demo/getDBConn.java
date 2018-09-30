package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class getDBConn {
	
	public Connection getConn() {
		
		Connection conn = null;
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
        
        return conn;
		
	}

}
