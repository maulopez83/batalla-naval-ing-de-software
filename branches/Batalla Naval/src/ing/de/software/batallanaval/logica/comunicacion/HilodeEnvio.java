package ing.de.software.batallanaval.logica.comunicacion;

public class HilodeEnvio implements Runnable{//puede implementarse como singleton

	private String mensaje;
	
	public HilodeEnvio(){
		//Establecer conexion con el Servidor (con el hilo de escucha de la GUI)
	}
	
	public void run() {
		//se enviará el mensaje previamente seteado.
	}

	public void setMensaje(String mensaje){
		this.mensaje=mensaje;
	}
	
}
