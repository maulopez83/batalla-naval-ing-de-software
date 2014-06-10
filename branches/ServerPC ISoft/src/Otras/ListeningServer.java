package Otras;
import java.io.*;
import java.net.*;

import mensajesServer.*;


public class ListeningServer implements Runnable {
	private MsgHandler handler;
	private Thread handlerThread;
	private ServerSocket serverSocket;
	public ListeningServer(int port,String frase,MsgHandler mh) throws IOException {
		serverSocket = new ServerSocket(port);
		handler=new MsgHandler();
		handlerThread=new Thread(handler);
		handlerThread.start();
	}
	
	private void EscucharClientes()  {
			
	Socket connection;
	try {
		connection = serverSocket.accept();
			
		ObjectInputStream inFromClient = new ObjectInputStream(connection.getInputStream());
			
		Mensaje msg;
		try {
			msg = (Mensaje) inFromClient.readObject();
			if(msg!=null){
					handler.addMsg(msg);
					System.out.println("Se añadio un mensaje a la cola");
			}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				}
			inFromClient.close();
			connection.close();
	} catch (IOException e) {
				e.printStackTrace();
	  }
	
	}
	public void run() {
		while(true){
			EscucharClientes();
			DelayThread.delay(250);
		}	
	}
}
