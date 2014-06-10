package mensajesServer;

import java.io.Serializable;

public class MensajeDesconectar extends Mensaje implements Serializable {

	private static final long serialVersionUID = 1L;

	public MensajeDesconectar(String msg,int senderID) {
		super(msg,senderID);
		setType(new Desconectar());
	}
}
