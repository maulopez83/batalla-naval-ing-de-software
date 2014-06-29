package negocio.server.main;


import java.io.IOException;

import negocio.server.logica.comunicacion.Server;

public class MainServer {

	public static void main(String args[]) throws IOException{
		
	int port = 2344;
	if(args.length == 1)
		port = Integer.parseInt(args[0]);		
		Server server = new Server(port);

	}
}
