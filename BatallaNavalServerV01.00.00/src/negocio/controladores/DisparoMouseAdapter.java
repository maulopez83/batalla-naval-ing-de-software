package negocio.controladores;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;

public class DisparoMouseAdapter extends MouseAdapter implements Serializable {
	private static final long serialVersionUID = 1L;
	private int tamCasilla;
	private ArrayList<Point> disparosHechos;
	public DisparoMouseAdapter(int tamCasilla){
		this.tamCasilla=tamCasilla;
		disparosHechos= new ArrayList<Point>();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}
}
