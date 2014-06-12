package negocio.logica.comunicacion.mensajes;

import java.awt.Point;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import presentacion.cliente.visual.animacion.Ventana;

import negocio.logica.comunicacion.mensajes.*;


import datos.server.datos.*;

/*
 * Patron Strategy:
 * Esta interfaz declara el metodo decodificar.
 * es implementada por distintas clases que señalan tipos de Mensaje
 * Esto sirve para que cada Mensaje se decodifique de una forma especifica
 * y su implementación este oculta.
 * 
 */

public interface Decodificacion extends Serializable {
	String decodificar(Mensaje m);
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
	public String decodificar(Mensaje m){
		MensajeDisparo msg=(MensajeDisparo) m;
		Point p= msg.getPoint();
		int Xpos= (int)(p.getX()/50);
		int Ypos= (int)(p.getY()/50);
		
		DataSingleton GameData = DataSingleton.getInstance();
		GameData.setDato(5);
		System.out.println("Se presiono: ");
		System.out.println("X: "+Xpos);
		System.out.println("Y: "+Ypos);
		return "Es un disparo";
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
	public String decodificar(Mensaje m){
		DataSingleton GameData = DataSingleton.getInstance();
		GameData.setDato(8);
		System.out.println("El dato es: "+ GameData.getDato());
		return "Es Desconectar";
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
	public String decodificar(Mensaje m){
		DataSingleton GameData = DataSingleton.getInstance();
		GameData.setDato(2);
		System.out.println("El dato es: "+ GameData.getDato());
		return "Es Conectar";
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
	public String decodificar(Mensaje m){
		DataSingleton GameData = DataSingleton.getInstance();
		GameData.setDato(3);
		System.out.println("El dato es: "+ GameData.getDato());
		return "Es Colocar";
	}
}
class MLabel implements Decodificacion{
		private static final long serialVersionUID = 1L;
		/*
		 * decodificar()
		 * returns: String? (deberia ser void capaz dsp lo vemos)
		 * params: Mensaje m
		 * DEBE DECODIFICAR LO QUE PASA CUANDO LLEGA MENSAJE DE COLOCAR, FALTA IMPLEMENTAR BIEN 
		 */
		public String decodificar(Mensaje m){
			Ventana GameWindow = Ventana.getInstance();
			JLabel label= new JLabel();
			MensajeLabel msg= (MensajeLabel) m;
			label.setIcon(msg.getImage());
			int Xpos=(int)msg.getPosition().getX();
			int Ypos=(int)msg.getPosition().getY();
			int Width=(int)msg.getWidHeig().getX();
			int Height=(int)msg.getWidHeig().getY();
			label.setBounds(Xpos,Ypos,Width,Height);
			GameWindow.getFrame().getContentPane().add(label,0);
			GameWindow.getFrame().repaint();
			return "Es Label";
		}
	}