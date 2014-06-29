package presentacion.cliente.logica.comunicacion;

import negocio.comunicacion.mensajes.Mensaje;


public interface Observer {
	void update(Mensaje m);
}
