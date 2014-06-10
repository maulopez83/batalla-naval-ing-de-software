package ing.de.software.batallanaval.visual.comunicacion;

public class HilodeEnvio implements Runnable{

	private String mensaje;
	
	public HilodeEnvio(){//puede implementarse como Singleton
		//Establecer conexion con el Servidor (con el hilo de escucha de la logica del juego)
	}
	
	public void run() {
		//se enviará el mensaje previamente seteado.
	}

	public void setMensaje(String mensaje){
		this.mensaje=mensaje;
	}
	
}
