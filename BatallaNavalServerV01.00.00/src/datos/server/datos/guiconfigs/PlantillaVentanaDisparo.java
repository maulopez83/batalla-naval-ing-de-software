package datos.server.datos.guiconfigs;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.ImageIcon;

import presentacion.cliente.logica.controladores.DisparoMouseAdapter;

import datos.server.datos.Paths;

import negocio.comunicacion.elementosgraficos.ElementoGUI;
import negocio.comunicacion.mensajes.MensajeGUI;

public class PlantillaVentanaDisparo extends Plantilla {

	private final String ImgTableroDisparos= Paths.getImgTableroDisparos();
	public PlantillaVentanaDisparo(String ClientID){
		super(ClientID);
		constants.setFrameBounds(new Rectangle(0, 0, 800, 400));
	}
	public MensajeGUI create() {
		MensajeGUI msg= new MensajeGUI();
		msg.setNewWindow(false);
		msg.addElemento(getTableroDisparo(400,75));
		msg.setFrameBounds(constants.getFrameBounds());
		msg.addElementToRemove(constants.getBotonJugarHashCode());
		
		for (int i=0; i<constants.getCANTIDAD_DESTRUCTORES();i++){
			msg.addAdapterToRemove(constants.getDestructorHashCode()+i);
		}
		for (int i=0; i<constants.getCANTIDAD_SUBMARINOS();i++){
			msg.addAdapterToRemove(constants.getSubmarinoHashCode()+i);
		}
		for (int i=0; i<constants.getCANTIDAD_ACORAZADOS();i++){
			msg.addAdapterToRemove(constants.getAcorazadoHashCode()+i);
		}
		for (int i=0; i<constants.getCANTIDAD_CRUCEROS();i++){
			msg.addAdapterToRemove(constants.getCruceroHashCode()+i);
		}
		return msg;
	}
	
	private ElementoGUI getTableroDisparo(int x, int y){
		ElementoGUI Tablero = new ElementoGUI(constants.getTableroDisparoHashCode());
		try {
			File f= new File(ImgTableroDisparos);
			byte[] imagenTablero = Files.readAllBytes(f.toPath());
			Tablero.setIcon(imagenTablero);
			ImageIcon aux= new ImageIcon(imagenTablero);
			Tablero.setBounds(x, y, aux.getIconWidth(), aux.getIconHeight());
			constants.setTableroDisparoBounds(Tablero.getBounds());
			DisparoMouseAdapter adapterDisparos= new DisparoMouseAdapter(constants.getTAMAÑO_CASILLA());
			Tablero.setAdapter(adapterDisparos);
		} catch (IOException e) {e.printStackTrace();}
		return Tablero;
	}
}
