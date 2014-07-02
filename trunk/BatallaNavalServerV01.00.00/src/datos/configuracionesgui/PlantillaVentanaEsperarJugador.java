package datos.configuracionesgui;

import java.awt.Rectangle;
import negocio.comunicacion.mensajes.MensajeGUI;
import negocio.comunicacion.mensajes.elementosgraficos.ElementoGUI;

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

