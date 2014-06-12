package negocio.logica.comunicacion.mensajes;

import java.io.Serializable;
/*
 * Mensaje Conectar extends Mensaje
 * Subtipo de mensaje, se decodifica con Conectar.decodificar()
 */
public class MensajeConectar extends Mensaje implements Serializable {
	private static final long serialVersionUID = 1L;

	public MensajeConectar() {
		super();
		setType(new Conectar());
	}
}
