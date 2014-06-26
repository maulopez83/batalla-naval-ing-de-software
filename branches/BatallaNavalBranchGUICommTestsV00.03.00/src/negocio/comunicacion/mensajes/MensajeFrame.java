package negocio.comunicacion.mensajes;

import java.awt.Component;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import negocio.comunicacion.elementosgraficos.ElementoGUI;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import presentacion.cliente.visual.Ventana;

public class MensajeFrame extends Mensaje implements Serializable{
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private int GridSize;
	private JLabel fondo;
	public MensajeFrame(JFrame frame, int gridSize,JLabel fondo){
		super();
		this.frame=frame;
		this.fondo=fondo;
		setType(new MFrame());
	}
	public JFrame getFrame() {
		return frame;
	}
	public int getGridSize() {
		return GridSize;
	}
	public JLabel getFondo() {
		return fondo;
	}
	
}
