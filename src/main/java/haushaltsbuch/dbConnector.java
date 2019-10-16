package haushaltsbuch;
import java.sql.*;

public class dbConnector {
	
		static Connection con = null; 		
		static Statement stmt = null;
		
		public static void main(String[] args ) {
	
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
		
		public ausgaben zeigeAusgaben(String userName)  //diese Methode sollte funktionieren
		{	ausgaben exp = new ausgaben();
		
			try
			{
				ResultSet rs = stmt.executeQuery("select * from ausgaben where name="+userName+" order by date");
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
		}
		
		public ausgaben zeigeAusgabenProZeitraum(String userName, Date beginDate, Date endDate)  //diese Methode sollte funktionieren
		{	ausgaben exp = new ausgaben();
		
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
		}
		
		public ausgaben zeigeAusgabenProKategorieNachDatum(String userName, int catID)  //diese Methode sollte funktionieren
		{	ausgaben exp = new ausgaben();
		
			try
			{
				ResultSet rs = stmt.executeQuery("select * from ausgaben where name="+userName+" and category="+catID+" order by date desc");
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
		}
		
		public ausgaben zeigeAusgabenProKategorieNachKategorie(String userName, int catID)  //diese Methode sollte funktionieren
		{	ausgaben exp = new ausgaben();
		
			try
			{
				ResultSet rs = stmt.executeQuery("select * from ausgaben where name="+userName+" and category="+catID+" order by category desc");
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
		}
		
		public nutzer zeigeNutzer()  //diese Methode sollte funktionieren
		{	nutzer user = new nutzer();
		
			try
			{
				ResultSet rs = stmt.executeQuery("select * from nutzer");
				rs.next();
				
				user.userRole=rs.getInt("Rolle des Nutzers");
				user.name=rs.getString("Benutzername");
				user.password=rs.getString("Passwort");
							
			}
			catch (SQLException e)
			{
				System.out.println("Nutzer können nicht angezeigt werden");
			}
			return user;
		}
		
		public kategorien zeigeKategorien()  //diese Methode sollte funktionieren
		{	kategorien cat = new kategorien();
		
			try
			{
				ResultSet rs = stmt.executeQuery("select * from kategorien");
				rs.next();
				
				cat.catID=rs.getInt("Kategorien ID");
				cat.catLabel=rs.getString("Name der Kategorie");
			
			}
			catch (SQLException e)
			{
				System.out.println("Kategorien können nicht angezeigt werden");
			}
			return cat;
		}
		
		public rollen zeigeRollen()  //diese Methode sollte funktionieren
		{	rollen role = new rollen();
		
			try
			{
				ResultSet rs = stmt.executeQuery("select * from rollen");
				rs.next();
				
				role.roleID=rs.getInt("Rollen ID");
				role.roleLabel=rs.getString("Name der Rolle");
			
			}
			catch (SQLException e)
			{
				System.out.println("Kategorien können nicht angezeigt werden");
			}
			return role;
		}
			
		public int loescheAusgaben(int expID)  //diese Methode sollte funktionieren
			{	int anzahl=0;
			
				try
				{
					anzahl = stmt.executeUpdate("delete from ausgaben where expID="+expID);
													
				}
				catch (SQLException e)
				{
					System.out.println("Ausgaben können nicht gelöscht werden");
				}
				return anzahl;
		}
		
		public int loescheAlleAusgabenEinerKategorie(String name, int catID)  //diese Methode sollte funktionieren
		{	int anzahl=0;
		
			try
			{
				anzahl = stmt.executeUpdate("delete from ausgaben where name="+name+" and category="+catID);
												
			}
			catch (SQLException e)
			{
				System.out.println("Ausgaben können nicht gelöscht werden");
			}
			return anzahl;
	}
			
		public int loescheNutzer(int name)  //diese Methode sollte funktionieren
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
			
		public int loescheKategorien(int catID)  //diese Methode sollte funktionieren
			{	int anzahl=0;
			
				try
				{
					anzahl = stmt.executeUpdate("delete from kategorien where catID="+catID);
													
				}
				catch (SQLException e)
				{
					System.out.println("Kategorie konnte nicht gelöscht werden");
				}
				return anzahl;
		}
			
		public int loescheRollen(int roleID)  //diese Methode sollte funktionieren
			{	int anzahl=0;
			
				try
				{
					anzahl = stmt.executeUpdate("delete from rollen where roleID="+roleID);
													
				}
				catch (SQLException e)
				{
					System.out.println("Rolle konnte nicht gelöscht werden");
				}
				return anzahl;
		}
			
		public boolean neueAusgaben(ausgaben newExp)
			{	int anzahl=0;
				boolean ok = false;
			
				try
				{
					PreparedStatement prepState = con.prepareStatement
							("insert into ausgaben values (null,?,?,?,?,?)");
					//prepState.setInt(1, newExp.expID);
					prepState.setString(2, newExp.expLabel);
					prepState.setString(3, newExp.name);
					prepState.setInt(4, newExp.category);
					prepState.setFloat(5, newExp.amount);
					prepState.setDate(6, newExp.date);
					
					anzahl = prepState.executeUpdate();
					ok = true;
					System.out.println("Neue Ausgabe hinzugefügt");
				}
				catch (SQLException e)
				{
					System.out.println("Ausgaben können nicht hinzugefügt werden");
				}
				return ok;
		}
			
		public boolean neuerNutzer(nutzer newUser)
			{	int anzahl=0;
				boolean ok = false;
			
				try
				{
					PreparedStatement prepState = con.prepareStatement
							("insert into nutzer values (?,?,?)");
					prepState.setInt(1, newUser.userRole);
					prepState.setString(2, newUser.name);
					prepState.setString(3, newUser.password);
					
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
		
		public boolean neueKategorie(kategorien newCat)
		{	int anzahl=0;
			boolean ok = false;
		
			try
			{
				PreparedStatement prepState = con.prepareStatement
						("insert into kategorien values (null,?)");
				//prepState.setInt(1, newCat.catID);
				prepState.setString(2, newCat.catLabel);
				
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
			
		public boolean neueRolle(rollen newRole)
			{	int anzahl=0;
				boolean ok = false;
			
				try
				{
					PreparedStatement prepState = con.prepareStatement
							("insert into rollen values (null,?)");
					//prepState.setInt(1, newRole.roleID);
					prepState.setString(2, newRole.roleLabel);
					
					anzahl = prepState.executeUpdate();
					ok = true;
					System.out.println("Neue Rolle hinzugefügt");
				}
				catch (SQLException e)
				{
					System.out.println("Rolle konnte nicht hinzugefügt werden");
				}
				return ok;
		}
}