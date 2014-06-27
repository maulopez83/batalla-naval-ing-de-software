package negocio.comunicacion.elementosgraficos;

import java.awt.Point;
import java.util.ArrayList;

import datos.server.datos.Barcos;

public class CruceroGUI extends Barcos{

	public CruceroGUI(ArrayList<Point> posiciones){
		super(posiciones);
		}

	public void MensajeHundido() {
		System.out.println("Se hundio un Destructor!");
		
	}
	
}
