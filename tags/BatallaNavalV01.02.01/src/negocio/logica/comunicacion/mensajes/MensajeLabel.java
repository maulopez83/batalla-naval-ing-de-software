package negocio.logica.comunicacion.mensajes;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MensajeLabel extends Mensaje implements Serializable{
	private static final long serialVersionUID = 1L;
	private String imageloc;
	private Point position;
	private Point WidHeig;
	private ImageIcon imagen;
	public MensajeLabel(String imageloc, Point position, Point WidHeig ){
		super();
		try {
			imagen= new ImageIcon(ImageIO.read(new File(imageloc)));
			System.out.println("imagen cargada");
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.WidHeig=WidHeig;
		this.position=position;
		setType(new MLabel());
		setID("LABEL");
	}

	public ImageIcon getImage() {
		return imagen;
	}

	public Point getPosition() {
		return position;
	}

	public Point getWidHeig() {
		return WidHeig;
	}

	
	
	
}
