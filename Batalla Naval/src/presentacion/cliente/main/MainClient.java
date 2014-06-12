package presentacion.cliente.main;
import java.awt.EventQueue;

import negocio.logica.comunicacion.mensajes.MensajeColocar;
import negocio.logica.comunicacion.mensajes.MensajeConectar;
import negocio.logica.comunicacion.mensajes.MensajeDesconectar;
import negocio.logica.comunicacion.mensajes.MensajeDisparo;

import presentacion.cliente.logica.comunicacion.DelayThread;
import presentacion.cliente.logica.comunicacion.ListeningClient;
import presentacion.cliente.logica.comunicacion.TalkingClientGUIObserver;
import presentacion.cliente.logica.*;
import presentacion.cliente.visual.animacion.Ventana;



public class MainClient {
	public static void main(String[] args) throws Exception {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.getFrame().setVisible(true);
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
					TalkingClientGUIObserver tclient = new TalkingClientGUIObserver(remoteHost, remotePort,window.getGuiSubject());
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
	
}
