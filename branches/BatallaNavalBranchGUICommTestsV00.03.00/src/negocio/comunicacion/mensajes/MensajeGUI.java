package negocio.comunicacion.mensajes;

import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import negocio.comunicacion.elementosgraficos.BarcoGUI;
import negocio.comunicacion.elementosgraficos.ElementoGUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import presentacion.cliente.visual.Ventana;

public class MensajeGUI extends Mensaje implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<ElementoGUI> elementos;
	private Rectangle frameBounds;
	public MensajeGUI(){
		super(null);
		setType(new MGUI());
		this.elementos=new ArrayList<ElementoGUI>();
		frameBounds=null;
	}
	
	public ArrayList<ElementoGUI> getElementos() {
		return elementos;
	}
	public void addElemento(ElementoGUI elemento) {
		elementos.add(elemento);
	}

	public Rectangle getFrameBounds() {
		return frameBounds;
	}

	public void setFrameBounds(Rectangle frameBounds) {
		this.frameBounds = frameBounds;
	}
	
}
