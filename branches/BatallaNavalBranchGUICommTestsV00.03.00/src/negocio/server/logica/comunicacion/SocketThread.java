package negocio.server.logica.comunicacion;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Queue;

import negocio.comunicacion.mensajes.Mensaje;

public class SocketThread {
	private Queue<Mensaje> OutputMsg;
	private ServerSocket serverSocket;
    private Socket socket;
    
    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
    	ObjectOutputStream outToServer= null;
		Socket connection= null;
		Mensaje msgToSend=null;
		try{
    	outToServer = new ObjectOutputStream(connection.getOutputStream());
	    msgToSend=OutputMsg.poll();
		if(msgToSend!=null){
			System.out.println("Entre aca2");
			outToServer.writeObject(msgToSend);
			outToServer.flush();
			System.out.println("Envie");
		}		
		System.out.println("Sali");
	  }catch(Exception e){
		  e.printStackTrace();
		  if(outToServer!=null){
			  try {
				  outToServer.close();
			  	  } catch (IOException e1) {e1.printStackTrace();}}
		  if(connection!=null){
			  try {
				  connection.close();
			  	} catch (IOException e1) {e1.printStackTrace();}
		  }
		  update(msgToSend);
    }

}
