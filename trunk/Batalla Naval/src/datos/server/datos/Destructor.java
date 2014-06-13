package datos.server.datos;

import java.awt.Point;
import java.util.ArrayList;

public class Destructor extends Barcos{

	public Destructor(ArrayList<Point> posiciones){
		super(posiciones);
		}

	public void MensajeHundido() {
		System.out.println("Se hundio un Destructor!");
		
	}
	
}
