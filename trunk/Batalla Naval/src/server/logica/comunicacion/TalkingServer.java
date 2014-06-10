package server.logica.comunicacion;

	import java.io.*;
import java.net.*;

/*
 * TALKING SERVER
 * NO ESTA IMPLEMENTADO TODAVIA, POR AHORA SOLO ENVIA
 * "HolaCliente!" hacia el ListeningClient
 */
	public class TalkingServer implements Runnable {

		private ServerSocket serverSocket;
		public TalkingServer(int port) throws IOException {
			serverSocket = new ServerSocket(port);
		}
		public void run() {
			while(true){
				try {
					String mensaje="Hola Cliente!";
					Socket connection;
					connection = serverSocket.accept();
					PrintWriter pw = new PrintWriter(connection.getOutputStream());
					pw.println(mensaje);
					pw.close();//si no se cierra primero, hay que hacer flush
					connection.close();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
			
		}
	}

