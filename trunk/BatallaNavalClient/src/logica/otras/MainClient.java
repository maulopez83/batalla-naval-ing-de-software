package logica.otras;
import logica.*;
import logica.mensajes.MensajeColocar;
import logica.mensajes.MensajeConectar;
import logica.mensajes.MensajeDesconectar;
import logica.mensajes.MensajeDisparo;
import logica.sockets.ListeningClient;
import logica.sockets.TalkingClientGUIObserver;


public class MainClient {
	public static void main(String[] args) throws Exception {
		String remoteHost = "localhost";
		int remotePort = 2343;
		ListeningClient lclient = new ListeningClient(remoteHost, remotePort);
		new Thread(lclient).start();
		remotePort = 2344;
		TalkingClientGUIObserver tclient = new TalkingClientGUIObserver(remoteHost, remotePort);
		while(true){
			tclient.update(new MensajeDisparo("hola", 0));
			tclient.update(new MensajeColocar("hola", 0));
			tclient.update(new MensajeConectar("hola", 0));
			tclient.update(new MensajeDesconectar("hola", 0));
			DelayThread.delay(1000);
		}
	}	
	
	public static void delay(int milis) throws InterruptedException{
		Thread.sleep(milis);
	}
}
