package negocio.controladores;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;

public class BotonJugarMouseAdapter extends MouseAdapter implements Serializable{
	private static final long serialVersionUID = 1L;
	ArrayList<ArrayList<Point>> tablero;
	int cantBarcos;
	public BotonJugarMouseAdapter(ArrayList<ArrayList<Point>> tablero, int cantBarcos){
		this.tablero=tablero;
		this.cantBarcos=cantBarcos;
	}
	@Override
	public void mouseClicked (MouseEvent e){}

}
