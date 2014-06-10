package observer;

import logica.*;
import logica.mensajes.Mensaje;

public interface Observer {
	void update(Mensaje m);
}
