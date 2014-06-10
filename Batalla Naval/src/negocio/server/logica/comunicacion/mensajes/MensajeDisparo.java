package negocio.server.logica.comunicacion.mensajes;

import java.io.Serializable;
import java.io.Serializable;
/*
 * Mensaje Disparo extends Mensaje
 * Subtipo de mensaje, se decodifica con Disparo.decodificar()
 */
public class MensajeDisparo extends Mensaje implements Serializable{

	private static final long serialVersionUID = 1L;

	public MensajeDisparo(String msg,int senderID) {
		super(msg,senderID);
		setType(new Disparo());
	}

}
