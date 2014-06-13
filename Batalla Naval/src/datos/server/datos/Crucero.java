package datos.server.datos;

import java.awt.Point;
import java.util.ArrayList;

public class Crucero extends Barcos{

	public Crucero(ArrayList<Point> posiciones){
		super(posiciones);
		}

	public void MensajeHundido() {
		System.out.println("Se hundio un Crucero!");
		
	}
	
}
