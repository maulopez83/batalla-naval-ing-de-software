package datos;
import java.awt.Point;
import java.util.ArrayList;

import datos.TableroMarcado.DISPARO;

public class Barcos{
	
	private ArrayList<Point> posiciones;
	private int large;
	private ArrayList<Point> disparado;
	
	public Barcos(ArrayList<Point> posiciones){
		this.posiciones=posiciones;
		this.large=posiciones.size();
		disparado= new ArrayList<Point>();
	}

	
	public ArrayList<Point> getPosiciones(){
		return this.posiciones;
	}
	
	public int getLarge(){
		return large;
	}
	
	
	public DISPARO disparar (Point posicion){
	
		if(posiciones.contains(posicion)){
			int index = posiciones.indexOf(posicion);
			disparado.add(posiciones.get(index));
			posiciones.remove(index);
			if(!posiciones.isEmpty()){
				return DISPARO.AVERIADO;
			}
			else{
				return DISPARO.HUNDIDO;
			}
		}		
		return null;	
	}
	public String toString(){
		String result= "";
		for (Point p: getPosiciones()){
			result+= ("("+p.x+", "+p.y+")\n");
		}
		return result;
	}
}
