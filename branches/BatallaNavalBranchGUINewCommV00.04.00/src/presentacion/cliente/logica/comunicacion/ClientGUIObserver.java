package presentacion.cliente.logica.comunicacion;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import negocio.comunicacion.mensajes.*;
import negocio.server.logica.comunicacion2.DelayThread;
import presentacion.cliente.visual.*;

/*
 * TalkingClientGUIObserver implements Observer
 * Crea un socket con el servidor
 * Su único metodo público es update.
 */
public class ClientGUIObserver implements Observer,Runnable {
	private String host;
	private int port;
	private Queue<Mensaje> OutputMsg;
	private Socket connection;
	ObjectOutputStream outToServer;
	ObjectInputStream  inFromServer;
	ClientMsgHandler handler;
	/*
	 * Constructor
	 * params: String host, int port
	 * Inicializa los valores de host y port para crear el socket
	 * Inicializa OutputMsg como una nueva Cola del tipo LinkedList<Mensaje>
	 */
	public ClientGUIObserver(String host, int port,Subject guiSubject) throws IOException {
		this.host = host; this.port = port;
		OutputMsg = new LinkedList<Mensaje>();
		guiSubject.register(this);
		handler= new ClientMsgHandler();
		new Thread(handler).start();
		connection = new Socket(host, port);	
		outToServer = new ObjectOutputStream(connection.getOutputStream());
		inFromServer = new ObjectInputStream(connection.getInputStream());
	}
	/*
	 * addMsg()
	 * Returns: void
	 * Params: Mensaje msg
	 * Añade un msg a la cola de salida OutputMsg
	 */
	
	private void addMsg(Mensaje msg) {
		OutputMsg.add(msg);
	}
	
	/*
	 * update()
	 * Returns: void
	 * params : Mensaje m
	 * Añade el mensaje m a la cola de salida OutputMsg
	 * Y lo envía con la funcion sendMsg()
	 */
	public void update(Mensaje m) {
		addMsg(m);
	}
	public void ConversarConServer(){
		Thread Escuchar= new Thread(){		
			public void run(){
				while (true){
					try{
						Mensaje msg;
						msg = (Mensaje) inFromServer.readObject();
						System.out.println("Se recibio un mensaje");
						handler.addMsg(msg);
						System.out.println("Se decodifico el mensaje");
					}catch(Exception e){e.printStackTrace();};
					DelayThread.delay(100);
			    }
			}
		};
		Thread Escribir=new Thread(){
			public void run(){
				while (true){
					try{
						while(!OutputMsg.isEmpty()){
							System.out.println("Se envia mensaje");
							outToServer.writeObject(OutputMsg.remove());
							DelayThread.delay(100);
						}
						
					}catch(Exception e){e.printStackTrace();};
				}
			}
		};
		
		Escuchar.start();
		Escribir.start();
	}
	
	private void desconectar() {
        try {
        	outToServer.close();
			inFromServer.close();
			connection.close();
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
	public void run() {
		ConversarConServer();
		
	}

}