package negocio.comunicacion;
import java.util.LinkedList;
import java.util.Queue;

import negocio.comunicacion.mensajes.*;

/*
 * ClientMsgHandler -implements Runnable
 * Clase que recibe mensajes en una cola de entrada MsgQ
 * y se encarga de implementar su funcion de decodificación en el cliente
 */

public class ClientMsgHandler implements Runnable {
	private static final long serialVersionUID = 1L;
	public Queue <Mensaje> MsgQ;
	
	/*
	 * Constructor:
	 * Inicializa la cola de entrada MsgQ como una nueva LinkedList<Mensaje>
	 */
	public ClientMsgHandler(){
		MsgQ= new LinkedList<Mensaje>();
	}

	/*
	 * run()
	 * returns: void
	 * params: void
	 * Inicia la decodificación de los mensajes
	 * Mientras la cola MsgQ no este vacía, decodifica
	 * cada mensaje y lo elimina de la cola.
	 */
	public void run() {
		while (true){
			while(!MsgQ.isEmpty()){
			Mensaje m=MsgQ.remove(); //remove devuelve el mensaje en la cabeza de la cola, y lo elimina de la cola.
			m.decodificar();
			}
			DelayThread.delay(100);
		}
	}
	
	/*
	 * addMsg()
	 * returns: void
	 * params: Mensaje m
	 * Añade el mensaje m a la cola de entrada MsgQ
	 */
	public void addMsg(Mensaje msg){
		MsgQ.add(msg);
	}
	
}
