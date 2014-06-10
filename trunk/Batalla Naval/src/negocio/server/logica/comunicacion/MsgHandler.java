package negocio.server.logica.comunicacion;
import java.util.LinkedList;
import java.util.Queue;

import negocio.server.logica.comunicacion.DelayThread;
import negocio.server.logica.comunicacion.mensajes.Mensaje;

/*
 * MsgHandler -implements Runnable
 * Clase que recibe mensajes en una cola de entrada MsgQ
 * y se encarga de implementar su funcion de decodificación
 */

public class MsgHandler implements Runnable {
	private static final long serialVersionUID = 1L;
	public Queue <Mensaje> MsgQ;
	
	/*
	 * Constructor:
	 * Inicializa la cola de entrada MsgQ como una nueva LinkedList<Mensaje>
	 */
	public MsgHandler(){
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
			String resultado=m.decodificar(); //llamada a decodificar
			System.out.println(resultado);
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
	public void addMsg(Mensaje m){
		MsgQ.add(m);
	}
	
}
