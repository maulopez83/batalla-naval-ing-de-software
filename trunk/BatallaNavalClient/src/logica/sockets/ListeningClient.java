package logica.sockets;
import java.io.*;
import java.net.*;

import logica.otras.DelayThread;


/*
 * Listening Client:
 * no implementada aun
 * por ahora se encarga de recibir mensajes string enviados por el talkingServer
 */

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
				Socket connection = new Socket(host, port);
				BufferedReader br = new BufferedReader(new 	InputStreamReader(connection.getInputStream()));
				String devolucion= br.readLine();
				System.out.println("Recibi" + devolucion);
			
				br.close();
				connection.close();
				DelayThread.delay(100);
				
			}catch(Exception e){};
			
		}
	}
}
