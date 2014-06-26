package presentacion.cliente.visual;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.ArrayList;

import negocio.server.logica.comunicacion.DelayThread;
import negocio.server.logica.comunicacion.mensajes.Mensaje;
import negocio.server.logica.comunicacion.mensajes.MensajeDisparo;
import java.awt.Toolkit;

public class pruebaColocar {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pruebaColocar window = new pruebaColocar();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public pruebaColocar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		class BarcosMouseAdapter extends MouseAdapter{
			
			private JLabel tablero;
			private int initialX;
			private int initialY;
			private int tamCasilla;
			private int casillasAncho;
			private int casillasAlto;
			ArrayList<ArrayList<Point> >tabOcup;
			ArrayList<Point> posBarco;
			private boolean orientacion;
			private ImageIcon Vert;
			private ImageIcon Horiz;
			public BarcosMouseAdapter(JLabel tablero, int tamCasilla,int casillasAncho,
							int casillasAlto, ArrayList<ArrayList<Point>> tabOcupado, ImageIcon Vert,ImageIcon Horiz){
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
						casillaX=(int)initialX/25;
						casillaY=(int)initialY/25;
					}
					if (posicionPosible(casillaX,casillaY,casillasAlto,casillasAncho)){
						JLabel source=(JLabel) e.getSource();
						orientacion=!orientacion;
						if(orientacion){
							source.setIcon(Vert);
						}
						else{
							source.setIcon(Horiz);
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
				int TX=(int)(tablero.getLocation().getX());
				int TY=(int)(tablero.getLocation().getY());
				int TXs=(int)(tablero.getLocation().getX())+tablero.getWidth();
				int TYs=(int)(tablero.getLocation().getY())+tablero.getHeight();
				
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
						for(ArrayList<Point> l: tabOcup){
							for(Point p: l){
								if((int)p.getX() == X+i && (int)p.getY() == Y+k){
									posiblePos=false;
								}
							}
						}
					}
				}
				return posiblePos;
			}
			
		}
		
		class BotonJugarMouseAdapter extends MouseAdapter{
			ArrayList<ArrayList<Point>> tablero;
			int cantBarcos;
			public BotonJugarMouseAdapter(ArrayList<ArrayList<Point>> tablero, int cantBarcos){
				this.tablero=tablero;
				this.cantBarcos=cantBarcos;
			}
			@Override
			public void mouseClicked (MouseEvent e){
				if(tablero.size()==cantBarcos){
					for (ArrayList<Point> l : tablero){
						for(Point p: l){
						System.out.println("Posicion : (" + (int)p.getX()+ ", " + (int)p.getY()+ ")" );
						}						
					}
					frame.dispose();
				}
				else{
					new Thread(new Runnable(){
						public void run(){
						 JLabel Error = new JLabel();
						 Error.setBounds(0,0,300,20);
						 Error.setText("Error, no se ingresaron todos los barcos");
						 Error.setForeground(Color.RED);
						 frame.getContentPane().add(Error,0);
						 frame.repaint();
						 DelayThread.delay(2000);
						 Error.setVisible(false);
						 frame.getContentPane().remove(Error);
					 }
					}).start();
				}
			}
		}
		
		
			
		
		ImageIcon destructorV= new ImageIcon("src/datos/server/datos/imagenes/barquitoVertical.png");
		ImageIcon destructorH= new ImageIcon("src/datos/server/datos/imagenes/barquito.png");	
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(0, 0, 402, 328);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		
		final int ANCHO_DESTRUCTOR=1;
		final int ALTO_DESTRUCTOR=3;
		final int TAMAÑO_CASILLA=25;
		final int CANT_DESTRUCTORES=2;
		ArrayList<ArrayList<Point>> posicionesBarcos= new ArrayList<ArrayList<Point>>();
		
		int CANTIDAD_BARCOS= CANT_DESTRUCTORES;
		
		
		JLabel Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon(pruebaColocar.class.getResource("/datos/server/datos/imagenes/TableroChico.png")));
		Fondo.setBounds(0, 0, 400, 300);
		frame.getContentPane().add(Fondo);
		
		
		final JLabel Tablero1 = new JLabel("");
		Tablero1.setBounds(75, 25, 250, 250);

		JLabel Barco1 = new JLabel("");
		Barco1.setIcon(destructorV);
		Barco1.setBounds(0, 0, ANCHO_DESTRUCTOR*TAMAÑO_CASILLA, ALTO_DESTRUCTOR*TAMAÑO_CASILLA);
		
		JLabel Barco2 = new JLabel("");
		Barco2.setIcon(destructorV);
		Barco2.setBounds(0, 75, ANCHO_DESTRUCTOR*TAMAÑO_CASILLA, ALTO_DESTRUCTOR*TAMAÑO_CASILLA);

		
		JLabel BotonJugar = new JLabel("");
		BotonJugar.setForeground(Color.RED);
		BotonJugar.setText("JUGAR");
		BotonJugar.setBounds(Tablero1.getX()+Tablero1.getWidth()+TAMAÑO_CASILLA, Tablero1.getY()+Tablero1.getHeight(),50,20);
		
		
		frame.getContentPane().add(Tablero1,0);
		frame.getContentPane().add(Barco1,0);
		frame.getContentPane().add(Barco2,0);
		frame.getContentPane().add(BotonJugar,0);
		

		BarcosMouseAdapter B1Listener= new BarcosMouseAdapter(Tablero1,TAMAÑO_CASILLA,ANCHO_DESTRUCTOR,ALTO_DESTRUCTOR,posicionesBarcos,destructorV,destructorH);
		BarcosMouseAdapter B2Listener= new BarcosMouseAdapter(Tablero1,TAMAÑO_CASILLA,ANCHO_DESTRUCTOR,ALTO_DESTRUCTOR,posicionesBarcos,destructorV,destructorH);
		Barco1.addMouseMotionListener(B1Listener);		
		Barco1.addMouseListener(B1Listener);
		Barco2.addMouseMotionListener(B2Listener);		
		Barco2.addMouseListener(B2Listener);

		BotonJugarMouseAdapter BJListener=new BotonJugarMouseAdapter(posicionesBarcos,CANTIDAD_BARCOS);
		BotonJugar.addMouseListener(BJListener);
		
		
	}

}

