package ing.de.software.batallanaval.logica.comunicacion;
import ing.de.software.batallanaval.logica.*;

public class HilodeEscucha implements Runnable{//puede implemetarse como singleton

	LogicaJuego logica;
	
	public HilodeEscucha(LogicaJuego logica){
		//Establecer conexion con el Servidor (con el hilo de envio de la GUI)
		this.logica=logica; //esta variable será para poder invocar ciertos métodos de LogicaJuego
	}
	
	public void run() {
		
		while(true){
			//escucho constantemente
			//y cuando se recibe algun String, entro a un SWITCH y ejecuto el metodo de "logica" que corresponda.
			//cuando reciba el aviso de un nuevo jugador que entró, creará el Player que corresponda (hasta 2 max).
			
		}
		
	}

}
