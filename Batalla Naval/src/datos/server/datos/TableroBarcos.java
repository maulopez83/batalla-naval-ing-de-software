package datos.server.datos;

import java.awt.Point;
import java.util.ArrayList;

import negocio.server.logica.*;

public class TableroBarcos extends Tablero{
	
	private ArrayList<ArrayList<ElementosTableros>> tablero= new ArrayList<ArrayList<ElementosTableros>>();
	
	public TableroBarcos(){
		for (int fil=0; fil<10; fil++){//inicializo las 10 filas de arrays
			tablero.add(new ArrayList<ElementosTableros>());
		}
		
		for (int fil=0; fil<10; fil++){
			for (int col=0; col<10; col++){
				tablero.get(fil).add(null);//relleno el array de cada fila con null(NO BARCOS).
			}
		}
	}

	public void setBarco(Barcos barco) {//ubica el puntero del barco a posicionar en las posiciones que éste ocupa en el tablero
		for(int pos=0; pos<barco.getPosicion().size(); pos++){
		tablero.get((int)barco.getPosicion().get(pos).getX()).add((int)barco.getPosicion().get(pos).getY(), barco);
		}
		
	}
	
	public ElementosTableros get(Point coordenada){//devuelve el contenido del tablero en la coordenada pasada
		return tablero.get((int)coordenada.getX()).get((int)coordenada.getY());
	}
	
	public boolean setDisparoRecibido(Point disparo){
		if(get(disparo)!=null){
			get(disparo).marcar(disparo);//marco al barco en la posicion donde se está disparando para saber si se hundio o se averió. VA A DEVOLVER UN STRING EN PANTALLA RESULTADO DE ESTO
			//PUEDE SER QUE IMPRIMA "BARCO TAL HUNDIDO"; "BARCO DISPARADO PERO NO HUNDIDO"; o "ERROR" porque tendria que haber un barco si entro hasta aca pero no lo estaria viendo.
			return true;
		}
		else{
			System.out.println("Disparo fallido, agua");
			return false;
		}
	}
	
}
