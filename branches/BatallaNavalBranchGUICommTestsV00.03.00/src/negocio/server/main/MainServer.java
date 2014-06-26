package negocio.server.main;

import java.awt.Point;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import presentacion.cliente.logica.comunicacion.DelayThread;
import presentacion.cliente.visual.Ventana;


import negocio.comunicacion.mensajes.MensajeGUI;
import negocio.server.logica.comunicacion.ListeningServer;
import negocio.server.logica.comunicacion.TalkingServerRespObserver;

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
	TalkingServerRespObserver tserver = new TalkingServerRespObserver(port,lserver.getHandler());
		
	}
}
