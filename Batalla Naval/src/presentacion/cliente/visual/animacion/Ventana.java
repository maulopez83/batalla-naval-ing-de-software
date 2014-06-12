package presentacion.cliente.visual.animacion;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;

import negocio.logica.comunicacion.mensajes.*;

import presentacion.cliente.visual.GUISubject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ventana {
	
	private JFrame frame;
	private GUISubject guiSubject;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Ventana() {
		guiSubject= new GUISubject();
		initialize();
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
		Tablero1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Mensaje msg= new MensajeDisparo(e.getPoint(),1);
				guiSubject.sendMessage(msg);
				JLabel newl= new JLabel("");
				int Xpos= (int)(e.getX()/50)*50+Tablero1.getX();
				int Ypos= (int)(e.getY()/50)*50+Tablero1.getY();
				newl.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/cliente/visual/imagen/Cruz Averiado.png")));
				newl.setBounds(Xpos,Ypos,50,50);
				frame.getContentPane().add(newl,0);
				frame.repaint();
			}
		});
		Tablero1.setBounds(150, 100, 500, 500);
		frame.getContentPane().add(Tablero1,0);
		
	}
	
}
