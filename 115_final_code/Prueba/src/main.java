import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.*;
import java.nio.file.Files;
import java.math.*;

public class main {
	private static Connection connect = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//createConnection();
		createConnectionMySQL();
        
		BufferedReader br = null;
		String[] list_of_components = null;
		String start_day = "";
		int month = 0;
		int day_of_month = 0;
		int dst_indicator = 0;
		int hour = 0;
		double start_minute = 0;
		double end_minute = 0;
		String daytype = null;
		boolean End_Dict = false;
		try{ 
			br = new BufferedReader(new FileReader("IDEASS.eso"));
		    String line = null;
		    while ((line = br.readLine()) != null) {
		        if (line.contains("hola")){break;}//I put a "hola" in the middle of the reading file to stop the program
		        
		        System.out.println(line);
		        
		        list_of_components = line.split(",");
		        if (list_of_components[0].contains("End of Data Dictionary")){
		        	End_Dict = true;
		        }
		        
		        
		        if (End_Dict){
		        	if (list_of_components[0].contentEquals("End of Data")){
			        	break;
			        }
		        	
			        try {
			            int value = Integer.parseInt(list_of_components[0].trim());
			            if (value == 2){
			            	start_day = list_of_components[1];
				        	month = Integer.parseInt(list_of_components[2].trim());
				        	day_of_month = Integer.parseInt(list_of_components[3].trim());
				        	dst_indicator = Integer.parseInt(list_of_components[4].trim());
				        	hour = Integer.parseInt(list_of_components[5].trim());
				        	start_minute = Double.parseDouble(list_of_components[6].trim());
				        	end_minute = Double.parseDouble(list_of_components[7].trim());
				        	daytype = list_of_components[8].trim();
				        }
			            if (Integer.parseInt(list_of_components[0])>5){
			            	insertValues(value, Double.parseDouble(list_of_components[1].trim()), month, day_of_month, dst_indicator, hour, start_minute, end_minute, daytype);
			            	//record_number++;
			            }
			            
			        } catch (NumberFormatException nfe) {
			            // Not an integer
			        }
			        
		        }
		        
		        
		        
		        
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
		finally {
		      close();
		}
		System.out.println("termine");
		System.out.println(month+" "+day_of_month+" "+hour+" "+daytype);
		//shutdown();
		
	}
	private static void writeMetaData(ResultSet resultSet) throws SQLException {
	    //   Now get some metadata from the database
	    // Result set get the result of the SQL query
	    
	    System.out.println("The columns in the table are: ");
	    
	    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
	    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
	      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
	    }
	  }
	private static void close() {
	    try {
	      if (resultSet != null) {
	        resultSet.close();
	      }

	      if (statement != null) {
	        statement.close();
	      }

	      if (connect != null) {
	        connect.close();
	      }
	    } catch (Exception e) {

	    }
	  }
	private static void writeResultSet(ResultSet resultSet) throws SQLException {
	    // ResultSet is initially before the first data set
	    while (resultSet.next()) {
	      // It is possible to get the columns via name
	      // also possible to get the columns via the column number
	      // which starts at 1
	      // e.g. resultSet.getSTring(2);
	      String user = resultSet.getString("myuser");
	      String website = resultSet.getString("webpage");
	      String summery = resultSet.getString("summary");
	      Date date = resultSet.getDate("datum");
	      String comment = resultSet.getString("comments");
	      System.out.println("User: " + user);
	      System.out.println("Website: " + website);
	      System.out.println("Summery: " + summery);
	      System.out.println("Date: " + date);
	      System.out.println("Comment: " + comment);
	    }
	  }
	
	private static void createConnection()
    {//this is to do it with Apache Derby DBMS
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            connect = DriverManager.getConnection("jdbc:derby:/Users/lucasrencoret/MyDB;create=true", "lucas", "lucas");
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
    }
	private static void createConnectionMySQL()
    {
        try
        {
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/Prueba_Lucas", "lucas", "lucas");
            //establish a connection
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
    }

	private static void insertValues(int id, double content, int month, int day_of_month, int dst_indicator, int hours, double start_minute, double end_minute, String daytype)
    {
        try
        {
            statement = connect.createStatement();
	    	statement.execute("insert into Prueba_Lucas.datos values (" + id + "," + content + "," + month + "," + day_of_month + "," + dst_indicator + "," + hours + "," + start_minute + "," + end_minute + ",'" + daytype +"')");
	    	statement.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }
	private static void selectRestaurants()
    {
        try
        {
        	statement = connect.createStatement();
            ResultSet results = statement.executeQuery("select * from MYKILLERAPP.MyTabelle");
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                //print Column Names
                System.out.print(rsmd.getColumnLabel(i)+"\t\t");  
            }

            System.out.println("\n-------------------------------------------------");

            while(results.next())
            {
                int id = results.getInt(1);
                int keyID = results.getInt(2);
                String content = results.getString(3);
                System.out.println(id + "\t\t" + keyID + "\t\t" + content);
            }
            results.close();
            statement.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }
	private static void shutdown()
    {//This is to shutdown Apache Derby Instance
        try
        {
            if (statement != null)
            {
                statement.close();
            }
            if (connect != null)
            {
                DriverManager.getConnection("jdbc:derby:/Users/lucasrencoret/MyDB;create=true" + ";shutdown=true");
                connect.close();
            }           
        }
        catch (SQLException sqlExcept)
        {
            
        }

    }
}
