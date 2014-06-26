package negocio.comunicacion.elementosgraficos;
import java.awt.Point;
import java.util.ArrayList;

import datos.server.datos.Barcos;

public class Acorazado extends Barcos{

	public Acorazado(ArrayList<Point> posiciones){
		super(posiciones);
		}

	public void MensajeHundido() {
		System.out.println("Se hundio un Acorazado!");
		
	}
	
}
	

