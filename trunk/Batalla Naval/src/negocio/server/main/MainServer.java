package negocio.server.main;

import java.awt.Point;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import presentacion.cliente.logica.comunicacion.DelayThread;
import presentacion.cliente.visual.animacion.Ventana;


import negocio.logica.comunicacion.mensajes.MensajeLabel;
import negocio.server.logica.comunicacion.ListeningServer;
import negocio.server.logica.comunicacion.TalkingServer;

public class MainServer {

	public static void main(String args[]) throws IOException{
	/*Creo un nuevo ListeningServer en el puerto 2344
	 *Inicio su metodo run()
	 */
	int port = 2344;
	if(args.length == 1)
		port = Integer.parseInt(args[0]);		
	ListeningServer lserver = new ListeningServer(port);
	new Thread(lserver).start();
	
	
	/*
	 * El talking server tdv no esta implementado por ahora solo manda "HolaCliente!"
	 */
	port = 2343;
	if(args.length == 1)
		port = Integer.parseInt(args[0]);		
	TalkingServer tserver = new TalkingServer(port);
	for (int k=0; k<10;k++){
		for (int i=0; i<10;i++){
			DelayThread.delay(1000);

			Point pos= new Point(50*i, 50*k);
			Point wh= new Point(50, 50);
			tserver.update(new MensajeLabel("src/datos/server/datos/imagenes/Agua.png",pos,wh));
		}
	  }
	}
	
}
