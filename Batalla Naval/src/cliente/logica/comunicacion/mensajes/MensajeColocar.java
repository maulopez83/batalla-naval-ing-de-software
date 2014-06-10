package cliente.logica.comunicacion.mensajes;

import java.io.Serializable;

/*
 * Mensaje Colocar extends Mensaje
 * Subtipo de mensaje, se decodifica con Colocar.decodificar()
 */
public class MensajeColocar extends Mensaje implements Serializable {

	private static final long serialVersionUID = 1L;

	public MensajeColocar(String msg,int senderID) {
		super(msg,senderID);
		setType(new Colocar());
	}
}
