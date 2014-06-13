package negocio.server.logica;
import datos.server.datos.*;

public class Player2 implements Players{

	private Tablero tablero1;
	private Tablero tablero2;
	
	public Player2(){
		tablero1=new TableroBarcos();
		tablero2=new TableroBarcos();
	}
	
	public int getNumeroJugador() {
		return 2;
		
	}

	public void setDatoTablero1() {
		
	}
	
	public void setDatoTablero2() {
		
	}

}
