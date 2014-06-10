package cliente.logica.comunicacion.mensajes;

import java.io.Serializable;
/*
 * Mensaje Desconectar extends Mensaje
 * Subtipo de mensaje, se decodifica con Desconectar.decodificar()
 */
public class MensajeDesconectar extends Mensaje implements Serializable {

	private static final long serialVersionUID = 1L;

	public MensajeDesconectar(String msg,int senderID) {
		super(msg,senderID);
		setType(new Desconectar());
	}
}
