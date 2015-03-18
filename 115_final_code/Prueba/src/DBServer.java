import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.*;
import java.nio.file.Files;
import java.math.*;
import java.net.ServerSocket;
import java.net.Socket;


public class DBServer {

   
   

   public static void main(String[] args) {

      
      
      Timer t = new Timer();
      Reading mReading = new Reading();
      // This task is scheduled to run every 1 seconds

      t.scheduleAtFixedRate(mReading, 0, 1000);
      
     
	     
	  
	  
	     
      System.out.println("Done");
      
   }
}
   
class Reading extends TimerTask{
	   private static Connection connect = null;
	   private static Statement statement = null;
	   private static ResultSet resultSet = null;
	   private static BufferedWriter bw = null;
	   public Reading(){
	     //readSocket(); If you want to read the whole file uncomment this.
		 //this section is executed in only the first iteration, later only runs the method run.
		   /*createConnectionMySQL();
		   try {
		    	 File file_test = new File("TEST.txt");
				file_test.createNewFile();
				BufferedWriter bw_test = new BufferedWriter(new FileWriter(file_test));
				bw_test.write((int)Math.round(ReadValues_hourly(13, 2, 1, 1, "friday")*1000)+"");
				  bw_test.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		   
		 list_of_hours[0] = 1;
		 list_of_hours[1] = 2;
		 list_of_hours[2] = 3;
		 list_of_hours[3] = 4;
		 list_of_hours[4] = 5;
		 list_of_hours[5] = 6;
		 list_of_hours[6] = 7;
		 list_of_hours[7] = 8;
		 list_of_hours[8] = 9;
		 list_of_hours[9] = 10;
		 list_of_hours[10] = 11;
		 list_of_hours[11] = 12;
		 list_of_hours[12] = 13;
		 list_of_hours[13] = 14;
		 list_of_hours[14] = 15;
		 list_of_hours[15] = 16;
		 list_of_hours[16] = 17;
		 list_of_hours[17] = 18;
		 list_of_hours[18] = 19;
		 list_of_hours[19] = 20;
		 list_of_hours[20] = 21;
		 list_of_hours[21] = 22;
		 list_of_hours[22] = 23;
		 list_of_hours[23] = 24;
		 
		 list_of_minutes[0] = 0.0;
		 list_of_minutes[1] = 10.0;
		 list_of_minutes[2] = 20.0;
		 list_of_minutes[3] = 30.0;
		 list_of_minutes[4] = 40.0;
		 list_of_minutes[5] = 50.0;
	   
	   } 
	   int id_2156 = 2156;
	     int month_2156 = 2;
	     int day_of_month_2156 = 1;
	     int hours_2156 = 1;
	     double start_minute_2156 = 0.0;
	     double end_minute_2156 = start_minute_2156 + 10.0;
	     String daytype_2156 = "Friday";
	     
	     int id_2168 = 2168;
	     int month_2168 = 2;
	     int day_of_month_2168 = 1;
	     int hours_2168 = 1;
	     double start_minute_2168 = 0.0;
	     double end_minute_2168 = start_minute_2168 + 10.0;
	     String daytype_2168 = "Friday";
	     
	     int id_2728 = 2728;
	     int month_2728 = 2;
	     int day_of_month_2728 = 1;
	     int hours_2728 = 1;
	     double start_minute_2728 = 0.0;
	     double end_minute_2728 = start_minute_2728 + 10.0;
	     String daytype_2728 = "Friday";
	     
	     int id_2810 = 2810;
	     int month_2810 = 2;
	     int day_of_month_2810 = 1;
	     int hours_2810 = 1;
	     double start_minute_2810 = 0.0;
	     double end_minute_2810 = start_minute_2810 + 10.0;
	     String daytype_2810 = "Friday";
	     
	     //7 is hourly
	     int id_7 = 7;
	     int month_7 = 2;
	     int day_of_month_7 = 1;
	     int hours_7 = 1;
	     String daytype_7 = "Friday";
	     
	     //13 is hourly
	     int id_13 = 13;
	     int month_13 = 2;
	     int day_of_month_13 = 1;
	     int hours_13 = 1;
	     String daytype_13 = "Friday";
	     
	     int[] list_of_hours = new int[24];
	     double[] list_of_minutes = new double[6];
	     
	     int i = 0;
	     int j = 0;
	     
	   public void write_zoneMeanAir(){
		   //createConnectionMySQL();
		   try {
		    	//zoneMeanAir TEN MINUTES
			     File file = new File("../HTML/zoneMeanAir.txt");
			     
			     //file.canWrite();
			     file.createNewFile();
				 bw = new BufferedWriter(new FileWriter(file));
				 //2156
				 bw.write("");
			     bw.newLine();
			     bw.write((int)(ReadValues_minute(id_2156, month_2156, day_of_month_2156, hours_2156, start_minute_2156, end_minute_2156, daytype_2156)*1000)+"");
			     //I'm multiplying for 1000 because only ints can be writen in the file. later when we read the file we / by 1000.
			     
			     //2168
			     bw.newLine();
			     
			     bw.write((int)Math.round(ReadValues_minute(id_2168, month_2168, day_of_month_2168, hours_2168, start_minute_2168, end_minute_2168, daytype_2168)*1000)+"");
				 bw.newLine();
				 
				 bw.write("30000"+""); // the ideal value for 2156 and 2168
				 
				 bw.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      
	   }
	   public void write_Heating(){
		   //createConnectionMySQL();
		   try {
				 //HeatingRate TEN MINUTES
			   File file = new File("../HTML/HeatingRate.txt");
			     
			     //file.canWrite();
			     file.createNewFile();
				bw = new BufferedWriter(new FileWriter(file));
				//2728
				bw.write("");
			     bw.newLine();
			     bw.write((int)Math.round(ReadValues_minute(id_2728, month_2728, day_of_month_2728, hours_2728, start_minute_2728, end_minute_2728, daytype_2728)*1000)+"");
			     //I'm multiplying for 1000 because only ints can be writen in the file. later when we read the file we / by 1000.
			     bw.newLine();
			     bw.write("2350000"+""); // ideal value for 2728
			     bw.newLine();
			     
			     //2810
			     
			     bw.write((int)Math.round(ReadValues_minute(id_2810, month_2810, day_of_month_2810, hours_2810, start_minute_2810, end_minute_2810, daytype_2810)*1000)+"");
				 bw.newLine();
				 bw.write("9270000"+""); // the ideal value for 2810 is 9270
				 bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
	   public void write_envTemp(){
		   //createConnectionMySQL();
		   try {
				 //envTemp.txt HOURLY
			   File file = new File("../HTML/envTemp.txt");
			     
			     //file.canWrite();
			     file.createNewFile();
				bw = new BufferedWriter(new FileWriter(file));
				//7
				bw.write("");
			     bw.newLine();
			     bw.write((int)Math.round(ReadValues_hourly(id_7, month_7, day_of_month_7, hours_7, daytype_7)*1000)+"");
			     //I'm multiplying for 1000 because only ints can be writen in the file. later when we read the file we / by 1000.
			     bw.newLine();
			     bw.write("22000"+""); // ideal value for 7 is 22
			     bw.close();
			     
			     
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	   }
	   public void write_Pressure(){
		   //createConnectionMySQL();
		   try {
				 //Pressure.txt HOURLY
			   File file = new File("../HTML/Pressure.txt");
			     
			     //file.canWrite();
			     file.createNewFile();
				bw = new BufferedWriter(new FileWriter(file));
				//13
			     bw.write("");
			     bw.newLine();
			     bw.write((int)Math.round(ReadValues_hourly(id_13, month_13, day_of_month_13, hours_13, daytype_13)*1000)+"");
			     //I'm multiplying for 1000 because only ints can be writen in the file. later when we read the file we / by 1000.
			     bw.newLine();
			     bw.write("103000000"+""); // ideal value for 13 is 103000
			     bw.close();
			     
			     
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	   }
	   @Override
	   public void run() {
		
		 System.out.println("Hi see you after 5 seconds");
	     System.out.println("esto se reptie");
	     createConnectionMySQL();
	  
	     write_zoneMeanAir();
	     write_Heating();
	     write_envTemp();
	     write_Pressure();
	     
	     
	     
	     hours_2156 = list_of_hours[i];
	     start_minute_2156 = list_of_minutes[j];
	     end_minute_2156 = start_minute_2156 + 10.0;
	     
	     
	     
	     hours_2168 = list_of_hours[i];
	     start_minute_2168 = list_of_minutes[j];
	     end_minute_2168 = start_minute_2168 + 10.0;
	     
	     
	     
	     hours_2728 = list_of_hours[i];
	     start_minute_2728 = list_of_minutes[j];
	     end_minute_2728 = start_minute_2728 + 10.0;
	     
	     
	     
	     hours_2810 = list_of_hours[i];
	     start_minute_2810 = list_of_minutes[j];
	     end_minute_2810 = start_minute_2810 + 10.0;
	     
	     
	     //7 is hourly
	     
	     hours_7 = list_of_hours[i];
	     
	     
	     //13 is hourly
	     
	     hours_13 = list_of_hours[i];
		
		 
		j++;
		if (j==6){
			i++;
			j=0;
		}
		
		if (i==24){
			i=0;
		}
		 
		
		
		
	     close();
	     
	     
	   }
	   
	   public void readSocket(){
		   ServerSocket sock = null;
		      Socket client = null;

		      /*if (args.length != 1) {

		         System.err.println("Usage: DBServer portnum");
		         return;
		      }*/

		      try {

		         System.out.println("Accepting conection...");
		         //sock = new ServerSocket(Integer.parseInt(args[0]));
		         sock = new ServerSocket(18000);
		         client = sock.accept();
		         System.out.println("Accepted!");

		      } catch (IOException e) {}
				
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
		                   
		      try { 

		         //br = new BufferedReader(new FileReader("IDEASS.eso"));
		         br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		         String line = null;

		         while ((line = br.readLine()) != null) {
		                           
		            if (line.contains("hola")) break;

		            System.out.println(line);
		            list_of_components = line.split(",");

		            if (list_of_components[0].contains("End of Data Dictionary")) {

		               End_Dict = true;
		            }

		            if (End_Dict) {
		               if (list_of_components[0].contentEquals("End of Data")) {

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

		                  if (Integer.parseInt(list_of_components[0])>5) {

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

		      } finally {

		         close();
		      }

	   }
	   
	   private void close() {
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

	      } catch (Exception e) {} 
	   }

	   private void createConnectionMySQL() {
	        try {

	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/Prueba_Lucas", "lucas", "lucas");
	            //establish a connection
	            
	        } catch (Exception except) {

	            except.printStackTrace();
	        }
	    }


	   private void insertValues(int id, double content, int month, int day_of_month, int dst_indicator, int hours, double start_minute, double end_minute, String daytype) {
	        try {

	            statement = connect.createStatement();
		    	statement.execute("insert into Prueba_Lucas.datos values (" + id + "," + content + "," + month + "," + day_of_month + "," + dst_indicator + "," + hours + "," + start_minute + "," + end_minute + ",'" + daytype +"')");
		    	statement.close();

	        } catch (SQLException sqlExcept) {

	            sqlExcept.printStackTrace();
	        }
	    }
	   private double ReadValues_minute(int id, int month, int day_of_month, int hours, double start_minute, double end_minute, String daytype) {
		   double value = 0; 
		   try {

	            statement = connect.createStatement();
	            ResultSet rs = statement.executeQuery("SELECT AVG(Prueba_Lucas.datos.content) AS Average FROM Prueba_Lucas.datos WHERE ID= " + id + " AND month = "+ month + " AND day_of_month = "+ day_of_month + " AND hours = "+ hours + " AND start_minute = "+ start_minute + " AND end_minute = " + end_minute + " ORDER BY day_of_month, hours, start_minute LIMIT 100000"); //limiting 10M records, should be enough (only )
	            
	            while(rs.next()){
	                value = rs.getDouble("Average");
	            }
	            statement.close();
	            
	        } catch (SQLException sqlExcept) {

	            sqlExcept.printStackTrace();
	        }
			return value;
	    }
	  
	   private double ReadValues_hourly(int id, int month, int day_of_month, int hours, String daytype) {
		   double value = 0; 
		   try {

	            statement = connect.createStatement();
	            ResultSet rs = statement.executeQuery("SELECT AVG(Prueba_Lucas.datos.content) AS Average FROM Prueba_Lucas.datos WHERE ID= " + id + " AND month = "+ month + " AND day_of_month = "+ day_of_month + " AND hours = "+ hours + "  ORDER BY day_of_month, hours, start_minute LIMIT 100000"); //limiting 10M records, should be enough (only )
	            
	            while(rs.next()){
	                value = rs.getDouble("Average");
	            }
	            statement.close();
	            
	        } catch (SQLException sqlExcept) {

	            sqlExcept.printStackTrace();
	        }
			return value;
	    }

	}
