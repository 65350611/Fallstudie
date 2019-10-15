package haushaltsbuch;
import java.sql.*;

public class dbConnector {
	
		Connection con = null; 		
		Statement stmt = null;
		
		public dbConnector()
		{
	
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
				ResultSet rs = stmt.executeQuery("select * from ausgaben where name="+userName);
				rs.next();
				
				exp.expLabel=rs.getString("Bezeichnung");
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
			
			public int loescheAusgaben(int expID)  //diese Methode sollte funktionieren
			{	int anzahl=0;
			
				try
				{
					anzahl = stmt.executeUpdate("delete * from ausgaben where expID="+expID);
													
				}
				catch (SQLException e)
				{
					System.out.println("Ausgaben können nicht gelöscht werden");
				}
				return anzahl;
		}
			
			public boolean neueAusgaben(ausgaben newExp)
			{	int anzahl=0;
				boolean ok = false;
			
				try
				{
					PreparedStatement prepState = con.prepareStatement
							("insert into ausgaben values (?,?,?,?,?)");
													
				}
				catch (SQLException e)
				{
					System.out.println("Ausgaben können nicht gelöscht werden");
				}
				return anzahl;
		}
		
}

/* try {
String name1 = "test";
String pass1 = "12345";
int rollNr = 1;

PreparedStatement ps = con.prepareStatement("INSERT INTO kategorien (userName, password, userRole) VALUES (?, ?, ?)");
for (int i=0; i < 1; i++)
 { 
 
 ps.setString(1, name1);
 ps.setString(2, pass1);
 ps.setInt(3, 1);

 ps.executeUpdate();
 }
 ps.close(); 
}

catch(Exception e){System.out.println(e.toString());}
con.close();}*/


		
		
		
		
	
	
	