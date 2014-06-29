package presentacion.cliente.main;
import java.awt.EventQueue;
import negocio.comunicacion.mensajes.MensajeConectar;
import negocio.comunicacion.mensajes.MensajeDesconectar;
import presentacion.cliente.logica.comunicacion.ClientGUIObserver;
import presentacion.cliente.visual.Ventana;



public class MainClient {
	public static void main(String[] args) throws Exception {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String remoteHost = "JUANJO-PC";
					int remotePort = 2344;
					/*
					 *Inicio un ClientGUIObserver que se comunique con el servidor en JUANJO-PC
					 *a traves del puerto 2344
					 * 
					 */
					ClientGUIObserver client = new ClientGUIObserver(remoteHost, remotePort,Ventana.getInstance().getGuiSubject());
					MensajeConectar connectMsg = new MensajeConectar("V1.0");
					client.update(connectMsg);
					new Thread(client).start();
				} catch (Exception e) {
					e.printStackTrace();
				}


			}
		});
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
			System.out.println("Cerrando cliente");
			Ventana.getInstance().getGuiSubject().sendMsg(new MensajeDesconectar());
			}
			});
	}	

}
