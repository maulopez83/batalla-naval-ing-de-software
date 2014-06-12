package presentacion.cliente.visual;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;

import datos.server.datos.DataSingleton;

import negocio.logica.comunicacion.mensajes.*;


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
		initialize();
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
	
	
	public GUISubject getGuiSubject() {
		return guiSubject;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1380, 820);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/cliente/visual/imagen/Tablero2.png")));
		Fondo.setBounds(0, 0, 1280, 727);
		frame.getContentPane().add(Fondo);
		
		final JLabel Tablero1 = new JLabel("");
		/*
		 * Si hago un click en el tablero, se crea un mensaje de disparo con 
		 * el punto que contiene las coordenadas en pixeles relativas al tablero.
		 */
		Tablero1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Mensaje msg= new MensajeDisparo(e.getPoint(),1);
				guiSubject.sendMsg(msg);
			}
		});
		Tablero1.setBounds(150, 100, 500, 500);
		frame.getContentPane().add(Tablero1,0);
		
	}
	
}
