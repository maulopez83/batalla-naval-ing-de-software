package datos.server.datos;
import java.awt.Point;
import java.util.ArrayList;

public abstract class Barcos implements ElementosTableros{
	
	private ArrayList<Point> posiciones=new ArrayList<Point>();
	private int large;
	private ArrayList<Boolean> disparado;
	
	public Barcos(ArrayList<Point> posiciones){
		this.posiciones=posiciones;
		this.large=posiciones.size();
		
		for(int i=0; i<large; i++){
			disparado.add(null);//en principio no va a estar disparado ninguna posicion del barco
		}
	}
	
	public abstract void MensajeHundido();
	
	public ArrayList<Point> getPosicion(){
		return this.posiciones;
	}
	
	public int getLarge(){
		return large;
	}
	
	public void marcar(Point posicion){
		
		boolean HayBarco=false;
		
		for(int i=0; i<posiciones.size(); i++){//voy recorriendo el array de posiciones del barco
			if(posiciones.get(i).equals(posicion)){//
				HayBarco=true;
				if(!disparado.get(i)){
					disparado.add(i,true);
					if(hundido()){
						MensajeHundido();
					}
					else{
						System.out.println("El barco fue disparado pero todavia no está hundido!");
					}
					break;
				}
				else{
					System.out.println("Un disparo ya fue hecho en esta posicion");
					break;
				}
			}	
		}
		
		if(!HayBarco){//SI NO HAY BARCO EN LA POSICION PASADA ALGO ANDA MAL PORQUE VERIFIQUE AL LLAMAR A ESTE METODO QUE SI HABIA UN BARCO...
			System.out.println("ERROR, no se encuentra el barco para marcarlo");
		}
	}
	
	public boolean hundido(){
		for(boolean averiado: disparado){
			if (averiado==false){
				return false;//si hay una posicion del barco aún no disparada retorna "false" (no hundido)
			}
		}
	return true;//si no entra nunca en el if anterior es porque está hundido el barco.
	}
	
}
