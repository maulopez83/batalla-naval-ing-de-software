package negocio.server.logica;
import datos.server.datos.*;

public class Player2 implements Players{

	private Tablero tablero1;
	private Tablero tablero2;
	
	public Player2(){
		tablero1=new TableroTradicional();
		tablero2=new TableroTradicional();
	}
	
	public int getNumeroJugador() {
		return 2;
		
	}

	public void setDatoTablero1() {
		tablero1.setDato();
		
	}
	
	public void setDatoTablero2() {
		
	}

}
