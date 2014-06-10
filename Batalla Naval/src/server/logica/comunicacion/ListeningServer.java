package server.logica.comunicacion;
import java.io.*;
import java.net.*;

import server.logica.comunicacion.mensajes.Mensaje;


/*
 * ListeningServer - implements Runnable
 * Clase que escucha constantemente si llegan mensajes 
 * al socket. Una vez que recibe un mensaje lo a�ade a la cola del
 * MsgHandler handler, quien se encarga de su decodificaci�n.
 */

public class ListeningServer implements Runnable {
	private MsgHandler handler;
	private Thread handlerThread;
	private ServerSocket serverSocket;
	
	/*
	 * Constructor:
	 * params: port
	 * Inicializa el valor puerto de escucha del serversocket
	 * Inicializa el handler como un nuevo MsgHandler
	 * Inicializa un hilo que corre el metodo run() del MsgHandler para decodificar los mensajes
	 */
	public ListeningServer(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		handler=new MsgHandler();
		handlerThread=new Thread(handler);
		handlerThread.start();
	}
	
	/*
	 * EscucharClientes()
	 * returns: void
	 * params: void
	 * Crea un socket servidor que escucha en el puerto determinado por port.
	 * Si el mensaje recibido por la funcion readObject no es nulo
	 * entonces lo a�ade a la cola del MsgHandler handler
	 * Cierra la coneccion del socket y el ObjectInputStream
	 */
	private void EscucharClientes()  {
			
	Socket connection;
	try {
		connection = serverSocket.accept();
			
		ObjectInputStream inFromClient = new ObjectInputStream(connection.getInputStream());
			
		Mensaje msg;
		try {
			msg = (Mensaje) inFromClient.readObject();
			if(msg!=null){
					handler.addMsg(msg);
					System.out.println("Se a�adio un mensaje a la cola");
			}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				}
			inFromClient.close();
			connection.close();
	} catch (IOException e) {
				e.printStackTrace();
	  }
	
	}
	
	/*
	 * run()
	 * returns: void
	 * params: void
	 * Loop infinito que llama a EscuhcarClientes() y espera un tiempo
	 * para evitar sobrecarga del procesador
	 */
	public void run() {
		while(true){
			EscucharClientes();
			DelayThread.delay(250);
		}	
	}
}
