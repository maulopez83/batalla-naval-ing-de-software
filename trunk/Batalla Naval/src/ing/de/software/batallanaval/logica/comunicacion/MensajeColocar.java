package ing.de.software.batallanaval.logica.comunicacion;

import java.io.Serializable;

public class MensajeColocar extends Mensaje implements Serializable {

	private static final long serialVersionUID = 1L;

	public MensajeColocar(String msg,int senderID) {
		super(msg,senderID);
		setType(new Colocar());
	}
}
