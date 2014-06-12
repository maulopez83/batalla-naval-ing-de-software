package negocio.server.main;

import java.io.IOException;


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
	new Thread(tserver).start();
	}
}
