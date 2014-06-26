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
	private int fromTab;
	public MensajeDisparo(Point p, int fromTab) {
		super();
		this.p=p;
		this.fromTab=fromTab;
		setType(new Disparo());
	}
	
	public Point getPoint() {
		return p;
	}
	
	
}
