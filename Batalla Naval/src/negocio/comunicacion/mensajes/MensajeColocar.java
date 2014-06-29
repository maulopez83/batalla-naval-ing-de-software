package negocio.comunicacion.mensajes;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JLabel;

/*
 * Mensaje Colocar extends Mensaje
 * Subtipo de mensaje, se decodifica con Colocar.decodificar()
 */
public class MensajeColocar extends Mensaje implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<ArrayList<Point>> tablero;
	public MensajeColocar(ArrayList<ArrayList<Point>> tablero) {
		super();
		setType(new Colocar());
		this.tablero=tablero;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ArrayList<ArrayList<Point>>  getTablero() {
		return tablero;
	}
	
	
	
}
