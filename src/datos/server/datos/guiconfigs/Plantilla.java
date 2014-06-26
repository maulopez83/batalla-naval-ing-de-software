package datos.server.datos.guiconfigs;

import javax.swing.ImageIcon;

import negocio.comunicacion.elementosgraficos.ElementoGUI;
import datos.server.datos.Paths;

public class Plantilla {
	private int TAMAÑO_CASILLA=25;
	private final int ANCHO_DESTRUCTOR=1;
	private final int LARGO_DESTRUCTOR=3;
	private final int CANTIDAD_DESTRUCTORES=2;
	private final int CANTIDAD_CRUCEROS=0;
	private final int CANTIDAD_SUBMARINOS=0;
	private final int CANTIDAD_ACORAZADOS=0;
	private final int CANTIDAD_BARCOS = CANTIDAD_DESTRUCTORES+CANTIDAD_CRUCEROS+CANTIDAD_SUBMARINOS+CANTIDAD_ACORAZADOS;
	private final String ImgDestructorV= Paths.getImgDestructorV();
	private final String ImgDestructorH= Paths.getImgDestructorH();
	public Plantilla(){
	}
	public int getTAMAÑO_CASILLA() {
		return TAMAÑO_CASILLA;
	}
	
	public void setTAMAÑO_CASILLA(int tAMAÑO_CASILLA) {
		TAMAÑO_CASILLA = tAMAÑO_CASILLA;
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
	
	
}
