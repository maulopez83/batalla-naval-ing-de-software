package presentacion.cliente.logica.comunicacion;
import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.Queue;

import negocio.comunicacion.mensajes.*;
import presentacion.cliente.visual.*;

/*
 * TalkingClientGUIObserver implements Observer
 * Crea un socket con el servidor
 * Su único metodo público es update.
 */
public class TalkingClientGUIObserver implements Observer {
	private String host;
	private int port;
	private Queue<Mensaje> OutputMsg;
	private Socket connection;

	/*
	 * Constructor
	 * params: String host, int port
	 * Inicializa los valores de host y port para crear el socket
	 * Inicializa OutputMsg como una nueva Cola del tipo LinkedList<Mensaje>
	 */
	public TalkingClientGUIObserver(String host, int port,Subject guiSubject) throws IOException {
		this.host = host; this.port = port;
		OutputMsg = new LinkedList<Mensaje>();
		guiSubject.register(this);
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
	 * sendMsg()
	 * Returns : void
	 * Params: void
	 * Inicia una conección con un socket
	 * Crea un ObjectOutputStream
	 * Toma el Mensaje a la cabeza de la cola de salida OutputMsg
	 * Si el mensaje no es nulo lo envía a través del socket con writeObject()
	 * cierra el ObjectOutputStream y el Socket
	 */
	private void sendMsg() {
			try{
			connection = new Socket(host, port);	
			ObjectOutputStream outToServer = new ObjectOutputStream(connection.getOutputStream());
			Mensaje msgToSend=OutputMsg.poll();
			if(msgToSend!=null){
				outToServer.writeObject(msgToSend);
				outToServer.flush();
			}
			outToServer.close();
			connection.close();
		  }catch(Exception e){};	
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
		sendMsg();
	}
}