package ing.de.software.batallanaval.visual.comunicacion;

import java.io.Serializable;

public class MensajeDisparo extends Mensaje implements Serializable{

	private static final long serialVersionUID = 1L;

	public MensajeDisparo(String msg,int senderID) {
		super(msg,senderID);
		setType(new Disparo());
	}

}
