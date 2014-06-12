package negocio.logica.comunicacion.mensajes;

import java.io.Serializable;

import javax.swing.JLabel;

/*
 * Mensaje Colocar extends Mensaje
 * Subtipo de mensaje, se decodifica con Colocar.decodificar()
 */
public class MensajeColocar extends Mensaje implements Serializable {

	private static final long serialVersionUID = 1L;
	public MensajeColocar() {
		super();
		setType(new Colocar());
	}

	
}
