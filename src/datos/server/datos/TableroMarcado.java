package datos.server.datos;

import java.awt.Point;
import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;

public class TableroMarcado{
	
	private ArrayList<Point> disparosEnTablero;
	private int contHundidos;
	public enum DISPARO{
		AGUA,
		AVERIADO,
		HUNDIDO,
		FINAL;
	}
	
	public TableroMarcado(){
		disparosEnTablero= new ArrayList<Point>();
		this.contHundidos=0;
	}
	
	public DISPARO setDisparo(Point disparo, TableroBarcos tabOponente) throws InvalidAlgorithmParameterException{
			DISPARO result= null;
		if(!disparosEnTablero.contains(disparo)){//verifico si el disparo en esa posicion no fue hecho todavia
			disparosEnTablero.add(disparo);
			Barcos b=tabOponente.get(disparo); // pido si existe un barco en el tablero oponente. Si no hay b=null.
			if(b!=null){//si hay un barco en la posicion disparada.
				result=b.disparar(disparo);
				if(result==DISPARO.HUNDIDO){
					contHundidos++;
					if (contHundidos==tabOponente.getBarcosEnTablero().size()){
						result=DISPARO.FINAL;
					}
				}
			}
			else{//si no hay barco cargo un elemento AGUA en el tablero
				result=DISPARO.AGUA;
			}
			
		}
		else{
			throw new InvalidAlgorithmParameterException("Se repitió un disparo ya realizado");
		}
		return result;
	}
	

	
	
}
