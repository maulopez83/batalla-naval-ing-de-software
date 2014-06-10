package server.logica;
import server.datos.*;

public class Player1 implements Players{

	private Tablero tablero1;
	private Tablero tablero2;
	
	public Player1(){
		tablero1=new TableroTradicional();
		tablero2=new TableroTradicional();
	}
	
	public int getNumeroJugador() {
		return 1;
		
	}

	public void setDatoTablero1() {
		tablero1.setDato();
		
	}
	
	public void setDatoTablero2() {
		tablero2.setDato();
		
	}


}
