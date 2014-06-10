package cliente.main;
import cliente.logica.comunicacion.DelayThread;
import cliente.logica.comunicacion.ListeningClient;
import cliente.logica.comunicacion.TalkingClientGUIObserver;
import cliente.logica.comunicacion.mensajes.MensajeColocar;
import cliente.logica.comunicacion.mensajes.MensajeConectar;
import cliente.logica.comunicacion.mensajes.MensajeDesconectar;
import cliente.logica.comunicacion.mensajes.MensajeDisparo;
import cliente.logica.*;



public class MainClient {
	public static void main(String[] args) throws Exception {
		/*
		 * Inicio un listening client que escuche a mi computadora JUANJO-PC 
		 * en el puerto 2343 donde corro el server
		 * por ahora solo recibe el string "HolaCliente!"
		 */
		String remoteHost = "JUANJO-PC";
		int remotePort = 2343;
		ListeningClient lclient = new ListeningClient(remoteHost, remotePort);
		new Thread(lclient).start();
		
		/*
		 *Inicio un TalkingClientGUIObserver que se comunique con el servidor en JUANJO-PC
		 *a traves del puerto 2344
		 * 
		 */
		remotePort = 2344;
		TalkingClientGUIObserver tclient = new TalkingClientGUIObserver(remoteHost, remotePort);
		/*
		 * Bucle infinito que envía 4 mensajes cada un segundo
		 */
		while(true){
			tclient.update(new MensajeDisparo("hola", 0));
			tclient.update(new MensajeColocar("hola", 0));
			tclient.update(new MensajeConectar("hola", 0));
			tclient.update(new MensajeDesconectar("hola", 0));
			DelayThread.delay(1000);
		}
	}	
	
}
