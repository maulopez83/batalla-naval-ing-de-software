package presentacion.cliente.visual;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;

import presentacion.cliente.logica.comunicacion.GUISubject;

import datos.server.datos.DataSingleton;

import negocio.comunicacion.mensajes.*;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ventana {
	private static Ventana GameWindow;

	private int GridSize;

	
	private JFrame frame;
	private GUISubject guiSubject;
	
	/**
	 * Create the application.
	 */
	
	private Ventana() {
		guiSubject= new GUISubject();
		GridSize=0;
	}
	public static Ventana getInstance(){
		if (GameWindow == null){
			GameWindow= new Ventana();
		}
		return GameWindow;
	}
	public JFrame getFrame(){
	return frame;
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public GUISubject getGuiSubject() {
		return guiSubject;
	}
	
	
	public int getGridSize() {
		return GridSize;
	}
	public void setGridSize(int gridSize) {
		GridSize = gridSize;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	}
	
}
