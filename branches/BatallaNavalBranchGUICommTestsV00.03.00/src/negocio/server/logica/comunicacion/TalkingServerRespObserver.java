package negocio.server.logica.comunicacion;

	import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.Queue;

import negocio.comunicacion.mensajes.Mensaje;

/*
 * Talking Server implements Subject
 * Presenta un patron Observer junto con el MsgHandler del Servidor, que es sujeto.
 * El MsgHandler del Servidor recibe los mensajes desde el socket de escucha del servidor
 * y una vez obtenidos llama a su función decodificar, la cual realiza cambios en los datos
 * del juego y elabora otro mensaje de respuesta. Ese mensaje de repuesta es visto por el
 * mismo MsgHandler, del cual TalkingServer es un Observer. Por lo tanto cuando recibe la
 * respuesta el MsgHandler comprueba que el mensaje no sea nulo y 
 * se lo envía al TalkingServer, quien luego lo envía por Socket hacia el Cliente.
 */
	public class TalkingServerRespObserver implements Observer{
		private Queue<Mensaje> OutputMsg;
		private ServerSocket serverSocket;
		
		public TalkingServerRespObserver(int port,Subject MsgGrabber) throws IOException {
			serverSocket = new ServerSocket(port);
			OutputMsg = new LinkedList<Mensaje>();
			MsgGrabber.register(this);
		}
		
		public void update(Mensaje m) {
			System.out.println("Se recibio el mensaje de resultado en talking server");
			if(m==null){System.out.println("es nulo");}
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
			System.out.println("Entre aca1");
			ObjectOutputStream outToServer = new ObjectOutputStream(connection.getOutputStream());
			Mensaje msgToSend=OutputMsg.poll();
			if(msgToSend!=null){
				System.out.println("Entre aca2");
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

