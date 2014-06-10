package mensajesServer;

import java.io.Serializable;
/*
 * Mensaje Conectar extends Mensaje
 * Subtipo de mensaje, se decodifica con Conectar.decodificar()
 */
public class MensajeConectar extends Mensaje implements Serializable {
	private static final long serialVersionUID = 1L;

	public MensajeConectar(String msg,int senderID) {
		super(msg,senderID);
		setType(new Conectar());
	}
}
