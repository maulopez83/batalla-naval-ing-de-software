package ing.de.software.batallanaval.datos;
import ing.de.software.batallanaval.logica.*;

public interface Tablero{
	
	abstract void setDato(Coordenada coordenada, EnumTablero dato);
	abstract EnumTablero getDato(Coordenada coordenada);
	
}
