package presentacion.cliente.logica.controladores;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;

import negocio.comunicacion.mensajes.Mensaje;
import negocio.comunicacion.mensajes.MensajeDisparo;
import presentacion.cliente.visual.Ventana;

public class DisparoMouseAdapter extends MouseAdapter implements Serializable {
	private static final long serialVersionUID = 1L;
	private int tamCasilla;
	private ArrayList<Point> disparosHechos;
	public DisparoMouseAdapter(int tamCasilla){
		this.tamCasilla=tamCasilla;
		disparosHechos= new ArrayList<Point>();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Point p= e.getPoint();
		int xPos= p.x /tamCasilla;
		int yPos= p.y /tamCasilla;
		Point result= new Point(xPos,yPos);
		if(!disparosHechos.contains(result) && Ventana.getInstance().isTurno()){
			Mensaje msg= new MensajeDisparo(new Point(xPos,yPos));
			Ventana.getInstance().getGuiSubject().sendMsg(msg);
			disparosHechos.add(result);
		}
		
	}
}
