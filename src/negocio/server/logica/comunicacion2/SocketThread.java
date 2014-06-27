package negocio.server.logica.comunicacion2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import negocio.comunicacion.mensajes.Mensaje;


public class SocketThread implements Runnable{
	
	private Socket socket;
	ObjectInputStream inFromClient;
	ObjectOutputStream outToClient;
	Queue<Mensaje> OutQueue;
	public SocketThread(Socket socket){
		this.socket=socket;
		this.OutQueue= new LinkedList<Mensaje>();
	    try {
			inFromClient = new ObjectInputStream(socket.getInputStream());
			outToClient = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		ConversarConClientes();
		//desconectar();
		
	}
	private void ConversarConClientes()  {
			Thread Escuchar= new Thread(){		
				public void run(){
					while (true){
						try{
							Mensaje msg;
							msg = (Mensaje) inFromClient.readObject();
							System.out.println("Se recibio un mensaje");
							msg.setClientID(Integer.toString(socket.hashCode()));
						    msg.decodificar();	
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
							while(!OutQueue.isEmpty()){
								System.out.println("Se envia mensaje");
								outToClient.writeObject(OutQueue.remove());
								DelayThread.delay(100);
							}
							
						}catch(Exception e){e.printStackTrace();};
					}
				}
			};
			
			Escuchar.start();
			Escribir.start();	
		}
	
	public void addOutPutMsg(Mensaje m){
		OutQueue.add(m);
		System.out.println("Se añadio un mensaje a la cola de salida de " + socket.hashCode());
	}
	
	
	 private void desconectar() {
	        try {
	            socket.close();
	            inFromClient.close();
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }
	    }

}
