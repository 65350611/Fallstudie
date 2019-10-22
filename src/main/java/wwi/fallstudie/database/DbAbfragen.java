package wwi.fallstudie.database;

import java.sql.*;
import java.util.ArrayList;

public class DbAbfragen {
	
	static Connection conn;
	static Statement stmt;
	
	public DbAbfragen()
	{
		
	}
	
	public static void baueVerbindungAuf()	
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Treiber gefunden");
		}
		
		catch (ClassNotFoundException e) 
		{
			System.out.println("Treiber NICHT gefunden");
			e.printStackTrace();
		}
		
		try 
		{
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/haushaltsbuch","root","");
			System.out.println("Verbindung aufgebaut");
		}
		
		catch (SQLException e) 
		{
			System.out.println("Verbindung NICHT augebaut");
			e.printStackTrace();
		}
		
		try 
		{
			stmt=conn.createStatement();
			System.out.println("Statement erzeugt");
		}
		
		catch (SQLException e) 
		{
			System.out.println("Statement NICHT erzeugt");
			e.printStackTrace();
		}  
	}
	
	public static ArrayList<String> gibNutzer()
	{	
		ResultSet rs = null;
		String user = null;
		ArrayList<String> userList = new ArrayList<String>();
		
		try 
		{
			PreparedStatement prepState = conn.prepareStatement
					("select userName from nutzer");
		
			rs = prepState.executeQuery();
			
			while (rs.next())
			{
			user = rs.getString("userName");
			userList.add(user);
			}
			
		}
		
		catch (SQLException e)
		{
			System.out.println("Nutzer konnten nicht ausgegeben werden");
			e.printStackTrace();
		}
		
		return userList;
		
	}
	
	public static String gibPasswort(String userName)
	{
		String pw = null;
		
		try
		{
			PreparedStatement prepState = conn.prepareStatement
					("select password from nutzer where userName=(?)");
			prepState.setString(1, userName);
			
			ResultSet rs = prepState.executeQuery();
						
			while (rs.next())
			{
				pw = rs.getString("password");
			}		
		}
		
		catch (SQLException e)
		{
			System.out.println("Passwort konnte nicht ausgegeben werden");
			e.printStackTrace();
		}
		
		return pw;
		
	}
	
	public static int gibRolle(String userName)
	{
		int rollNo = 0;
		
		try
		{
			PreparedStatement prepState = conn.prepareStatement
					("select userRole from nutzer where userName=(?)");
			prepState.setString(1, userName);
			
			ResultSet rs = prepState.executeQuery();
						
			while (rs.next())
			{
				rollNo = rs.getInt("userRole");
			}			
		}
		
		catch (SQLException e)
		{
			System.out.println("Rolle konnte nicht ausgegeben werden");
			e.printStackTrace();
		}
		return rollNo;
	}
	
	public static ArrayList<String> gibKategorienamen(String userName)
	{
		ResultSet rs;
		String columnValue;
		ArrayList<String> catList = new ArrayList<String>();
		
		try
		{
			PreparedStatement prepState = conn.prepareStatement
					(" select catLabel from kategorien where catID in (select distinct category from ausgaben where name=(?));");
			prepState.setString(1, userName);
			
			rs = prepState.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();

			int columnsNumber = rsmd.getColumnCount();
			
			while (rs.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					if (i > 1) System.out.print(",  ");
					columnValue = rs.getString("catLabel");
					catList.add(columnValue);		
				}
			}
		}
		
		catch (SQLException e)
		{
			System.out.println("Kategorien konnten nicht ausgegeben werden");
			e.printStackTrace();
		}
		
		return catList;
		
	}
	
	public static ArrayList<String> gibKategorienamenFuerZeitraum(String userName, String beginDate, String endDate)
	{
		ResultSet rs;
		String columnValue;
		ArrayList<String> catInTimeList = new ArrayList<String>();
		
		try
		{
			PreparedStatement prepState = conn.prepareStatement
					("select catLabel from kategorien where catID in (select distinct category from ausgaben where name=(?) and date between (?) and (?) order by date);");
			prepState.setString(1, userName);
			prepState.setString(2, beginDate);
			prepState.setString(3, endDate);
			
			rs = prepState.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();

			int columnsNumber = rsmd.getColumnCount();
			
			while (rs.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					if (i > 1);
					columnValue = rs.getString("catLabel");
					catInTimeList.add(columnValue);		
				}
			}
		}
		
		catch (SQLException e)
		{
			System.out.println("Kategorien konnten nicht ausgegeben werden");
			e.printStackTrace();
		}
		
		return catInTimeList;
		
	}
	
	public static ArrayList<String> gibAusgabenFuerZeitraumMitKategorienamen(String userName, String beginDate, String endDate)
	{
		ResultSet rs;
		String columnValue;
		ArrayList<String> catInTimeList = new ArrayList<String>();
		
		try
		{
			PreparedStatement prepState = conn.prepareStatement
					("select catLabel from kategorien where catID in (select distinct category from ausgaben where name=(?) and date between (?) and (?) order by date);");
			prepState.setString(1, userName);
			prepState.setString(2, beginDate);
			prepState.setString(3, endDate);
			
			rs = prepState.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();

			int columnsNumber = rsmd.getColumnCount();
			
			while (rs.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					if (i > 1);
					columnValue = rs.getString("catLabel");
					catInTimeList.add(columnValue);		
				}
			}
		}
		
		catch (SQLException e)
		{
			System.out.println("Kategorien konnten nicht ausgegeben werden");
			e.printStackTrace();
		}
		
		return catInTimeList;
		
	}
	
	/*public static ArrayList<String> gibKategorienDesNutzers(String userName)
	{	
		ResultSet rs;
		ResultSet rs2;
		String category = null;
		ArrayList<String> catList = new ArrayList<String>(100);
		int columnValue;
		
		try 
		{
			PreparedStatement prepState = conn.prepareStatement
					("select distinct category from ausgaben where name=(?)");
			prepState.setString(1, userName);
		
			rs = prepState.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();

			int columnsNumber = rsmd.getColumnCount();
			
			while (rs.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					if (i > 1) System.out.print(",  ");
					columnValue = rs.getInt(i);
					System.out.println(columnValue);
					
					PreparedStatement prepState2 = conn.prepareStatement
							("select catLabel from kategorien where catID=(?)");
					prepState2.setInt(1, columnValue);
					rs2 = prepState2.executeQuery();
								
					while (rs2.next())
					{
						category = rs2.getString("catLabel");
						catList.add(category);
					}
				}
			}
		}
		
		catch (SQLException e)
		{
			System.out.println("Kategorien konnten nicht ausgegeben werden");
			e.printStackTrace();
		}
		
		return catList;
		
	}
	*/
	
	public static ArrayList<String> gibAusgaben(String userName)
	{	
		String columnValue;
		ResultSet rs = null;
		ArrayList<String> expList = new ArrayList<String>();
		
		try 
		{
			PreparedStatement prepState = conn.prepareStatement
					("select * from ausgaben where name=(?) order by date");
			prepState.setString(1, userName);
			
			rs = prepState.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			columnValue = rs.toString();
	
		   int columnsNumber = rsmd.getColumnCount();
		   while (rs.next()) {
		       for (int i = 1; i <= columnsNumber; i++) {
		           if (i > 1);
		           columnValue = rs.getString(i);
		           expList.add(columnValue);		           
		       }
		   }
		}
		
		catch (SQLException e)
		{
			System.out.println("Ausgabe konnte nicht ausgegeben werden");
			e.printStackTrace();
		}
		
		return expList;
		
	}
		
	/*public static ArrayList<String> gibAusgabenFuerZeitraum(String userName, String beginDate, String endDate)
	{	
		String columnValue;
		ResultSet rs = null;
		ArrayList<String> expInTimeList = new ArrayList<String>();
		
		try 
		{
			PreparedStatement prepState = conn.prepareStatement
					("select * from ausgaben where name=(?) and date between (?) and (?) order by date");
			prepState.setString(1, userName);
			prepState.setString(2, beginDate);
			prepState.setString(3, endDate);
			
			rs = prepState.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			columnValue = rs.toString();
	
		   int columnsNumber = rsmd.getColumnCount();
		   while (rs.next()) {
		       for (int i = 1; i <= columnsNumber; i++) {
		           if (i > 1);
		           columnValue = rs.getString(i);
		           expInTimeList.add(columnValue);
		       }
		   }
		}
		       
		catch (SQLException e)
		{
			System.out.println("Ausgabe konnte nicht ausgegeben werden");
			e.printStackTrace();
		}
		
		return expInTimeList;
		
	}*/
	
	public static ArrayList<String> gibAusgabenFuerZeitraum(String userName, String beginDate, String endDate)
	{	
		String columnValue;
		ResultSet rs = null;
		ArrayList<String> expInTimeList = new ArrayList<String>();
		
		try 
		{
			PreparedStatement prepState = conn.prepareStatement
					("select sum(amount) from ausgaben where name=(?) and date between (?) and (?) group by category order by date");
			prepState.setString(1, userName);
			prepState.setString(2, beginDate);
			prepState.setString(3, endDate);
			
			rs = prepState.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			columnValue = rs.toString();
	
		   int columnsNumber = rsmd.getColumnCount();
		   while (rs.next()) {
		       for (int i = 1; i <= columnsNumber; i++) {
		           if (i > 1);
		           columnValue = rs.getString(i);
		           expInTimeList.add(columnValue);
		       }
		   }
		}
		       
		catch (SQLException e)
		{
			System.out.println("Ausgabe konnte nicht ausgegeben werden");
			e.printStackTrace();
		}
		
		return expInTimeList;
		
	}
	
	public static ArrayList<String> gibAusgabenFuerKategorie(String userName, int catID)
	{	
		String columnValue;
		ResultSet rs = null;
		ArrayList<String> expInCatList = new ArrayList<String>();
		
		try 
		{
			PreparedStatement prepState = conn.prepareStatement
					("select * from ausgaben where name=(?) and category=(?) order by date");
			prepState.setString(1, userName);
			prepState.setInt(2, catID);
			
			rs = prepState.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			columnValue = rs.toString();
	
		   int columnsNumber = rsmd.getColumnCount();
		   while (rs.next()) {
		       for (int i = 1; i <= columnsNumber; i++) {
		           if (i > 1);
		           columnValue = rs.getString(i);
		           expInCatList.add(columnValue);
		       }
		   }
		}
		
		catch (SQLException e)
		{
			System.out.println("Ausgabe konnte nicht ausgegeben werden");
			e.printStackTrace();
		}
		
		return expInCatList;
		
	}
	
	public static boolean neuerNutzer(int userRole, String password, String userName)
	{	
		boolean ok = false;
		
		try
		{
			PreparedStatement prepState = conn.prepareStatement
					("insert into nutzer values (?,?,?)");
			prepState.setInt(1, userRole);
			prepState.setString(2, password);
			prepState.setString(3, userName);
			
			prepState.executeUpdate();
			ok = true;
			System.out.println("Neuer Nutzer hinzugefügt!");
		}
		
		catch (SQLException e)
		{
			System.out.println("Nutzer konnte nicht hinzugefügt werden");
			e.printStackTrace();
		}
		
		return ok;

	}
	
	public static boolean neueAusgabe(String expLabel, String userName, int category, float amount, Date date)
	{	
		boolean ok = false;
		
		try
		{
			PreparedStatement prepState = conn.prepareStatement
					("insert into ausgaben values (?,?,?,?,?,?)");
			prepState.setInt(1, 0);
			prepState.setString(2, expLabel);
			prepState.setString(3, userName);
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
			e.printStackTrace();
		}
		
		return ok;
		
	}
	
	public static boolean neueKategorie(String catLabel)
	{	
		boolean ok = false;

		try
		{
			PreparedStatement prepState = conn.prepareStatement
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
			e.printStackTrace();
		}
		
		return ok;
		
	}
	
	public static int loescheNutzer(String userName)
	{
		int status = 0;
		int anzahl = 0;
		try
		{
			PreparedStatement prepState = conn.prepareStatement
					("delete from nutzer where userName=(?)");
			prepState.setString(1, userName);
			
			anzahl = prepState.executeUpdate();
				if (anzahl > 0) {
					status = 1;
				} else {
					status = 0;
				}
			
			System.out.println("Nutzer gelöscht");
											
		}
		
		catch (SQLException e)
		{
			System.out.println("Nutzer konnte nicht gelöscht werden");
			e.printStackTrace();
			status = -1;
		}
		
		return status;
	}
	
	public static boolean loescheAusgabe(String userName, int expID)
	{	
		boolean ok = false;
	
		try
		{
			PreparedStatement prepState = conn.prepareStatement
					("delete from ausgaben where name=(?) and expID=(?)");
			prepState.setString(1, userName);
			prepState.setInt(2, expID);
			
			prepState.executeUpdate();
			ok = true;
			System.out.println("Ausgabe gelöscht");
											
		}
		
		catch (SQLException e)
		{
			System.out.println("Ausgabe konnte nicht gelöscht werden");
			e.printStackTrace();
		}
		
		return ok;
	}
	
	public static boolean loescheAusgabenUndNutzer(String userName)
	{
		boolean ok = false;
		
		try
		{
			PreparedStatement prepState = conn.prepareStatement
					("delete from ausgaben where name=(?)");
			prepState.setString(1, userName);
			
			prepState.executeUpdate();
			ok = true;
			System.out.println("Ausgabe gelöscht");
											
		}
		
		catch (SQLException e)
		{
			System.out.println("Ausgabe konnte nicht gelöscht werden");
			e.printStackTrace();
		}
	
		try
		{
			PreparedStatement prepState = conn.prepareStatement
					("delete from nutzer where userName=(?)");
			prepState.setString(1, userName);
			
			prepState.executeUpdate();
			ok = true;
			System.out.println("Nutzer gelöscht");
											
		}
		
		catch (SQLException e)
		{
			System.out.println("Nutzer konnte nicht gelöscht werden");
			e.printStackTrace();
		}
		
		return ok;
	}
	
	public static boolean loescheKategorie(String userName, int catID)
	{	
		boolean ok = false;
	
		try
		{
			PreparedStatement prepState = conn.prepareStatement
					("delete from ausgaben where name=(?) and category=(?)");
			prepState.setString(1, userName);
			prepState.setInt(2, catID);
			
			prepState.executeUpdate();
			ok = true;
			System.out.println("Kategorie gelöscht");
											
		}
		
		catch (SQLException e)
		{
			System.out.println("Kategorie konnte nicht gelöscht werden");
			e.printStackTrace();
		}
		
		return ok;
	
	}

	public static int aenderePasswort(String userName, String newPassword)
	{	
		int anzahl = 0;
	
		try
		{
			PreparedStatement prepState = conn.prepareStatement
					("update nutzer set password=(?) where userName=(?)");
			prepState.setString(1, newPassword);
			prepState.setString(2, userName);
			
			anzahl = prepState.executeUpdate();
			
			System.out.println("Passwort geändert");
			System.out.println(anzahl);
											
		}
		
		catch (SQLException e)
		{
			System.out.println("Passwort konnte nicht geändert werden");
			e.printStackTrace();
		}
		
		return anzahl;
	}
	
	public static boolean aendereAusgabe(String expLabel, int catID, float amount, Date date, String userName, int expID)
	{	
		boolean ok = false;
	
		try
		{
			PreparedStatement prepState = conn.prepareStatement
					("update ausgaben set expLabel=(?), category=(?), amount=(?), date=(?) where name=(?) and expID=(?)");
			prepState.setString(1, expLabel);
			prepState.setInt(2, catID);
			prepState.setFloat(3, amount);
			prepState.setDate(4, date);
			prepState.setString(5, userName);
			prepState.setInt(6, expID);
			
			prepState.executeUpdate();
			ok = true;
			System.out.println("Ausgabe geändert");
											
		}
		
		catch (SQLException e)
		{
			System.out.println("Ausgabe konnte nicht geändert werden");
			e.printStackTrace();
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
			PreparedStatement prepState = conn.prepareStatement
					("insert into kategorien values (?,?)");
			prepState.setInt(1, 0);
			prepState.setString(2, catLabelNew);
			
			prepState.executeUpdate();
			System.out.println("Neue Kategorie hinzugefügt");
		}
		
		catch (SQLException e)
		{
			System.out.println("Kategorie konnte nicht hinzugefügt werden");
			e.printStackTrace();
		}
		
		try
		{
			rs = stmt.executeQuery("select LAST_INSERT_ID()");

			if (rs.next()) {
				catIDNew = rs.getInt(1);
				System.out.println("ID der neuen Kategorie: " + catIDNew);
	    	}
	    
		}
		
		catch (SQLException e)
		{
			System.out.println("ID der Kategorie konnte nicht ermittelt werden");
			e.printStackTrace();
		}
		
		try
		{
			PreparedStatement prepState = conn.prepareStatement
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
			e.printStackTrace();
		}
		
		return ok;
	
	}
	
	public static boolean aendereKategorieDerAusgabenAufSonstige(String userName, int catIDOld)
	{
		boolean ok = false;
		
		try
		{
			PreparedStatement prepState = conn.prepareStatement
					("update ausgaben set category=(?) where name=(?) and category=(?)");
			prepState.setInt(1, 1);
			prepState.setString(2, userName);
			prepState.setInt(3, catIDOld);
			
			prepState.executeUpdate();
			ok = true;
			System.out.println("Kategorie auf 'Sonstige' geändert");									
		}
		
		catch (SQLException e)
		{
			System.out.println("Kategorie konnte nicht geändert werden");
			e.printStackTrace();
		}
		
		return ok;
		
	}
	
}

