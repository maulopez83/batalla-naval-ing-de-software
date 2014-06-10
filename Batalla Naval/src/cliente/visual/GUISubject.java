package cliente.visual;


import java.util.ArrayList;

import cliente.logica.comunicacion.mensajes.Mensaje;


/*
 * GUI Subject
 * no implementada
 * Debería obtener los cambios en la GUI, crear un mensaje y avisarle a TalkingClientGUIObserver
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
	
	public void sendMessage(Mensaje msg){
		setMsg(msg);
		notifyObservers();
	}

}
