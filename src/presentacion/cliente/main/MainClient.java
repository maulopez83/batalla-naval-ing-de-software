package presentacion.cliente.main;
import java.awt.EventQueue;
import java.awt.Point;

import negocio.comunicacion.mensajes.MensajeColocar;
import negocio.comunicacion.mensajes.MensajeConectar;
import negocio.comunicacion.mensajes.MensajeDesconectar;
import negocio.comunicacion.mensajes.MensajeDisparo;
import presentacion.cliente.logica.comunicacion.DelayThread;
import presentacion.cliente.logica.comunicacion.ClientGUIObserver;
import presentacion.cliente.logica.*;
import presentacion.cliente.visual.Ventana;



public class MainClient {
	public static void main(String[] args) throws Exception {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String remoteHost = "JUANJO-PC";
					int remotePort = 2344;
					/*
					 *Inicio un TalkingClientGUIObserver que se comunique con el servidor en JUANJO-PC
					 *a traves del puerto 2344
					 * 
					 */
					ClientGUIObserver client = new ClientGUIObserver(remoteHost, remotePort,Ventana.getInstance().getGuiSubject());
					MensajeConectar connectMsg = new MensajeConectar("V1.0",Ventana.getInstance().getClientID());
					client.update(connectMsg);
					new Thread(client).start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		/*
		 * Codigo que se corre antes de finalizar el programa
		 */
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
			System.out.println("Shutdown Hook is running !");
			}
			});
	}	
	
}
