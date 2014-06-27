package datos.server.datos;
import java.awt.Point;
import java.util.ArrayList;

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
	
	
	public String disparar (Point posicion){
	
		if(posiciones.contains(posicion)){
			int index = posiciones.indexOf(posicion);
			disparado.add(posiciones.get(index));
			posiciones.remove(index);
			if(!posiciones.isEmpty()){
				return "Averiado";
			}
			else{
				return "Hundido";
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
