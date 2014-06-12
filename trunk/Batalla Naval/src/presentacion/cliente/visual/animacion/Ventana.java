package presentacion.cliente.visual.animacion;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ventana {

	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
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
				JLabel newl= new JLabel("");
				newl.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/cliente/visual/imagen/Cruz Averiado.png")));
				int Xpos= (int)(e.getX()/50)*50+Tablero1.getX();
				int Ypos= (int)(e.getY()/50)*50+Tablero1.getY();
				newl.setBounds(Xpos,Ypos,50,50);
				frame.getContentPane().add(newl,0);
				frame.repaint();
			}
		});
		Tablero1.setBounds(150, 100, 500, 500);
		frame.getContentPane().add(Tablero1,0);
		
	}
	
}
