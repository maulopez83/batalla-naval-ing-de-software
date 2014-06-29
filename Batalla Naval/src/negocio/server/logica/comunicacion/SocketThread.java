package negocio.server.logica.comunicacion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import datos.server.datos.BaseDatosSingleton;

import negocio.comunicacion.mensajes.Mensaje;
import negocio.comunicacion.mensajes.MensajeDesconectar;


public class SocketThread implements Runnable{
	
	private Socket socket;
	public boolean keepGoing;
	ObjectInputStream inFromClient;
	ObjectOutputStream outToClient;
	Queue<Mensaje> OutQueue;
	public SocketThread(Socket socket){
		this.keepGoing=true;
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
					while (keepGoing){
						try{
							Mensaje msg;
							msg = (Mensaje) inFromClient.readObject();
							System.out.println("Se recibio un mensaje");
							msg.setClientID(Integer.toString(socket.hashCode()));
						    msg.decodificar();	
							System.out.println("Se decodifico el mensaje");
						}catch(Exception e){desconectar();};
						DelayThread.delay(100);
				    }
				}
			};
			
			Thread Escribir=new Thread(){
				public void run(){
					while (keepGoing){
						try{
							while(!OutQueue.isEmpty()){
								System.out.println("Se envia mensaje");
								outToClient.writeObject(OutQueue.remove());
								DelayThread.delay(100);
							}
							
						}catch(Exception e){desconectar();};
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
	
	
	 public void desconectar() {
		 System.out.println("desconectando server");
	        try {
	        	outToClient.flush();
	            outToClient.close();
	            inFromClient.close();
	            socket.close();
	            keepGoing=false;
	            BaseDatosSingleton.getInstance().getSocketMap().removeSocket(Integer.toString(socket.hashCode()));
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }
	    }

}
