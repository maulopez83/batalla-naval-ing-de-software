package ing.de.software.batallanaval.datos;

import ing.de.software.batallanaval.logica.*;
import ing.de.software.batallanaval.logica.Coordenada;

import java.util.ArrayList;

public class TableroTradicional implements Tablero{
	
	private ArrayList<EnumTablero> filas= new ArrayList<EnumTablero>();
	private ArrayList<ArrayList<EnumTablero>> tablero= new ArrayList<ArrayList<EnumTablero>>();
	
	public TableroTradicional(){
		
		for (int col=0; col<10; col++){//inicializo las 10 columnas de arrays
			tablero.add(new ArrayList<EnumTablero>());
		}
		
		for (int col=0; col<10; col++){
			for (int fil=0; fil<10; fil++){
				tablero.get(col).add(EnumTablero.AGUA);//relleno el array de cada columna con ceros.
			}
		}
		
	}

	public void setDato(Coordenada coordenada, EnumTablero dato) {
		//Vamos a poner el "dato" en el lugar de la coordenada pasada.
		
	}

	public EnumTablero getDato(Coordenada coordenada) {
		//Vamos a devolver el dato enumeracion que se encuentre en la coordenada pasada.
		return null;
	}
	
}
