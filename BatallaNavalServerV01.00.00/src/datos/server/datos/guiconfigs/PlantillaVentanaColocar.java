package datos.server.datos.guiconfigs;

import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import presentacion.cliente.logica.controladores.BarcosMouseAdapter;
import presentacion.cliente.logica.controladores.BotonJugarMouseAdapter;
import datos.server.datos.Paths;

import java.util.ArrayList;

import negocio.comunicacion.elementosgraficos.ElementoGUI;
import negocio.comunicacion.mensajes.MensajeGUI;
import java.io.File;
import java.io.IOException;
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
			msg.addElemento(getBarco(i,constants.getDestructorHashCode()));
		}
		for (int i=0; i<constants.getCANTIDAD_SUBMARINOS(); i++){
			msg.addElemento(getBarco(i,constants.getSubmarinoHashCode()));
		}
		for (int i=0; i<constants.getCANTIDAD_ACORAZADOS(); i++){
			msg.addElemento(getBarco(i,constants.getAcorazadoHashCode()));
		}
		for (int i=0; i<constants.getCANTIDAD_CRUCEROS(); i++){
			msg.addElemento(getBarco(i,constants.getCruceroHashCode()));
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
	private ElementoGUI getBarco(int i,  String barcoHashCode){
		int x= constants.getTAMAÑO_CASILLA()*(constants.getLargo(barcoHashCode)-1);
		int y= i*constants.getTAMAÑO_CASILLA()*constants.getLargo(barcoHashCode);
		ElementoGUI Barco = new ElementoGUI(barcoHashCode+i);
		try {
		File f= new File(constants.getImgV(barcoHashCode));
		byte[] imgBarcoV = Files.readAllBytes(f.toPath());
		File f2= new File(constants.getImgH(barcoHashCode));
		byte[] imgBarcoH = Files.readAllBytes(f2.toPath());
		Barco.setIcon(imgBarcoV);
		addBarcoAdapter(Barco,imgBarcoV,imgBarcoH,barcoHashCode);
		Barco.setBounds(x,y,
				constants.getAncho(barcoHashCode)*constants.getTAMAÑO_CASILLA(), 
				constants.getLargo(barcoHashCode)*constants.getTAMAÑO_CASILLA());
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
	
	private void addBarcoAdapter(ElementoGUI barco, byte[] ImagenV,byte[] ImagenH,String hashCode){
		BarcosMouseAdapter BListener= 
			new BarcosMouseAdapter(constants.getTableroColocarBounds(),constants.getTAMAÑO_CASILLA(),constants.getAncho(hashCode),
									constants.getLargo(hashCode),posicionesBarcos,ImagenV,ImagenH);
		barco.setAdapter(BListener);	
		
	}

}

