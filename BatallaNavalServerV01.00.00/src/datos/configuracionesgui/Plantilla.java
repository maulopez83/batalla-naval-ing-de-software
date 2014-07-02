package datos.configuracionesgui;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.ImageIcon;

import negocio.comunicacion.mensajes.elementosgraficos.ElementoGUI;
import datos.BaseDatosSingleton;
import datos.GUIConstants;

public class Plantilla {
	
	protected GUIConstants constants;
	public Plantilla(String ClientID){
		this.constants=BaseDatosSingleton.getInstance().getGUIConstants(ClientID);
	}
	
	protected ElementoGUI getFondo(){
		ElementoGUI Fondo = new ElementoGUI(constants.getFondoHashCode());
		try {
			File f= new File(constants.getImgFondoURL());
			byte[] imagenFondo = Files.readAllBytes(f.toPath());
			Fondo.setIcon(imagenFondo);
			ImageIcon aux= new ImageIcon(imagenFondo);
			Fondo.setBounds(0, 0, aux.getIconWidth(), aux.getIconHeight());
		} catch (IOException e) {
			e.printStackTrace();
		}


		return Fondo;
	}

	
}
