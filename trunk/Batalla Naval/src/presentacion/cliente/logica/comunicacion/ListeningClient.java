package presentacion.cliente.logica.comunicacion;
import java.io.*;
import java.net.*;

import negocio.logica.comunicacion.mensajes.Mensaje;
import negocio.server.logica.comunicacion.DelayThread;


/*
 * Listening Client:
 * no implementada aun
 * por ahora se encarga de recibir mensajes string enviados por el talkingServer
 */

public class ListeningClient implements Runnable {
	private ClientMsgHandler handler;
	private Thread handlerThread;
	private String host;
	private int port;
	private Socket connection;
	public ListeningClient(String host, int port) throws IOException {
		this.host = host; this.port = port;
		handler=new ClientMsgHandler();
		handlerThread=new Thread(handler);
		handlerThread.start();
	}
	
	public void EscucharServer() {
			try{
			    connection = new Socket(host, port);
				ObjectInputStream inFromServer = new ObjectInputStream(connection.getInputStream());
				Mensaje msg;
				try {
					msg = (Mensaje) inFromServer.readObject();
					if(msg!=null){
							handler.addMsg(msg);
							System.out.println("Se añadio un mensaje a la cola");
					}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
						}
				connection.close();
			}catch(Exception e){};
			
		}
	public void run() {
		while(true){
			EscucharServer();
			DelayThread.delay(250);
		}	
	}
}
