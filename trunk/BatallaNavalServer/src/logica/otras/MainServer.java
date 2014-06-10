package logica.otras;
import java.io.IOException;

import logica.mensajes.*;
import logica.sockets.ListeningServer;
import logica.sockets.TalkingServer;


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
	TalkingServer tserver = new TalkingServer(port,"hola");
	new Thread(tserver).start();
	}
}
