package negocio.comunicacion;
import java.io.*;
import java.net.*;

import datos.BaseDatosSingleton;
import datos.SocketMap;




/*
 * ListeningServer - implements Runnable
 * Clase que escucha constantemente si llegan mensajes 
 * al socket. Una vez que recibe un mensaje lo añade a la cola del
 * MsgHandler handler, quien se encarga de su decodificación.
 */

public class Server {
	private ServerSocket serverSocket;
	
	/*
	 * Constructor:
	 * params: port
	 * Inicializa el valor puerto de escucha del serversocket
	 * Inicializa el handler como un nuevo MsgHandler
	 * Inicializa un hilo que corre el metodo run() del MsgHandler para decodificar los mensajes
	 */
	public Server(int port) throws IOException {
		this.serverSocket = new ServerSocket(port);
		ConectarClientes();
	}

	
	public void ConectarClientes(){
		try {		
			while (true) {
			Socket connection = serverSocket.accept();
			 System.out.println("Nueva conexión entrante: "+connection.hashCode());
			 SocketMap sm=BaseDatosSingleton.getInstance().getSocketMap();
			 sm.addSocket(Integer.toString(connection.hashCode()), new SocketThread(connection));
			 new Thread(sm.getSocket(Integer.toString(connection.hashCode()))).start();
          
            DelayThread.delay(100);
            
            }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
