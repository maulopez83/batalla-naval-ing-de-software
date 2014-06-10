package presentacion.cliente.visual;

import presentacion.cliente.logica.comunicacion.*;
import presentacion.cliente.logica.comunicacion.mensajes.Mensaje;


public interface Observer {
	void update(Mensaje m);
}
