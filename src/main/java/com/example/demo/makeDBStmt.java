package com.example.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class makeDBStmt {
	
	public int makeQuery( Connection conn) {
		
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
		return count;
		
	}

}
