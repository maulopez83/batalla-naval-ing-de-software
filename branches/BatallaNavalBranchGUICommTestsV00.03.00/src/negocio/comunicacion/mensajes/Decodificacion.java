package negocio.comunicacion.mensajes;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import presentacion.cliente.visual.Ventana;


import negocio.comunicacion.elementosgraficos.ElementoGUI;
import negocio.comunicacion.mensajes.*;
import datos.server.datos.*;
import datos.server.datos.guiconfigs.PlantillaVentanaColocar;

/*
 * Patron Strategy:
 * Esta interfaz declara el metodo decodificar.
 * es implementada por distintas clases que señalan tipos de Mensaje
 * Esto sirve para que cada Mensaje se decodifique de una forma especifica
 * y su implementación este oculta.
 * 
 */

public interface Decodificacion extends Serializable {
	Mensaje decodificar(Mensaje m);
}
/*
 * Disparo - implements Decodificación
 * Clase con el metodo para decodificar mensajes de Tipo Disparo
 * 
 */
class Disparo implements Decodificacion {
	private static final long serialVersionUID = 1L;
	/*
	 * decodificar()
	 * returns: String? (deberia ser void capaz dsp lo vemos)
	 * params: Mensaje m
	 * DEBE DECODIFICAR LO QUE PASA CUANDO LLEGA UN DISPARO, FALTA IMPLEMENTAR BIEN 
	 */
	public Mensaje decodificar(Mensaje m){
		MensajeDisparo msg=(MensajeDisparo) m;
		Point p= msg.getPoint();
		int Xpos= (int)(p.getX());
		int Ypos= (int)(p.getY());
		
		DataSingleton GameData = DataSingleton.getInstance();
		System.out.println("Se presiono: ");
		System.out.println("X: "+Xpos);
		System.out.println("Y: "+Ypos);
		return new MensajeColocar("Te respondo un String pedorro. ");
	}
}
/*
 * Desconectar - implements Decodificación
 * Clase con el metodo para decodificar mensajes de Tipo Desconectar
 * 
 */
class Desconectar implements Decodificacion{
	private static final long serialVersionUID = 1L;
	/*
	 * decodificar()
	 * returns: String? (deberia ser void capaz dsp lo vemos)
	 * params: Mensaje m
	 * DEBE DECODIFICAR LO QUE PASA CUANDO LLEGA MENSAJE DE DESCONECTAR, FALTA IMPLEMENTAR BIEN 
	 */
	public Mensaje decodificar(Mensaje m){
		DataSingleton GameData = DataSingleton.getInstance();
		return null;
	}
}
/*
 * Conectar - implements Decodificación
 * Clase con el metodo para decodificar mensajes de Tipo Conectar
 * 
 */
class Conectar implements Decodificacion{
	private static final long serialVersionUID = 1L;
	/*
	 * decodificar()
	 * returns: String? (deberia ser void capaz dsp lo vemos)
	 * params: Mensaje m
	 * DEBE DECODIFICAR LO QUE PASA CUANDO LLEGA MENSAJE DE CONECTAR, FALTA IMPLEMENTAR BIEN 
	 */
	public Mensaje decodificar(Mensaje m){
		MensajeConectar msg = (MensajeConectar) m;
		DataSingleton GameData = DataSingleton.getInstance();
		
		if(msg.getVersion().equals(GameData.getCurrentVersion())){
			GameData.addClient(msg.getClientID());
			System.out.println("Se agrego el cliente: " + msg.getClientID());
		}
		
		else{
			
		}
		PlantillaVentanaColocar p = new PlantillaVentanaColocar();
		return p.create();
	}
}

/*
 * Colocar - implements Decodificación
 * Clase con el metodo para decodificar mensajes de Tipo Colocar
 * 
 */
class Colocar implements Decodificacion{
	private static final long serialVersionUID = 1L;
	/*
	 * decodificar()
	 * returns: String? (deberia ser void capaz dsp lo vemos)
	 * params: Mensaje m
	 * DEBE DECODIFICAR LO QUE PASA CUANDO LLEGA MENSAJE DE COLOCAR, FALTA IMPLEMENTAR BIEN 
	 */
	public Mensaje decodificar(Mensaje m){
		DataSingleton GameData = DataSingleton.getInstance();
		MensajeColocar msg = (MensajeColocar) m;
		System.out.println(msg.getPedorro());
		return null;
	}
}
class MGUI implements Decodificacion{
		private static final long serialVersionUID = 1L;
		/*
		 * decodificar()
		 * returns: String? (deberia ser void capaz dsp lo vemos)
		 * params: Mensaje m
		 * DEBE DECODIFICAR LO QUE PASA EN EL CLIENTE CUANDO LLEGA UNA IMAGEN PARA PONER EN GUI, FALTA IMPLEMENTAR BIEN 
		 */
		public Mensaje decodificar(Mensaje m){
			MensajeGUI msg= (MensajeGUI) m;
			Ventana GameWindow = Ventana.getInstance();
			if(msg.getFrameBounds()!=null){
				GameWindow.getFrame().dispose();
				JFrame frame= new JFrame();
				frame.setResizable(false);
				frame.setBounds(msg.getFrameBounds());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				GameWindow.setFrame(frame);
				GameWindow.getFrame().setVisible(true);
			}
			
			for(ElementoGUI eg : msg.getElementos()){
				GameWindow.getFrame().add(createLabel(eg),0);
			}
				
			return null;
			}
		
		public JLabel createLabel(ElementoGUI eg){
			JLabel newLabel= new JLabel();
			newLabel.setText(eg.getText());
			newLabel.setBounds(eg.getBounds());
			newLabel.setIcon(eg.getIcon());
			if (eg.getAdapter()!=null){
				newLabel.addMouseListener(eg.getAdapter());
				newLabel.addMouseMotionListener(eg.getAdapter());
			}
			return newLabel;
		}
}
class MFrame implements Decodificacion{
			private static final long serialVersionUID = 1L;
			/*
			 * decodificar()
			 * returns: String? (deberia ser void capaz dsp lo vemos)
			 * params: Mensaje m	
			 */
			public Mensaje decodificar(Mensaje m){
				MensajeFrame msg= (MensajeFrame) m;
				Ventana GameWindow= Ventana.getInstance();
				GameWindow.getFrame().dispose();
				GameWindow.setFrame(msg.getFrame());
				GameWindow.getFrame().setVisible(true);
				GameWindow.setGridSize(msg.getGridSize());
				return null;
			}
	}
