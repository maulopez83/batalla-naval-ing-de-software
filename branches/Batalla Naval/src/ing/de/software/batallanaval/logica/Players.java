package ing.de.software.batallanaval.logica;

public interface Players {
	
	
	abstract int getNumeroJugador();
	abstract void setDatoTablero1(Coordenada coord, EnumTablero dato);
	abstract void setDatoTablero2(Coordenada coord, EnumTablero dato);
	abstract EnumTablero getDatoTablero1(Coordenada coord);
	abstract EnumTablero getDatoTablero2(Coordenada coord);
	
}
