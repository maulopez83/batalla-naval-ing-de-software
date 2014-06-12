package presentacion.cliente.logica.comunicacion;

import negocio.logica.comunicacion.mensajes.Mensaje;
import presentacion.cliente.logica.comunicacion.*;


public interface Observer {
	void update(Mensaje m);
}
