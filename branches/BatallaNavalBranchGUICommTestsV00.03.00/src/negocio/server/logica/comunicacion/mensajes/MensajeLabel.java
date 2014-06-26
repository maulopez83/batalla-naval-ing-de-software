package negocio.server.logica.comunicacion.mensajes;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import presentacion.cliente.visual.Ventana;

public class MensajeLabel extends Mensaje implements Serializable{
	private static final long serialVersionUID = 1L;
	private Runnable function;

	public MensajeLabel(Runnable function){
		super();
		setType(new MLabel());
		this.function=function;
	}

	public Runnable getFunction() {
		return function;
	}

	public void setFunction(Runnable function) {
		this.function = function;
	}
	
}
