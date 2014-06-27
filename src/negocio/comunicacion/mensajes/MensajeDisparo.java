package negocio.comunicacion.mensajes;

import java.awt.Point;
import java.io.Serializable;
/*
 * Mensaje Disparo extends Mensaje
 * Subtipo de mensaje, se decodifica con Disparo.decodificar()
 */
public class MensajeDisparo extends Mensaje implements Serializable{

	private static final long serialVersionUID = 1L;
	private	Point p;
	public MensajeDisparo(Point p, String clientID) {
		super();
		this.p=p;
		setType(new Disparo());
	}
	
	public Point getPoint() {
		return p;
	}
	
	
}
