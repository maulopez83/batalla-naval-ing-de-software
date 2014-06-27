package presentacion.cliente.logica.comunicacion;

import negocio.comunicacion.mensajes.Mensaje;
import presentacion.cliente.logica.comunicacion.*;


public interface Observer {
	void update(Mensaje m);
}
