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

import negocio.comunicacion.elementosgraficos.ElementoGUI;
import negocio.comunicacion.mensajes.Mensaje;
import negocio.comunicacion.mensajes.MensajeGUI;
import negocio.comunicacion.mensajes.MensajeDisparo;

import negocio.server.logica.comunicacion.DelayThread;
import java.awt.Toolkit;

public class PlantillaVentanaEsperarJugador extends Plantilla {
	private MensajeGUI msg;
	private Rectangle frameBounds;
	public PlantillaVentanaEsperarJugador() {
		msg= new MensajeGUI();
		frameBounds= new Rectangle(0, 0, 402, 328);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public MensajeGUI create() {
		msg.addElemento(getTextoEsperar());
		msg.setFrameBounds(frameBounds);
		return msg;
	}
	
	public ElementoGUI getTextoEsperar(){
		ElementoGUI TextoEsperar = new ElementoGUI();	
		TextoEsperar.setBounds(frameBounds.width/2, frameBounds.height/2, 200, 50);
		TextoEsperar.setText("Esperando al otro jugador");
		return TextoEsperar;
	}
	
	
}

