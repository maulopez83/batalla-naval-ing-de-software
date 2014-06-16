package presentacion.cliente.visual;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;

import presentacion.cliente.logica.comunicacion.GUISubject;

import datos.server.datos.DataSingleton;

import negocio.server.logica.comunicacion.mensajes.*;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ventana {
	private static Ventana GameWindow;
	private JFrame frame;
	private GUISubject guiSubject;
	/**
	 * Create the application.
	 */
	private Ventana() {
		guiSubject= new GUISubject();
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
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	}
	
}
