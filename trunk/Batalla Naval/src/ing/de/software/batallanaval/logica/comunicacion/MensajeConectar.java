package ing.de.software.batallanaval.logica.comunicacion;

import java.io.Serializable;

public class MensajeConectar extends Mensaje implements Serializable {
	private static final long serialVersionUID = 1L;

	public MensajeConectar(String msg,int senderID) {
		super(msg,senderID);
		setType(new Conectar());
	}
}
