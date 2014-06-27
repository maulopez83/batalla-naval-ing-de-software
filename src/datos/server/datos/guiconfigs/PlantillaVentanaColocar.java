package datos.server.datos.guiconfigs;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import presentacion.cliente.logica.controladores.BarcosMouseAdapter;
import presentacion.cliente.logica.controladores.BotonJugarMouseAdapter;
import presentacion.cliente.visual.Ventana;

import datos.server.datos.Paths;

import java.util.ArrayList;

import negocio.comunicacion.elementosgraficos.ElementoGUI;
import negocio.comunicacion.mensajes.Mensaje;
import negocio.comunicacion.mensajes.MensajeGUI;
import negocio.comunicacion.mensajes.MensajeDisparo;

import negocio.server.logica.comunicacion2.DelayThread;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;

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
		
		msg.addElemento(getFondo());
		
		for (int i=0; i<getCANTIDAD_DESTRUCTORES(); i++){
			msg.addElemento(getDestructor(i));
		}
		msg.addElemento(getBotonJugar());
		msg.setFrameBounds(frameBounds);
		return msg;
	}
	
	
	protected ElementoGUI getDestructor(int i){
		int x= 0;
		int y= i*getTAMAÑO_CASILLA()*getLARGO_DESTRUCTOR();
		ElementoGUI Barco = super.getDestructor(x,y);
		try {
		File f= new File(getImgDestructorV());
		byte[] destructorV = Files.readAllBytes(f.toPath());
		File f2= new File(getImgDestructorH());
		byte[] destructorH = Files.readAllBytes(f2.toPath());

		BarcosMouseAdapter BListener= 
						new BarcosMouseAdapter(tablBounds,getTAMAÑO_CASILLA(),getANCHO_DESTRUCTOR(),
											getLARGO_DESTRUCTOR(),posicionesBarcos,destructorV,destructorH);
		Barco.setAdapter(BListener);	
		} catch (IOException e) {
			e.printStackTrace();
		}

		return Barco;
	}
	
	private ElementoGUI getBotonJugar(){
		ElementoGUI BotonJugar = new ElementoGUI();
		BotonJugar.setText("JUGAR");
		BotonJugar.setBounds((int)(tablBounds.getX()+tablBounds.getWidth()+getTAMAÑO_CASILLA()), (int)(tablBounds.getY()+tablBounds.getHeight()),50,20);			
		BotonJugarMouseAdapter BJListener=new BotonJugarMouseAdapter(posicionesBarcos,getCANTIDAD_BARCOS());
		BotonJugar.setAdapter(BJListener);
		return BotonJugar;
	}
	
	private ElementoGUI getFondo(){
		ElementoGUI Fondo = new ElementoGUI();
		BufferedImage image;
		try {
			File f= new File(ImgFondoURL);
			byte[] imagenFondo = Files.readAllBytes(f.toPath());
			Fondo.setIcon(imagenFondo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		Fondo.setBounds(0, 0, 400, 300);
		return Fondo;
	}
	
}

