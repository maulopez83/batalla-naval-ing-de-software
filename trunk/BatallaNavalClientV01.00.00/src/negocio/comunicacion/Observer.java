package negocio.comunicacion;

import negocio.comunicacion.mensajes.Mensaje;


public interface Observer {
	void update(Mensaje m);
}
