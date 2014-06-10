package logica.sockets;

	import java.io.*;
import java.net.*;

/*
 * TALKING SERVER
 * NO ESTA IMPLEMENTADO TODAVIA, POR AHORA SOLO ENVIA
 * "HolaCliente!" hacia el ListeningClient
 */
	public class TalkingServer implements Runnable {
		private String frase;
		private String resultado;
		private int contadorPerdida;
		private int MAXVIDAS;
		private boolean win;
		private boolean lose;

		
		private ServerSocket serverSocket;
		public TalkingServer(int port,String frase) throws IOException {
			contadorPerdida=0;
			MAXVIDAS=5;
			this.frase=frase.toLowerCase();
			resultado="";
			for (int i=0;i<frase.length();i++){
			resultado+="-";
			}
			win=false;
			lose=false;
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
					if(win || lose){
						break;
					}
					
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

