package wwi.fallstudie.database;

import java.sql.*;

public class DbAbfragen {
	
	Connection con = null;
	static Statement stmt = null;  //sdnw
	
	public DbAbfragen() {
		
	}
	
	public void baueVerbindungAuf() {
		
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
	
	public static String zeigeNutzer(String name)  //diese Methode sollte funktionieren
	{
		String p = null;
		
		try
		{
			ResultSet rs = stmt.executeQuery("select password from nutzer where name="+name);
			while (rs.next())
			{
				//String n = rs.getString("Benutzername");
				p = rs.getString("Passwort");
				//int rid = rs.getInt("Rolle des Benutzers");
				//System.out.println(n+" "+p+" "+rid);
			}
						
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		
		return p;

	}
	
}

