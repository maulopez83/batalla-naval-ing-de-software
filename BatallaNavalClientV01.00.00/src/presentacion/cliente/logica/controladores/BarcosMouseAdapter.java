package presentacion.cliente.logica.controladores;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import presentacion.cliente.visual.Ventana;

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
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseMoved(e);
				JLabel source=(JLabel) e.getSource();
				initialX= (int)(source.getLocation().getX());
				initialY= (int)(source.getLocation().getY());
		}
		
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseDragged(e);
			JLabel source=(JLabel) e.getSource();
			int X= (int)(source.getLocation().getX()-source.getWidth()/2+e.getX());
			int Y= (int)(source.getLocation().getY()-source.getHeight()/2+e.getY());
			source.setLocation(X,Y);
			
		}
		@Override
		public void mouseClicked (MouseEvent e){
			int CLICKDERECHO=3;
			if (e.getButton()==CLICKDERECHO){
					tabOcup.remove(posBarco);
				
				int casillaX;
				int casillaY;
				if(!posBarco.isEmpty()){
					casillaX=(int)posBarco.get(0).getX();
					casillaY=(int)posBarco.get(0).getY();
				}
				else{
					casillaX=(int)initialX/tamCasilla;
					casillaY=(int)initialY/tamCasilla;
				}
				if (posicionPosible(casillaX,casillaY,casillasAlto,casillasAncho)){
					JLabel source=(JLabel) e.getSource();
					orientacion=!orientacion;
					if(orientacion){
						source.setIcon(new ImageIcon(Vert));
					}
					else{
						source.setIcon(new ImageIcon(Horiz));
						
					}
					int auxSwap= casillasAlto;
					casillasAlto= casillasAncho;
					casillasAncho= auxSwap;
					source.setSize(casillasAncho*tamCasilla, casillasAlto*tamCasilla);
					
					if(!posBarco.isEmpty()){
						posBarco.clear();
						for (int i=0; i<casillasAncho ; i++){
							for(int k=0; k<casillasAlto; k++){
								posBarco.add(new Point(casillaX+i,casillaY+k));
							}
						}
					}
				}
				
					tabOcup.add(posBarco);
			}
		}
		
		@Override
		public void mouseReleased (MouseEvent e){
			JLabel source=(JLabel) e.getSource();
			int X= (int)(source.getLocation().getX())+source.getWidth()/4;
			int Y= (int)(source.getLocation().getY())+source.getHeight()/4;
			int Xs= (int)(source.getLocation().getX())+source.getWidth()*7/8;
			int Ys= (int)(source.getLocation().getY())+source.getHeight()*7/8;
			int TX=(int)(tablero.getX());
			int TY=(int)(tablero.getY());
			int TXs=(int)(tablero.getX()+tablero.getWidth());
			int TYs=(int)(tablero.getY()+tablero.getHeight());
			
			if(X>TX && Y>TY && Xs<TXs && Ys <TYs){

					tabOcup.remove(posBarco);
									
				double aux=(source.getLocation().getX()-TX)/tamCasilla;
				if ((aux%1)> 0.5){ aux++;}
				int casillaX=(int)aux;
				X=casillaX*tamCasilla;
				aux=(source.getLocation().getY()-TY)/tamCasilla;
				if ((aux%1)> 0.5){ aux++;}
				int casillaY=(int)aux;
				Y=casillaY*tamCasilla;
					
					
					if(posicionPosible(casillaX, casillaY,casillasAncho, casillasAlto)){
						posBarco.clear();
						for (int i=0; i<casillasAncho ; i++){
							for(int k=0; k<casillasAlto; k++){
								posBarco.add(new Point(casillaX+i,casillaY+k));
							}
						}
					source.setLocation(X+TX, Y+TY);
					}
					else {
						source.setLocation(initialX, initialY);
					}

						tabOcup.add(posBarco);
			}
			else{
				source.setLocation(initialX, initialY);
			}
							  
		}
		
		public boolean posicionPosible(int X, int Y,int Ancho,int Alto){
			boolean posiblePos=true;		
			for (int i=0; i<Ancho ; i++){
				for(int k=0; k<Alto; k++){
					if ((X+i>(tablero.width/tamCasilla)-1)||(Y+k>(tablero.height/tamCasilla)-1)){
						posiblePos=false;
						return posiblePos;
					}
					for(ArrayList<Point> l: tabOcup){
						for(Point p: l){
							if(p.x == X+i && p.y == Y+k){
								posiblePos=false;
								return posiblePos;
							}

						}
					}
					
				}
			}
			return posiblePos;
		}		
}
