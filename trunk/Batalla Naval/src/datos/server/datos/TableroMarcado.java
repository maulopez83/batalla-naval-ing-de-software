package datos.server.datos;

import java.awt.Point;
import java.util.ArrayList;

public class TableroMarcado extends Tablero{
	
	private ArrayList<ArrayList<ElementosTableros>> tablero= new ArrayList<ArrayList<ElementosTableros>>();
	
	public TableroMarcado(){
		for (int fil=0; fil<10; fil++){//inicializo las 10 filas de arrays
			tablero.add(new ArrayList<ElementosTableros>());
		}
		
		for (int fil=0; fil<10; fil++){
			for (int col=0; col<10; col++){
				tablero.get(fil).add(null);//relleno el array de cada fila con null(NO BARCOS).
			}
		}
	}
	
	public void setDisparoHecho(Point disparo, TableroBarcos taboponente){
	
		if(get(disparo)==null){//verifico si el disparo en esa posicion no fue hecho todavia
			if(taboponente.setDisparoRecibido(disparo)){//si hay un barco en la posicion pasada, cargo un barco de tipo desconocido
				ArrayList<Point> coordenada = new ArrayList<Point>();
				coordenada.add(disparo);
				TipoDesconocido barco= new TipoDesconocido(coordenada);
				tablero.get((int)disparo.getX()).add((int)disparo.getY(), barco);
			}
		
			else{//si no hay barco cargo un elemento AGUA en el tablero
				Agua fallido= new Agua();
				tablero.get((int)disparo.getX()).add((int)disparo.getY(), fallido);//agrego el elemento agua
			}
		}
		else{
			System.out.println("El disparo ya fue hecho en la posicion pasada!");
		}
	}
	
	public ElementosTableros get(Point coordenada){//devuelve el contenido del tablero en la coordenada pasada
		return tablero.get((int)coordenada.getX()).get((int)coordenada.getY());
	}
	
	
}
