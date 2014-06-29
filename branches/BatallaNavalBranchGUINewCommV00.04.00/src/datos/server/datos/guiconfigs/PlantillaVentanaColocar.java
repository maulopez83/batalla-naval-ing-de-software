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
	private final String ImgTableroColocar= Paths.getImgTableroColocar();
	private ArrayList<ArrayList<Point>> posicionesBarcos;
	public PlantillaVentanaColocar(String ClientID) {	
		super(ClientID);
		constants.setFrameBounds(new Rectangle(0, 0, 600, 400));
		posicionesBarcos= new ArrayList<ArrayList<Point>>();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public MensajeGUI create() {
		MensajeGUI msg= new MensajeGUI();
		msg.setNewWindow(true);
		msg.addElemento(getFondo());
		msg.addElemento(getTableroColocar(100,75));
		
		for (int i=0; i<constants.getCANTIDAD_DESTRUCTORES(); i++){
			msg.addElemento(getDestructor(i));
		}
		msg.addElemento(getBotonJugar());
		msg.setFrameBounds(constants.getFrameBounds());
		return msg;
	}
	
	private ElementoGUI getTableroColocar(int x, int y){
		
		ElementoGUI Tablero = new ElementoGUI(constants.getTableroColocarHashCode());
		try {
			File f= new File(ImgTableroColocar);
			byte[] imagenTablero = Files.readAllBytes(f.toPath());
			Tablero.setIcon(imagenTablero);
			ImageIcon aux= new ImageIcon(imagenTablero);
			Tablero.setBounds(x, y, aux.getIconWidth(), aux.getIconHeight());
			constants.setTableroColocarBounds(Tablero.getBounds());
		} catch (IOException e) {e.printStackTrace();}
		return Tablero;
	}
	private ElementoGUI getDestructor(int i){
		int x= 0;
		int y= i*constants.getTAMAÑO_CASILLA()*constants.getLARGO_DESTRUCTOR();
		ElementoGUI Barco = super.getDestructor(x,y,i);
		try {
		File f= new File(constants.getImgDestructorV());
		byte[] destructorV = Files.readAllBytes(f.toPath());
		File f2= new File(constants.getImgDestructorH());
		byte[] destructorH = Files.readAllBytes(f2.toPath());

		BarcosMouseAdapter BListener= 
						new BarcosMouseAdapter(constants.getTableroColocarBounds(),constants.getTAMAÑO_CASILLA(),constants.getANCHO_DESTRUCTOR(),
												constants.getLARGO_DESTRUCTOR(),posicionesBarcos,destructorV,destructorH);
		Barco.setAdapter(BListener);	
		} catch (IOException e) {
			e.printStackTrace();
		}

		return Barco;
	}
	
	private ElementoGUI getBotonJugar(){
		ElementoGUI BotonJugar = new ElementoGUI(constants.getBotonJugarHashCode());
		BotonJugar.setText("JUGAR");
		BotonJugar.setBounds((int)(constants.getTableroColocarBounds().getX()+constants.getTableroColocarBounds().getWidth()+constants.getTAMAÑO_CASILLA()), 
				(int)(constants.getTableroColocarBounds().getY()+constants.getTableroColocarBounds().getHeight()),50,20);			
		BotonJugarMouseAdapter BJListener=new BotonJugarMouseAdapter(posicionesBarcos,constants.getCANTIDAD_BARCOS());
		BotonJugar.setAdapter(BJListener);
		return BotonJugar;
	}
	

}

