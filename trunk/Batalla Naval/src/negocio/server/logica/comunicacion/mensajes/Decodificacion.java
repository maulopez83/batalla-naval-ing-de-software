package negocio.server.logica.comunicacion.mensajes;

import java.awt.Point;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import presentacion.cliente.visual.Ventana;


import negocio.server.logica.comunicacion.mensajes.*;
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
		int Xpos= (int)(p.getX()/50);
		int Ypos= (int)(p.getY()/50);
		
		DataSingleton GameData = DataSingleton.getInstance();
		System.out.println("Se presiono: ");
		System.out.println("X: "+Xpos);
		System.out.println("Y: "+Ypos);
		String averiado="src/datos/server/datos/imagenes/Cruz Averiado.png";
		Point pos= new Point(Xpos*50+150,Ypos*50+100); // aca esos +150 y +100 dependen de que tablero sea, hay que arreglarlo para que sea generico
		Point wh = new Point(50,50);
		return null;
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
		DataSingleton GameData = DataSingleton.getInstance();
		return null;
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
		return null;
	}
}
class MLabel implements Decodificacion{
		private static final long serialVersionUID = 1L;
		/*
		 * decodificar()
		 * returns: String? (deberia ser void capaz dsp lo vemos)
		 * params: Mensaje m
		 * DEBE DECODIFICAR LO QUE PASA EN EL CLIENTE CUANDO LLEGA UNA IMAGEN PARA PONER EN GUI, FALTA IMPLEMENTAR BIEN 
		 */
		public Mensaje decodificar(Mensaje m){
			MensajeLabel msg= (MensajeLabel) m;
			Thread msgFunc = new Thread(msg.getFunction());
			msgFunc.start();
			return null;
		}
	}