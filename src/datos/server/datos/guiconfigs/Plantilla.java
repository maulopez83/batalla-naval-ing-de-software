package datos.server.datos.guiconfigs;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import negocio.comunicacion.elementosgraficos.ElementoGUI;
import datos.server.datos.Paths;

public class Plantilla {
	private int TAMA�O_CASILLA=25;
	private final int ANCHO_DESTRUCTOR=1;
	private final int LARGO_DESTRUCTOR=3;
	private final int CANTIDAD_DESTRUCTORES=3;
	private final int CANTIDAD_CRUCEROS=0;
	private final int CANTIDAD_SUBMARINOS=0;
	private final int CANTIDAD_ACORAZADOS=0;
	private final int CANTIDAD_BARCOS = CANTIDAD_DESTRUCTORES+CANTIDAD_CRUCEROS+CANTIDAD_SUBMARINOS+CANTIDAD_ACORAZADOS;
	private final String ImgDestructorV= Paths.getImgDestructorV();
	private final String ImgDestructorH= Paths.getImgDestructorH();
	public Plantilla(){
	}
	public int getTAMA�O_CASILLA() {
		return TAMA�O_CASILLA;
	}
	
	public void setTAMA�O_CASILLA(int tAMA�O_CASILLA) {
		TAMA�O_CASILLA = tAMA�O_CASILLA;
	}
	public int getANCHO_DESTRUCTOR() {
		return ANCHO_DESTRUCTOR;
	}
	public int getLARGO_DESTRUCTOR() {
		return LARGO_DESTRUCTOR;
	}
	public int getCANTIDAD_DESTRUCTORES() {
		return CANTIDAD_DESTRUCTORES;
	}
	public int getCANTIDAD_CRUCEROS() {
		return CANTIDAD_CRUCEROS;
	}
	public int getCANTIDAD_SUBMARINOS() {
		return CANTIDAD_SUBMARINOS;
	}
	public int getCANTIDAD_ACORAZADOS() {
		return CANTIDAD_ACORAZADOS;
	}
	public String getImgDestructorV() {
		return ImgDestructorV;
	}
	public String getImgDestructorH() {
		return ImgDestructorH;
	}
	public int getCANTIDAD_BARCOS() {
		return CANTIDAD_BARCOS;
	}
	
	protected ElementoGUI getDestructor(int x,int y){
		ElementoGUI Barco = new ElementoGUI();
		try {
			File f= new File(getImgDestructorV());
			byte[] destructorV = Files.readAllBytes(f.toPath());
			Barco.setIcon(destructorV);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Barco.setBounds(x,y,getANCHO_DESTRUCTOR()*getTAMA�O_CASILLA(), getLARGO_DESTRUCTOR()*getTAMA�O_CASILLA());

		return Barco;
	}
	
	
}
