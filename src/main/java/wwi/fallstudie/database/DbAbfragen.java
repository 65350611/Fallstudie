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

	public static void baueVerbindungAuf4Mac()
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
<<<<<<< HEAD
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/wilhelma?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC","root","kochkoch");
=======
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/haushaltsbuch?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC","root","kochkoch");
>>>>>>> branch 'master' of https://github.com/65350611/Fallstudie.git
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
	
	public static int gibIDderKategorieNachAusgabe(int expID) 
	{
		int catID = 0;
		
		try
		{
			PreparedStatement prepState = conn.prepareStatement
					("select category from ausgaben where expID=(?);");
			prepState.setInt(1, expID);
		
			ResultSet rs = prepState.executeQuery();
		
			while (rs.next())
			{
				catID = rs.getInt("category");
			}			
		}
	
		catch (SQLException e)
		{
			System.out.println("ID der Kategorie konnte nicht ausgegeben werden");
			e.printStackTrace();
		}
		
		return catID;
	}
	
	public static int gibIDderKategorie(String catLabel, String userName)
	{
		int catID = 0;
		String s = "Sonstiges";
		
		if (catLabel.contains(s)) {
			catID = 1;
			System.out.println(catID);
		}
		
		else
		{
		
			try
			{
				PreparedStatement prepState = conn.prepareStatement
						("select distinct t1.category from ausgaben t1 join (select catID from kategorien where catLabel=(?)) t2 on (t1.category=t2.catID) where t1.name=(?);");
				prepState.setString(1, catLabel);
				prepState.setString(2, userName);
			
				ResultSet rs = prepState.executeQuery();
			
				while (rs.next())
				{
					catID = rs.getInt("category");
				}			
			}
		
			catch (SQLException e)
			{
				System.out.println("ID der Kategorie konnte nicht ausgegeben werden");
				e.printStackTrace();
			}
		
			if (catID != 0) {
				return catID;
			} 
			
			else 
			{
				int newCatID = neueKategorie(catLabel);
				catID = newCatID;	
			}
		}
		return catID;
	}
	
	public static ArrayList<String> gibKategorienamen(String userName)
	{
		ResultSet rs;
		String columnValue;
		ArrayList<String> catList = new ArrayList<String>();
		
		try
		{
			PreparedStatement prepState = conn.prepareStatement
					("select catLabel from kategorien where catID in (select distinct category from ausgaben where name=(?));");
			prepState.setString(1, userName);
			
			rs = prepState.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();

			int columnsNumber = rsmd.getColumnCount();
			
			while (rs.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					if (i > 1);
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
	
	/*public static ArrayList<String> gibAusgabenMitKategorienamen(String userName)
	{
		ResultSet rs;
		String columnValue;
		ArrayList<String> catInTimeList = new ArrayList<String>();
		
		try
		{
			PreparedStatement prepState = conn.prepareStatement
					("select catLabel from kategorien where catID in (select distinct category from ausgaben where name=(?) order by date);");
			prepState.setString(1, userName);
			
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
		
	}*/
	
	public static ArrayList<String> gibAusgaben(String userName)
	{	
		String columnValue;
		ResultSet rs = null;
		ArrayList<String> expList = new ArrayList<String>();
		
		try 
		{
			PreparedStatement prepState = conn.prepareStatement
					("select t1.expID, t1.expLabel, t1.name, t1.category, t2.catLabel as categoryName, t1.amount, t1.date from ausgaben t1 left join kategorien t2 on t1.category = t2.catID having name=(?) order by date;");
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
					("select sum(amount) from ausgaben where name=(?) group by category order by date");
			prepState.setString(1, userName);
			
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
	
	/*public static ArrayList<String> gibAusgabenFuerKategorie(String userName, int catID)
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
		
	}*/
	
	public static ArrayList<String> gibZeitraum(String userName)
	{
		String columnValue;
		ResultSet rs = null;
		ArrayList<String> TimeList = new ArrayList<String>();
		
		try 
		{
			PreparedStatement prepState = conn.prepareStatement
					("select min(date), max(date) from ausgaben where name=(?)");
			prepState.setString(1, userName);
			
			rs = prepState.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			columnValue = rs.toString();
	
		   int columnsNumber = rsmd.getColumnCount();
		   
		   while (rs.next()) {
		       for (int i = 1; i <= columnsNumber; i++) {
		           if (i > 1);
		           columnValue = rs.getString(i);
		           TimeList.add(columnValue);
		       }
		   }
		}
		
		catch (SQLException e)
		{
			System.out.println("Zeitraum konnte nicht ausgegeben werden");
			e.printStackTrace();
		}
		
		return TimeList;
		
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
	
	public static boolean neueAusgabe(String expLabel, String userName, int category, float amount, String stringDate)
	{	
		boolean ok = false;
		String strDate = stringDate;
		Date date = Date.valueOf(strDate);
				
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
	
	public static int neueKategorie(String catLabel)
	{	
		int catID = 0;
		ResultSet rs;

		try
		{
			PreparedStatement prepState = conn.prepareStatement
					("insert into kategorien values (?,?)");
			prepState.setInt(1, 0);
			prepState.setString(2, catLabel);
			
			prepState.executeUpdate();
			rs = stmt.executeQuery("select LAST_INSERT_ID()");
			
			while (rs.next()) {
			catID = rs.getInt(1);
			System.out.println("Neue Kategorie hinzugefügt");
			}
		}
		
		catch (SQLException e)
		{
			System.out.println("Kategorie konnte nicht hinzugefügt werden");
			e.printStackTrace();
		}
		
		return catID;
		
	}
	
	public static boolean aenderePasswort(String userName, String newPassword)
	{	
		boolean ok = false;
	
		try
		{
			PreparedStatement prepState = conn.prepareStatement
					("update nutzer set password=(?) where userName=(?)");
			prepState.setString(1, newPassword);
			prepState.setString(2, userName);
			
			prepState.executeUpdate();
			ok = true;
			System.out.println("Passwort geändert");
											
		}
		
		catch (SQLException e)
		{
			System.out.println("Passwort konnte nicht geändert werden");
			e.printStackTrace();
		}
		
		return ok;
	}
	
	public static boolean aendereAusgabe(int expID, String expLabel, int catID, float amount, String stringDate)
	{	
		boolean ok = false;
		String strDate = stringDate;
		Date date = Date.valueOf(strDate);
	
		try
		{
			PreparedStatement prepState = conn.prepareStatement
					("update ausgaben set expLabel=(?), category=(?), date=(?), amount=(?) where expID=(?)");
			prepState.setString(1, expLabel);
			prepState.setInt(2, catID);
			prepState.setDate(3, date);
			prepState.setFloat(4, amount);
			prepState.setInt(5, expID);
			
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
	
	public static boolean aendereAusgabeKategorieBleibt(int expID, String expLabel, float amount, String stringDate)
	{	
		boolean ok = false;
		String strDate = stringDate;
		Date date = Date.valueOf(strDate);
	
		try
		{
			PreparedStatement prepState = conn.prepareStatement
					("update ausgaben set expLabel=(?), date=(?), amount=(?) where expID=(?)");
			prepState.setString(1, expLabel);
			prepState.setDate(2, date);
			prepState.setFloat(3, amount);
			prepState.setInt(4, expID);
			
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
	
	public static boolean aendereKategorieDerAusgabenAufNeu(String catLabelNew, String userName, int catIDOld)
	{
		boolean ok = false;
		ResultSet rs = null;
		int catIDNew = 0;
		
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
			rs = stmt.executeQuery("select max(catID) from kategorien");
			
				while (rs.next()) {
					catIDNew = rs.getInt(1);
				}
				
				System.out.println("ID der neuen Kategorie: " + catIDNew);
	    
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
	
	public static boolean aendereKategorieDerAusgaben(int catIDNew, String userName, int catIDOld)
	{
		boolean ok = false;
		
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
	
	public static boolean aendereKategorieDerAusgabenAufSonstiges(String userName, int catIDOld)
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
			System.out.println("Kategorie auf 'Sonstiges' geändert");									
		}
		
		catch (SQLException e)
		{
			System.out.println("Kategorie konnte nicht geändert werden");
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
	
	public static boolean loescheAusgabe(int expID)
	{	
		boolean ok = false;
	
		try
		{
			PreparedStatement prepState = conn.prepareStatement
					("delete from ausgaben where expID=(?)");
			prepState.setInt(1, expID);
			
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

	public static boolean schliesseVerbindung()
	{
		boolean ok = false;
		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.close();
			System.out.println("Verbindung geschlossen");
		} 
		
		catch (SQLException e)
		{
			System.out.println("Verbindung konnte nicht geschlossen werden");
			e.printStackTrace();
		}
		
		return ok;
		
	}
	
}

