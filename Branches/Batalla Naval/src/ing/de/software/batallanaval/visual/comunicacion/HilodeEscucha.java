package ing.de.software.batallanaval.visual.comunicacion;
import ing.de.software.batallanaval.visual.*;

public class HilodeEscucha implements Runnable{//puede implementarse como singleton

	InterfazGrafica ventana;
	
	public HilodeEscucha(InterfazGrafica ventana){
		//Establecer conexion con el Servidor (con el hilo de envio de la logica del juego)
		this.ventana=ventana;
	}
	
	public void run() {
		
		while(true){
			//estar en estado de "alerta" para escuchar cualquier mensaje que se reciba
			//cuando lo haga ejecutara el metodo de "ventana" que corresponda segun la orden recibida.
		}
		
	}

}
