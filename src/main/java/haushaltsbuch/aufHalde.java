package haushaltsbuch;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class aufHalde {

	public static void main(String[] args) {
		
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
			
		public static ArrayList<String> gibAusgabenFuerZeitraum(String userName, String beginDate, String endDate)
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
		
		/*public static ArrayList<String> gibKategorienamenFuerZeitraum(String userName, String beginDate, String endDate)
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
			
		}*/

		/*public static ArrayList<String> gibAusgabenFuerZeitraum(String userName, String beginDate, String endDate)
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
			
		}*/
		
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
		

	}

}
