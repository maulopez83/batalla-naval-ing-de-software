package presentacion.cliente.main;
import java.awt.EventQueue;
import java.awt.Point;

import negocio.server.logica.comunicacion.mensajes.MensajeColocar;
import negocio.server.logica.comunicacion.mensajes.MensajeConectar;
import negocio.server.logica.comunicacion.mensajes.MensajeDesconectar;
import negocio.server.logica.comunicacion.mensajes.MensajeDisparo;
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
					MensajeDisparo disparo = new MensajeDisparo(new Point(5,4), 1);
					tclient.update(disparo);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
	
}
