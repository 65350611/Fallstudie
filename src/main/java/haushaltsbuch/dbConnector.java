package haushaltsbuch;

import java.sql.*;

public class dbConnector {
	
	public static void main(String[] args) { 
	
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Treiber gefunden");
		}
		catch (ClassNotFoundException e){
			System.out.println("TreiberNICHT gefunden");			
		}
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/haushaltsbuch","root","");
			System.out.println("Verbindung aufgebaut");
			
			try {
				stmt=con.createStatement();
			}
			catch(Exception e){
				System.out.println(e.toString());
				}
		}
		catch (SQLException e) {
			System.out.println("Verbindung NICHT augebaut");			
		}
		try {
			stmt=con.createStatement();
			System.out.println("Statement erzeugt");
		}
		catch (SQLException r) {
			System.out.println("Statement NICHT erzeugt");
		}
	}
	
	}
