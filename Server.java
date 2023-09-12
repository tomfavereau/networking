import java.net.*;
import java.io. *;
import java.util.*;

public class Server {

    public static void main(String[] args){
        try{
            ServerSocket Socket= new ServerSocket(5000);
            System.out.println("Waiting for Client.");
            Socket Serveur = Socket.accept();
            System.out.println("Server is connected.");

            // Sending data S to C.
            Scanner scan = new Scanner(System.in);
            PrintWriter pw = new PrintWriter(Serveur.getOutputStream());

	     BufferedReader br = new BufferedReader(new InputStreamReader(Serveur.getInputStream()));
	    
	   
	    Thread inputThread = new Thread() {
      		public void run() {
			try {  
			while (true){  
			String data_in = br.readLine();
                	System.out.println("\nAlicia: " + data_in);
			System.out.printf("Tom: ");
			}
			}
			catch (Exception e){
				System.out.println(e);
			}
        	
		}
    	    };

	    Thread outputThread = new Thread() {
      		public void run() {
			while (true){
				System.out.print("Tom: ");
				String data_out = scan.nextLine();
				pw.println(data_out);
				pw.flush();
			}

        	
		}
    	    };

	    
         inputThread.start();
	 outputThread.start();

        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}


