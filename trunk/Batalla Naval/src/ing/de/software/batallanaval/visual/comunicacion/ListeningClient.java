package ing.de.software.batallanaval.visual.comunicacion;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ListeningClient implements Runnable {
	boolean exit;
	private String host;
	private int port;
	public ListeningClient(String host, int port) throws IOException {
		exit=false;
		this.host = host; this.port = port;
	}
	public void run() {
		while (true){
			try{
				BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
				Socket connection = new Socket(host, port);
				BufferedReader br = new BufferedReader(new 	InputStreamReader(connection.getInputStream()));
				String devolucion= br.readLine();
				System.out.println("Recibi" + devolucion);
			
				br.close();
				connection.close();
				Thread.sleep(100);
				if(exit){
					break;
				}
			}catch(Exception e){};
			
		}
	}
}
