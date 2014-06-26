package negocio.server.logica.comunicacion;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import negocio.comunicacion.mensajes.*;
import negocio.server.logica.comunicacion.DelayThread;

/*
 * MsgHandler -implements Runnable,Subject
 * Clase que recibe mensajes en una cola de entrada MsgQ
 * y se encarga de implementar su funcion de decodificación
 * una vez implementada la decodificación, un mensaje le es devuelto
 * con la respuesta que deberá ser enviada al cliente. Este mensaje
 * se coloca en la cola de salida OutMsgQ.
 * En esta etapa de la comunicación entra en juego la interfaz de Subject
 * de esta clase, que tiene como Observer a la clase TalkingServer.
 * Si el mensajeno es nulo se envía a TalkingServer, que
 * finalmente enviará el mensaje a través de un socket al cliente.
 */

public class MsgHandlerRespSubject implements Runnable,Subject {
	private static final long serialVersionUID = 1L;
	public Queue <Mensaje> InMsgQ;
	public Queue <Mensaje> OutMsgQ;
	ArrayList<Observer> SendersList;
	/*
	 * Constructor:
	 * Inicializa la cola de entrada MsgQ como una nueva LinkedList<Mensaje>
	 */
	public MsgHandlerRespSubject(){
		InMsgQ= new LinkedList<Mensaje>();
		OutMsgQ= new LinkedList<Mensaje>();
		SendersList= new ArrayList<Observer>();
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
			while(!InMsgQ.isEmpty()){
			Mensaje m=InMsgQ.remove(); //remove devuelve el mensaje en la cabeza de la cola, y lo elimina de la cola.
			ArrayList<Mensaje> Result=m.decodificar(); //llamada a decodificar
			System.out.println("Se decodifico el mensaje");
			try{
				for(Mensaje mResult : Result){sendMsg(mResult);}
			} catch (Exception e){e.printStackTrace();};
			
			DelayThread.delay(100);
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
		InMsgQ.add(m);
	}

	public void register(Observer o) {
		SendersList.add(o);
	}

	public void unregister(Observer o) {
		int index= SendersList.indexOf(o);
		System.out.println("Elimine el TalkingServer" + (index+1) + "de la lista de observers" );
		SendersList.remove(index);
		
	}

	public void notifyObservers() {
		while(!OutMsgQ.isEmpty()){
			Mensaje m=OutMsgQ.remove();
		for(Observer obs : SendersList){
			obs.update(m);
		}
		DelayThread.delay(100);
		}
	}
		private void setOutputMsg(Mensaje msg) {
			OutMsgQ.add(msg);
		}	
		
		public void sendMsg(Mensaje msg){
			if(msg!=null){
				System.out.println("Se envio el mensaje de resultado al talking server");
				setOutputMsg(msg);
				notifyObservers();	
			}
		}
	
}
