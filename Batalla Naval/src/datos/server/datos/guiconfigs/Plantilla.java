package datos.server.datos.guiconfigs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.ImageIcon;

import negocio.comunicacion.elementosgraficos.ElementoGUI;
import datos.server.datos.BaseDatosSingleton;
import datos.server.datos.GUIConstants;

public class Plantilla {
	
	protected GUIConstants constants;
	public Plantilla(String ClientID){
		this.constants=BaseDatosSingleton.getInstance().getGUIConstants(ClientID);
	}
	protected ElementoGUI getDestructor(int x,int y,int i){
		ElementoGUI Barco = new ElementoGUI(constants.getDestructorHashCode()+i);
		try {
			File f= new File(constants.getImgDestructorV());
			byte[] destructorV = Files.readAllBytes(f.toPath());
			Barco.setIcon(destructorV);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Barco.setBounds(x,y,constants.getANCHO_DESTRUCTOR()*constants.getTAMA�O_CASILLA(), constants.getLARGO_DESTRUCTOR()*constants.getTAMA�O_CASILLA());

		return Barco;
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
