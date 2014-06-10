package Otras;
import java.io.*;
import java.net.*;

import mensajesServer.*;


public class ListeningServer implements Runnable {
	private MsgHandler handler;
	private Mensaje msg;
	private ServerSocket serverSocket;
	public ListeningServer(int port,String frase,MsgHandler mh) throws IOException {
		serverSocket = new ServerSocket(port);
		handler=mh;
	}
	
	public Mensaje getMsg() {
		return msg;
	}


	public void setMsg(Mensaje msg) {
		if (msg!=null){
			this.msg = msg;
		}
	}

	private void EscucharClientes()  {
			
			Socket connection;
	try {
				connection = serverSocket.accept();
			
			ObjectInputStream inFromClient = new ObjectInputStream(connection.getInputStream());
			
			Mensaje mens;
	try {
			mens = (Mensaje) inFromClient.readObject();
			
			setMsg(mens);
			if(mens!=null){
					handler.addMsg(getMsg());
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
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}
}
