package negocio.server.logica.comunicacion;

	import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.Queue;

import negocio.logica.comunicacion.mensajes.Mensaje;

/*
 * TALKING SERVER
 * NO ESTA IMPLEMENTADO TODAVIA, POR AHORA SOLO ENVIA
 * "HolaCliente!" hacia el ListeningClient
 */
	public class TalkingServer {
		private Queue<Mensaje> OutputMsg;
		private ServerSocket serverSocket;
		public TalkingServer(int port) throws IOException {
			serverSocket = new ServerSocket(port);
			OutputMsg = new LinkedList<Mensaje>();
		}
		public void update(Mensaje m) {
			addMsg(m);
			sendMsg();
		}
		
		private void addMsg(Mensaje msg) {
			OutputMsg.add(msg);
		}
		
		private void sendMsg() {
			try{
			Socket connection;
			connection = serverSocket.accept();	
			ObjectOutputStream outToServer = new ObjectOutputStream(connection.getOutputStream());
			Mensaje msgToSend=OutputMsg.poll();
			System.out.println(msgToSend.getID());
			if(msgToSend!=null){
				outToServer.writeObject(msgToSend);
				outToServer.flush();
				System.out.println("Envie");

	
			}
			outToServer.close();
			connection.close();
			System.out.println("Sali");
		  }catch(Exception e){ };	
	}
	}

