package cliente.visual;

import cliente.logica.comunicacion.*;
import cliente.logica.comunicacion.mensajes.Mensaje;


public interface Observer {
	void update(Mensaje m);
}
