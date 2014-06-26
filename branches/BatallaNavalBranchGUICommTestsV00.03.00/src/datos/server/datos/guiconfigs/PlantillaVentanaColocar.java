package datos.server.datos.guiconfigs;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import presentacion.cliente.logica.controladores.BarcosMouseAdapter;
import presentacion.cliente.logica.controladores.BotonJugarMouseAdapter;

import datos.server.datos.Paths;

import java.util.ArrayList;

import negocio.comunicacion.elementosgraficos.DestructorGUI;
import negocio.comunicacion.elementosgraficos.ElementoGUI;
import negocio.comunicacion.mensajes.Mensaje;
import negocio.comunicacion.mensajes.MensajeGUI;
import negocio.comunicacion.mensajes.MensajeDisparo;
import negocio.comunicacion.mensajes.MensajeFrame;
import negocio.server.logica.comunicacion.DelayThread;
import java.awt.Toolkit;

public class PlantillaVentanaColocar extends Plantilla {
	private final String ImgFondoURL= Paths.getFondoColocarBarcos();
	private MensajeGUI msg;
	private ArrayList<ArrayList<Point>> posicionesBarcos;
	private Rectangle tablBounds;
	private Rectangle frameBounds;
	public PlantillaVentanaColocar() {
		msg= new MensajeGUI();
		tablBounds= new Rectangle(3*getTAMAÑO_CASILLA(),getTAMAÑO_CASILLA(), 10*getTAMAÑO_CASILLA(), 10*getTAMAÑO_CASILLA());
		frameBounds= new Rectangle(0, 0, 402, 328);
		posicionesBarcos= new ArrayList<ArrayList<Point>>();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public MensajeGUI create() {
		ElementoGUI Fondo = new ElementoGUI();
		ElementoGUI BotonJugar = new ElementoGUI();
		
		
		Fondo.setIcon(new ImageIcon(ImgFondoURL));
		Fondo.setBounds(0, 0, 400, 300);
		msg.addElemento(Fondo);
		
		BotonJugar.setText("JUGAR");
		BotonJugar.setBounds((int)(tablBounds.getX()+tablBounds.getWidth()+getTAMAÑO_CASILLA()), (int)(tablBounds.getY()+tablBounds.getHeight()),50,20);			
		BotonJugarMouseAdapter BJListener=new BotonJugarMouseAdapter(posicionesBarcos,getCANTIDAD_BARCOS());
		BotonJugar.setAdapter(BJListener);
		

		
		msg.addElemento(Fondo);
		msg.addElemento(getDestructor(0,0));
		msg.addElemento(getDestructor(0,75));
		msg.addElemento(BotonJugar);
		msg.setFrameBounds(frameBounds);
		return msg;
	}
	
	private ElementoGUI getDestructor(int x,int y){
		ElementoGUI Barco = new ElementoGUI();
		ImageIcon destructorV= new ImageIcon(getImgDestructorV());
		ImageIcon destructorH= new ImageIcon(getImgDestructorH());	
		BarcosMouseAdapter BListener= new BarcosMouseAdapter(tablBounds,getTAMAÑO_CASILLA(),getANCHO_DESTRUCTOR(),getLARGO_DESTRUCTOR(),posicionesBarcos,destructorV,destructorH);
		
		Barco.setBounds(x,y,getANCHO_DESTRUCTOR()*getTAMAÑO_CASILLA(), getLARGO_DESTRUCTOR()*getTAMAÑO_CASILLA());
		Barco.setIcon(destructorV);
		Barco.setAdapter(BListener);
		
		return Barco;
	}
	
}

