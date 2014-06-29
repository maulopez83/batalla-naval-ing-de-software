package presentacion.cliente.logica.controladores;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;

public class BarcosMouseAdapter extends MouseAdapter implements Serializable {		
	private static final long serialVersionUID = 1L;
		private Rectangle tablero;
		private int initialX;
		private int initialY;
		private int tamCasilla;
		private int casillasAncho;
		private int casillasAlto;
		private ArrayList<ArrayList<Point>>tabOcup;
		private ArrayList<Point> posBarco;
		private boolean orientacion;
		private byte[] Vert;
		private byte[] Horiz;	
		
		public BarcosMouseAdapter(Rectangle tablero, int tamCasilla,int casillasAncho,
						int casillasAlto, ArrayList<ArrayList<Point>> tabOcupado, byte[] Vert,byte[] Horiz){
			this.tablero=tablero;
			this.tamCasilla=tamCasilla;
			this.casillasAncho=casillasAncho;
			this.casillasAlto=casillasAlto;
			this.tabOcup=tabOcupado;
			this.posBarco= new ArrayList<Point>();
			this.orientacion=true;
			this.Vert=Vert;
			this.Horiz=Horiz;
		}
		
		@Override
		public void mouseMoved(MouseEvent e) {}
		
		public void mouseDragged(MouseEvent e) {}
		
		@Override
		public void mouseClicked (MouseEvent e){}
		
		@Override
		public void mouseReleased (MouseEvent e){}
			
}
