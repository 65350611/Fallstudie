package wwi.fallstudie.database;

import java.sql.*;

import haushaltsbuch.ausgaben;
import haushaltsbuch.kategorien;
import haushaltsbuch.nutzer;

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
			System.out.println("Neuer Nutzer hinzugefügt");
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
	
	public boolean neueKategorie(String catLabel)
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
	
/*	public int loescheNutzer(int name)  //diese Methode sollte funktionieren
	{	int anzahl=0;
	
		try
		{
			anzahl = stmt.executeUpdate("delete from nutzer where name="+name);
											
		}
		catch (SQLException e)
		{
			System.out.println("Nutzer konnte nicht gelöscht werden");
		}
		return anzahl;
}

	
	/*public static ausgaben zeigeAusgaben(String userName)  //diese Methode sollte funktionieren
	{	ausgaben exp = new ausgaben();
	
		try
		{
			PreparedStatement prepState = con.prepareStatement
					("select * from ausgaben where name=(?) order by date");
			prepState.setString(1, userName);
			
			ResultSet rs = prepState.executeQuery();

			while (rs.next())
			{
			
			int expID=rs.getInt("expID");
			String expLabel=rs.getString("expLabel");
			String name=rs.getString("name");
			int category=rs.getInt("category");
			Float amount=rs.getFloat("amount");
			Date date=rs.getDate("date");
			
			}
						
		}
		catch (SQLException e)
		{
			System.out.println("Ausgaben können nicht angezeigt werden");
			System.out.println(e);
		}
		return exp.toString();
	}
	/*
	public static ausgaben zeigeAusgabenProZeitraum(String userName, String beginDate, String endDate)  //diese Methode sollte funktionieren
	{		
		try
		{
			ResultSet rs = stmt.executeQuery("select * from ausgaben where name="+userName+" and date between "+beginDate+" and "+endDate+" order by date"); //woher kommen beginDate und endDate?
			rs.next();
			
			exp.expID=rs.getInt("Ausgaben ID");
			exp.expLabel=rs.getString("Bezeichnung");
			exp.name=rs.getString("Nutzer");
			exp.category=rs.getInt("Kategorie");
			exp.amount=rs.getFloat("Betrag");
			exp.date=rs.getDate("Datum");
						
		}
		catch (SQLException e)
		{
			System.out.println("Ausgaben können nicht angezeigt werden");
		}
		return exp;
	}*/
	
}

