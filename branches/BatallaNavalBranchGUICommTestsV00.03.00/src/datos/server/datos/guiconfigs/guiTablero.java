package datos.server.datos.guiconfigs;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import negocio.comunicacion.mensajes.Mensaje;
import negocio.comunicacion.mensajes.MensajeDisparo;
import presentacion.cliente.visual.Ventana;

public class guiTablero implements Runnable {

		public void run() {
			Ventana GameWindow=Ventana.getInstance();
			JFrame frame;
			frame = new JFrame();
			frame.setBounds(100, 100, 1380, 820);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			Ventana.getInstance().setFrame(frame);
			Ventana.getInstance().getFrame().setVisible(true);
			
			JLabel Fondo = new JLabel("");
			Fondo.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/cliente/visual/imagen/Tablero2.png")));
			Fondo.setBounds(0, 0, 1280, 720);
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
					Ventana.getInstance().getGuiSubject().sendMsg(msg);
				}
			});
			Tablero1.setBounds(150, 100, 500, 500);
			frame.getContentPane().add(Tablero1,0);
		
	}

}
