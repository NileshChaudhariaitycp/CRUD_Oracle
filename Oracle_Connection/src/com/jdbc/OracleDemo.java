package com.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;



public class OracleDemo {
	
	

	public static void main(String[] args) throws Exception{
	//LOAD DRIVER 
		Class.forName("oracle.jdbc.OracleDriver");
		
		// ESTABLISH THE CONNECTION BETWEEN JAVA APP AND ORACLE DATABASE 
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","CHETAK","Nilesh");
		
		//CREATE STATEMENT OBJECT 
		
		Statement st = con.createStatement();
		
		//CREATE TABLE NAME DYNAMICALLY 
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the table name :");
		String tablename = br.readLine();
		
		//WRITE A SQL QUERY 
		
		String query  = "create table "+tablename+"(ENO number(3) primary key, ENAME varchar2(10), ESAL float(5))";
		
		//EXECUTE SQL QUERY 
		
		st.executeUpdate(query);
		System.out.println(tablename+"is created successfully!");
		
		//CLOSE THE CONNECTION 
		
		st.close();
		con.close();
		

	}

}
