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

	public PlantillaVentanaEsperarJugador(String ClientID) {
		super(ClientID);
		constants.setFrameBounds(new Rectangle(0, 0, 200, 200));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public MensajeGUI create() {
		MensajeGUI msg= new MensajeGUI();
		msg.setNewWindow(true);
		msg.addElemento(getTextoEsperar());
		msg.addElemento(getFondo());
		msg.setFrameBounds(constants.getFrameBounds());
		return msg;
	}
	
	public ElementoGUI getTextoEsperar(){
		ElementoGUI TextoEsperar = new ElementoGUI(constants.getTextoEsperarHashCode());	

		TextoEsperar.setText("Esperando al otro jugador");
		TextoEsperar.setBounds(constants.getFrameBounds().width/2-75, constants.getFrameBounds().height/2-10, 150, 20);
		return TextoEsperar;
	}
	
	
}

