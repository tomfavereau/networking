package fr.ensmn.shao;
import java.net.*;
import java.io.*;
import java.util.*;

public class Client {
    public static void main(String[] args){
        try{
            Socket Client = new Socket("172.20.10.2",5000);
            System.out.println("Client is connected.");

            //Reading data from Server
            BufferedReader br = new BufferedReader(new InputStreamReader(Client.getInputStream()));

            Scanner scan = new Scanner(System.in);
            PrintWriter pw = new PrintWriter(Client.getOutputStream());

            Thread inputThread = new Thread() {
                public void run() {
                    try{
                        while (true) {
                            String data_in = br.readLine();
                            System.out.println("\n Tom: " + data_in);
                            System.out.print("Alicia: ");
                        }
                    }
                    catch(Exception e) {
                        System.out.println(e);
                    }
                }
            };

            Thread outputThread = new Thread() {
                public void run() {
                    while (true){
                        System.out.print("Alicia: ");
                        String data_out = scan.nextLine();
                        pw.println(data_out);
                        pw.flush();
                    }
                }
            };


            inputThread.start();
            outputThread.start();

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
