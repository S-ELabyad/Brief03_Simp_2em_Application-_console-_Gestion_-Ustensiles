package com.Ustensiles.app.models;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public class Conection {

	Connection conn;
	Statement stat;
	ResultSet rs;
	
	public void Connect() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/gestion_des_ustensiles", "root" , "");
			//System.out.println("ok");
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
