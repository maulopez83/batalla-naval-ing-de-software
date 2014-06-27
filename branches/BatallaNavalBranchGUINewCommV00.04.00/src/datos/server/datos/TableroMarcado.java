package datos.server.datos;

import java.awt.Point;
import java.util.ArrayList;

public class TableroMarcado{
	
	private ArrayList<Point> disparosEnTablero;
	
	public TableroMarcado(){
		disparosEnTablero= new ArrayList<Point>();
	}
	
	public void setDisparo(Point disparo, TableroBarcos tabOponente){
	
		if(!disparosEnTablero.contains(disparo)){//verifico si el disparo en esa posicion no fue hecho todavia
			disparosEnTablero.add(disparo);
			Barcos b=tabOponente.get(disparo); // pido si existe un barco en el tablero oponente. Si no hay b=null.
			if(b!=null){//si hay un barco en la posicion disparada.
				System.out.println(b.disparar(disparo));
			}
		
			else{//si no hay barco cargo un elemento AGUA en el tablero
				System.out.println("Agua");
			}
		}
		else{
			System.out.println("El disparo ya fue hecho en la posicion pasada!");
		}
	}
	

	
	
}
