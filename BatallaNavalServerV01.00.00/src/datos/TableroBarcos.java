package datos;

import java.awt.Point;
import java.util.ArrayList;

public class TableroBarcos{
	
	private ArrayList<Barcos> barcosEnTablero;
	
	public TableroBarcos(){
		barcosEnTablero= new ArrayList<Barcos>();
	}
	
	public void setBarcosTablero(ArrayList<ArrayList<Point>> tableroBarcos){
		for (ArrayList<Point> l: tableroBarcos){
			setBarco(new Barcos(l));
		}
		
	}
	
	public ArrayList<Barcos> getBarcosEnTablero() {
		return barcosEnTablero;
	}

	public void setBarco(Barcos barco) {//ubica el puntero del barco a posicionar en las posiciones que éste ocupa en el tablero
		barcosEnTablero.add(barco);
		
	}
	
	public Barcos get(Point coordenada){//devuelve el contenido del tablero en la coordenada pasada
		Barcos barco= null;
		for (Barcos b: barcosEnTablero){
			if(b.getPosiciones().contains(coordenada)){
				barco=b;
				break;
			}
		}
		return barco;
	}
	

	
}
