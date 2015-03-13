import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.lang.System.*;


public class BNClient {

   public static void main(String[] args) {

      /*if (args.length != 2) {
         System.err.println("Usage: BNClient hostname portnum");
         return;
      }*/

      String line;
      Socket sock;
      PrintWriter pw;
      BufferedReader br;

      try {

         System.out.println("Connecting to server...");
         sock = new Socket("localhost", 18000);
         System.out.println("Connected!");

         br = new BufferedReader(new FileReader("IDEASS.eso"));
         pw = new PrintWriter(sock.getOutputStream());

         while ((line = br.readLine()) != null) {

            pw.println(line);
            pw.flush();
         }

         sock.close();
         pw.close();

      } catch (IOException e) {

         System.err.println("error" + e);
      }

   }
}
