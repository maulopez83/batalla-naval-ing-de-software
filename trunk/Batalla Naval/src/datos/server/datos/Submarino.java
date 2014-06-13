package datos.server.datos;

import java.awt.Point;
import java.util.ArrayList;

public class Submarino extends Barcos{

	public Submarino(ArrayList<Point> posiciones){
		super(posiciones);
		}

	public void MensajeHundido() {
		System.out.println("Se hundio un Submarino!");
		
	}
	
}
