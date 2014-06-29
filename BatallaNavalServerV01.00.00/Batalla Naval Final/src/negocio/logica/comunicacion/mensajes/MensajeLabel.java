package negocio.logica.comunicacion.mensajes;

import java.awt.Point;
import java.io.Serializable;

import javax.swing.JLabel;

public class MensajeLabel extends Mensaje implements Serializable{
	private static final long serialVersionUID = 1L;
	private String imageloc;
	private Point position;
	private Point WidHeig;
	
	public MensajeLabel(String imageloc, Point position, Point WidHeig ){
		super();
		this.imageloc=imageloc;
		this.WidHeig=WidHeig;
		this.position=position;
		setType(new MLabel());
		setID("LABEL");
	}

	public String getImageloc() {
		return imageloc;
	}

	public Point getPosition() {
		return position;
	}

	public Point getWidHeig() {
		return WidHeig;
	}

	
	
	
}
