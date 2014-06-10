package ing.de.software.batallanaval.logica;
import ing.de.software.batallanaval.datos.*;

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

	public void setDatoTablero1(Coordenada coord, EnumTablero dato) {
		tablero1.setDato(coord, dato);
		
	}
	
	public void setDatoTablero2(Coordenada coord, EnumTablero dato) {
		tablero2.setDato(coord, dato);
		
	}

	public EnumTablero getDatoTablero1(Coordenada coord) {
		return tablero1.getDato(coord);
		
	}

	public EnumTablero getDatoTablero2(Coordenada coord) {
		return tablero2.getDato(coord);
		
	}

}
