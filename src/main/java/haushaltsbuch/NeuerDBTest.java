package haushaltsbuch;

import java.sql.*;

public class NeuerDBTest {
	
	static Connection con;
	static Statement stmt;
	
	public NeuerDBTest() {
		
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

	public static boolean aendereKategorieDerAusgaben(String catLabelNew, String userName, int catIDOld) {	
		
		int anzahl=0;
		boolean ok = false;
		int p = 0;
		ResultSet rs = null;
		int catIDNew = -1;
		
		try
		{
			PreparedStatement prepState = con.prepareStatement
					("insert into kategorien values (?,?)");
			prepState.setInt(1, 0);
			prepState.setString(2, catLabelNew);
			
			anzahl = prepState.executeUpdate();
			
			System.out.println("Neue Kategorie hinzugefügt");
		}
		catch (SQLException e)
		{
			System.out.println("Kategorie konnte nicht hinzugefügt werden");
		}
		
		try
		{
	    rs = stmt.executeQuery("select LAST_INSERT_ID()");

	    if (rs.next()) {
	    	catIDNew = rs.getInt(1);
	    }
	    System.out.println("ID der neuen Kategorie: " + catIDNew);
		}
		catch (SQLException e)
		{
			System.out.println("ID der Kategorie konnte nicht ermittelt werden");
		}
		
		try
		{
			PreparedStatement prepState = con.prepareStatement
					("update ausgaben set category=(?) where name=(?) and category=(?)");
			prepState.setInt(1, catIDNew);
			prepState.setString(2, userName);
			prepState.setInt(3, catIDOld);
			
			anzahl = prepState.executeUpdate();
			ok = true;
			System.out.println("Kategorie geändert");
											
		}
		catch (SQLException e)
		{
			System.out.println("Kategorie konnte nicht geändert werden");
			System.out.println(e);
		}
		return ok;
	
}
}