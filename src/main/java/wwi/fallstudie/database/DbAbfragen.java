package wwi.fallstudie.database;

import java.sql.*;

public class DbAbfragen {
	
	static Connection con;
	static Statement stmt;
	
	public DbAbfragen() {
		
	}
	
	public static void baueVerbindungAuf() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Treiber gefunden");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Treiber NICHT gefunden");			
		}
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/haushaltsbuch","root","");
			System.out.println("Verbindung aufgebaut");
		}
		catch (SQLException e) {
			System.out.println("Verbindung NICHT augebaut");
		}
		try {
			stmt=con.createStatement();
			System.out.println("Statement erzeugt");
		}
		catch (SQLException e) {
			System.out.println("Statement NICHT erzeugt");
		}  //Konstruktor für die Verbindung
	}
	
	public static String gibPasswort(String name)  //diese Methode sollte funktionieren
	{
		String p = null;
		try
		{
			PreparedStatement prepState = con.prepareStatement
					("select password from nutzer where userName=(?)");
			prepState.setString(1, name);
			
			ResultSet rs = prepState.executeQuery();
						
			while (rs.next())
			{
				p = rs.getString("password");

				System.out.println(p);
			}
						
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		
		return p;

	}
	
	public static String gibRolle(String name)  //diese Methode sollte funktionieren
	{
		String p = null;
		try
		{
			PreparedStatement prepState = con.prepareStatement
					("select userRole from nutzer where userName=(?)");
			prepState.setString(1, name);
			
			ResultSet rs = prepState.executeQuery();
						
			while (rs.next())
			{
				p = rs.getString("userRole");

				System.out.println(p);
			}
						
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		
		return p;

	}
	
}

