package datos.server.datos;
import java.awt.Point;

import negocio.server.logica.*;

public interface Tablero{

	public abstract Barcos get(Point coordenada);
	
}
