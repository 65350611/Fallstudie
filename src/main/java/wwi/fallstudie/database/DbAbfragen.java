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
	
	public static String gibPasswort(String name)  
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
	
	public static int gibRolle(String name)  
	{
		int p = 0;
		try
		{
			PreparedStatement prepState = con.prepareStatement
					("select userRole from nutzer where userName=(?)");
			prepState.setString(1, name);
			
			ResultSet rs = prepState.executeQuery();
						
			while (rs.next())
			{
				p = rs.getInt("userRole");

				System.out.println(p);
			}
						
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		
		return p;

	}
	
	public static int gibKategorie(int catID)  
	{
		int p = 0;
		try
		{
			PreparedStatement prepState = con.prepareStatement
					("select catLabel from kategorien where catID=(?)");
			prepState.setInt(1, catID);
			
			ResultSet rs = prepState.executeQuery();
						
			while (rs.next())
			{
				p = rs.getInt("category");

				System.out.println(p);
			}
						
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		
		return p;

	}
	
	public static ResultSet gibAusgaben(String userName)
	{	
		ResultSet rs = null;
		try {
			
			PreparedStatement prepState = con.prepareStatement
					("select * from ausgaben where name=(?) order by date");
			prepState.setString(1, userName);
			
			rs = prepState.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
	
		   int columnsNumber = rsmd.getColumnCount();
		   while (rs.next()) {
		       for (int i = 1; i <= columnsNumber; i++) {
		           if (i > 1) System.out.print(",  ");
		           String columnValue = rs.getString(i);
		           System.out.print(columnValue);
		       }
		      System.out.println("");
		   }
		}
		       catch (SQLException e)
				{
					System.out.println("Ausgabe konnte nicht ausgegeben werden");
					System.out.println(e);
				}
		return rs;
		   }
		
	public static ResultSet gibAusgabenFuerZeitraum(String userName, String beginDate, String endDate)
	{	
		ResultSet rs = null;
		try {
			
			PreparedStatement prepState = con.prepareStatement
					("select * from ausgaben where name=(?) and date between (?) and (?) order by date");
			prepState.setString(1, userName);
			prepState.setString(2, beginDate);
			prepState.setString(3, endDate);
			
			rs = prepState.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
	
		   int columnsNumber = rsmd.getColumnCount();
		   while (rs.next()) {
		       for (int i = 1; i <= columnsNumber; i++) {
		           if (i > 1) System.out.print(",  ");
		           String columnValue = rs.getString(i);
		           System.out.print(columnValue);
		       }
		      System.out.println("");
		   }
		}
		       catch (SQLException e)
				{
					System.out.println("Ausgabe konnte nicht ausgegeben werden");
					System.out.println(e);
				}
		return rs;
		   }
	
	public static ResultSet gibAusgabenFuerKategorie(String userName, int catID)
	{	
		ResultSet rs = null;
		try {
			
			PreparedStatement prepState = con.prepareStatement
					("select * from ausgaben where name=(?) and category=(?) order by date");
			prepState.setString(1, userName);
			prepState.setInt(2, catID);
			
			rs = prepState.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
	
		   int columnsNumber = rsmd.getColumnCount();
		   while (rs.next()) {
		       for (int i = 1; i <= columnsNumber; i++) {
		           if (i > 1) System.out.print(",  ");
		           String columnValue = rs.getString(i);
		          System.out.print(columnValue);
		       }
		      System.out.println("");
		   }
		}
		       catch (SQLException e)
				{
					System.out.println("Ausgabe konnte nicht ausgegeben werden");
					System.out.println(e);
				}
		return rs;
		   }
	
	public static boolean neuerNutzer(int userRole, String password, String name)
	{	
		boolean ok = false;
	
		try
		{
			PreparedStatement prepState = con.prepareStatement
					("insert into nutzer values (?,?,?)");
			prepState.setInt(1, userRole);
			prepState.setString(2, password);
			prepState.setString(3, name);
			
			prepState.executeUpdate();
			ok = true;
			System.out.println("Neuer Nutzer hinzugefügt!");
		}
		catch (SQLException e)
		{
			System.out.println("Nutzer konnte nicht hinzugefügt werden");
		}
		return ok;
}
	
	public static boolean neueAusgabe(String expLabel, String name, int category, float amount, Date date)
	{	
		boolean ok = false;
	
		try
		{
			PreparedStatement prepState = con.prepareStatement
					("insert into ausgaben values (?,?,?,?,?,?)");
			prepState.setInt(1, 0);
			prepState.setString(2, expLabel);
			prepState.setString(3, name);
			prepState.setInt(4, category);
			prepState.setFloat(5, amount);
			prepState.setDate(6, date);
			
			prepState.executeUpdate();
			ok = true;
			System.out.println("Neue Ausgabe hinzugefügt");
		}
		catch (SQLException e)
		{
			System.out.println("Ausgabe konnte nicht hinzugefügt werden");
		}
		return ok;
}
	
	public static boolean neueKategorie(String catLabel)
	{	
		boolean ok = false;
	
		try
		{
			PreparedStatement prepState = con.prepareStatement
					("insert into kategorien values (?,?)");
			prepState.setInt(1, 0);
			prepState.setString(2, catLabel);
			
			prepState.executeUpdate();
			ok = true;
			System.out.println("Neue Kategorie hinzugefügt");
		}
		catch (SQLException e)
		{
			System.out.println("Kategorie konnte nicht hinzugefügt werden");
		}
		return ok;
}
	
	public static boolean loescheNutzer(String name)  
	{
		boolean ok = false;
	
		try
		{
			PreparedStatement prepState = con.prepareStatement
					("delete from nutzer where userName=(?)");
			prepState.setString(1, name);
			
			prepState.executeUpdate();
			ok = true;
			System.out.println("Nutzer gelöscht");
											
		}
		catch (SQLException e)
		{
			System.out.println("Nutzer konnte nicht gelöscht werden");
			System.out.println(e);
		}
		return ok;
}
	
	public static boolean loescheAusgabe(String name, int expID)  
	{	
		boolean ok = false;
	
		try
		{
			PreparedStatement prepState = con.prepareStatement
					("delete from ausgaben where name=(?) and expID=(?)");
			prepState.setString(1, name);
			prepState.setInt(2, expID);
			
			prepState.executeUpdate();
			ok = true;
			System.out.println("Ausgabe gelöscht");
											
		}
		catch (SQLException e)
		{
			System.out.println("Ausgabe konnte nicht gelöscht werden");
			System.out.println(e);
		}
		return ok;
}
	
	public static boolean loescheKategorie(String name, int catID)  
	{	
		boolean ok = false;
	
		try
		{
			PreparedStatement prepState = con.prepareStatement
					("delete from ausgaben where name=(?) and category=(?)");
			prepState.setString(1, name);
			prepState.setInt(2, catID);
			
			prepState.executeUpdate();
			ok = true;
			System.out.println("Kategorie gelöscht");
											
		}
		catch (SQLException e)
		{
			System.out.println("Kategorie konnte nicht gelöscht werden");
			System.out.println(e);
		}
		return ok;
}

	public static boolean aenderePasswort(String name, String neuesPasswort)  
	{	
		boolean ok = false;
	
		try
		{
			PreparedStatement prepState = con.prepareStatement
					("update nutzer set password=(?) where userName=(?)");
			prepState.setString(1, neuesPasswort);
			prepState.setString(2, name);
			
			prepState.executeUpdate();
			ok = true;
			System.out.println("Passwort geändert");
											
		}
		catch (SQLException e)
		{
			System.out.println("Passwort konnte nicht geändert werden");
			System.out.println(e);
		}
		return ok;
}
	
	public static boolean aendereAusgabe(String expLabel, int catID, float amount, Date date, String name, int expID)  
	{	
		boolean ok = false;
	
		try
		{
			PreparedStatement prepState = con.prepareStatement
					("update ausgaben set expLabel=(?), category=(?), amount=(?), date=(?) where name=(?) and expID=(?)");
			prepState.setString(1, expLabel);
			prepState.setInt(2, catID);
			prepState.setFloat(3, amount);
			prepState.setDate(4, date);
			prepState.setString(5, name);
			prepState.setInt(6, expID);
			
			prepState.executeUpdate();
			ok = true;
			System.out.println("Ausgabe geändert");
											
		}
		catch (SQLException e)
		{
			System.out.println("Ausgabe konnte nicht geändert werden");
			System.out.println(e);
		}
		return ok;
}
	
	public static boolean aendereKategorieDerAusgaben(String catLabelNew, String userName, int catIDOld) 
	{
		boolean ok = false;
		ResultSet rs = null;
		int catIDNew = -1;
		
		try
		{
			PreparedStatement prepState = con.prepareStatement
					("insert into kategorien values (?,?)");
			prepState.setInt(1, 0);
			prepState.setString(2, catLabelNew);
			
			prepState.executeUpdate();
			
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
			
			prepState.executeUpdate();
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

