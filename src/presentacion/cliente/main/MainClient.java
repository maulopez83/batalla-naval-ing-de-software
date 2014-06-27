package presentacion.cliente.main;
import java.awt.EventQueue;
import java.awt.Point;

import negocio.comunicacion.mensajes.MensajeColocar;
import negocio.comunicacion.mensajes.MensajeConectar;
import negocio.comunicacion.mensajes.MensajeDesconectar;
import negocio.comunicacion.mensajes.MensajeDisparo;
import presentacion.cliente.logica.comunicacion.DelayThread;
import presentacion.cliente.logica.comunicacion.ListeningClient;
import presentacion.cliente.logica.comunicacion.TalkingClientGUIObserver;
import presentacion.cliente.logica.*;
import presentacion.cliente.visual.Ventana;



public class MainClient {
	public static void main(String[] args) throws Exception {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
					TalkingClientGUIObserver tclient = new TalkingClientGUIObserver(remoteHost, remotePort,Ventana.getInstance().getGuiSubject());
					MensajeConectar connectMsg = new MensajeConectar("V1.0",Ventana.getInstance().getClientID());
					tclient.update(connectMsg);
					
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
