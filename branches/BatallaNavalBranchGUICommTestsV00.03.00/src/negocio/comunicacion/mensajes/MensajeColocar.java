package negocio.comunicacion.mensajes;

import java.io.Serializable;

import javax.swing.JLabel;

/*
 * Mensaje Colocar extends Mensaje
 * Subtipo de mensaje, se decodifica con Colocar.decodificar()
 */
public class MensajeColocar extends Mensaje implements Serializable {

	private static final long serialVersionUID = 1L;
	private String pedorro;
	public MensajeColocar(String pedorro) {
		super();
		setType(new Colocar());
		this.pedorro=pedorro;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getPedorro() {
		return pedorro;
	}
	
	
	
}
