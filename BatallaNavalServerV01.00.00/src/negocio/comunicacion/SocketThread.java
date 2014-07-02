package negocio.comunicacion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;
import negocio.comunicacion.mensajes.Mensaje;


public class SocketThread implements Runnable{
	
	private Socket socket;
	public boolean keepGoing;
	public boolean error;
	ObjectInputStream inFromClient;
	ObjectOutputStream outToClient;
	Queue<Mensaje> OutQueue;
	public SocketThread(Socket socket){
		this.keepGoing=true;
		this.error=false;
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
	}
	private void ConversarConClientes()  {
			Thread Escuchar= new Thread(){		
				public void run(){
					while (keepGoing){
						try{
							Mensaje msg;
							msg = (Mensaje) inFromClient.readObject();
							msg.setClientID(Integer.toString(socket.hashCode()));
						    msg.decodificar();	
						}catch(Exception e){error=true;};
						DelayThread.delay(100);
				    }
				}
			};
			
			Thread Escribir=new Thread(){
				public void run(){
					while (keepGoing){
						try{
							while(!OutQueue.isEmpty()){
								outToClient.writeObject(OutQueue.remove());
								DelayThread.delay(100);
							}
							
						}catch(Exception e){error=true;};
					}
				}
			};
			
			Escuchar.start();
			Escribir.start();	
		}
	
	public void addOutPutMsg(Mensaje m){
		OutQueue.add(m);
	}
	
	
	 public void desconectar() {
		 System.out.println("desconectando server");
	        try {
	        	while(!OutQueue.isEmpty() && !error){
	        		DelayThread.delay(200);
	        	}
	        	socket.shutdownInput();
	            socket.shutdownOutput();
	        	outToClient.flush();
	            outToClient.close();
	            inFromClient.close();
	            socket.close();
	            keepGoing=false;
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }
	    }

}
