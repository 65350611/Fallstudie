package wwi.fallstudie.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

import haushaltsbuch.*;

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
	
	public static int gibRolle(String name)  //diese Methode sollte funktionieren
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
	
	public static boolean neuerNutzer(int userRole, String password, String name)
	{	
		int anzahl = 0;
		boolean ok = false;
	
		try
		{
			PreparedStatement prepState = con.prepareStatement
					("insert into nutzer values (?,?,?)");
			prepState.setInt(1, userRole);
			prepState.setString(2, password);
			prepState.setString(3, name);
			
			anzahl = prepState.executeUpdate();
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
		int anzahl = 0;
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
			
			anzahl = prepState.executeUpdate();
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
	{	int anzahl=0;
		boolean ok = false;
	
		try
		{
			PreparedStatement prepState = con.prepareStatement
					("insert into kategorien values (?,?)");
			prepState.setInt(1, 0);
			prepState.setString(2, catLabel);
			
			anzahl = prepState.executeUpdate();
			ok = true;
			System.out.println("Neue Kategorie hinzugefügt");
		}
		catch (SQLException e)
		{
			System.out.println("Kategorie konnte nicht hinzugefügt werden");
		}
		return ok;
}
	
	public static boolean loescheNutzer(String name)  //diese Methode sollte funktionieren
	{	int anzahl=0;
		boolean ok = false;
	
		try
		{
			PreparedStatement prepState = con.prepareStatement
					("delete from nutzer where userName=(?)");
			prepState.setString(1, name);
			
			anzahl = prepState.executeUpdate();
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

	public static boolean aenderePasswort(String name, String neuesPasswort)  //diese Methode sollte funktionieren
	{	int anzahl=0;
		boolean ok = false;
	
		try
		{
			PreparedStatement prepState = con.prepareStatement
					("update nutzer set password=(?) where userName=(?)");
			prepState.setString(1, neuesPasswort);
			prepState.setString(2, name);
			
			anzahl = prepState.executeUpdate();
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
	
	public static ResultSet gibAusgaben(String userName)//diese Methode sollte funktionieren
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
		
	public static ResultSet gibAusgabenFuerZeitraum(String userName, String beginDate, String endDate)//diese Methode sollte funktionieren
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
	
}

