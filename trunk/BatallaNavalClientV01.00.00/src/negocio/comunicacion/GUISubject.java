package negocio.comunicacion;


import java.util.ArrayList;

import negocio.comunicacion.mensajes.Mensaje;

/*
 * GUI Subject
 * Cuando ocurre un evento en la GUI, se crea un mensaje
 * que se le entrega al GUI Subject, quien a su vez se encarga
 * de enviarselo a TalkingClientGUIObserver mediante el metodo sendMsg().
 * Esta última clase posee el socket para enviar el mensaje al Server.
 */
public class GUISubject implements Subject{
	ArrayList<Observer> clientList;
	private Mensaje msg;
	
	public GUISubject(){
		clientList= new ArrayList<Observer>();
	}
	
	public void register(Observer o) {
		clientList.add(o);
	}

	public void unregister(Observer o) {
		int index= clientList.indexOf(o);
		System.out.println("Elimine el cliente" + (index+1) + "de la lista de observers" );
		clientList.remove(index);
	}

	public void notifyObservers() {
		for(Observer obs : clientList){
			obs.update(msg);
		}
		
	}
	private void setMsg(Mensaje msg) {
		this.msg = msg;
	}	


	public void sendMsg(Mensaje msg){
		setMsg(msg);
		notifyObservers();
		
	}
	
}
