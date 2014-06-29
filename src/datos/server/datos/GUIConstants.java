package datos.server.datos;

import java.awt.Rectangle;

public class GUIConstants {
    	private int TAMAÑO_CASILLA=25;
    	private final int ANCHO_DESTRUCTOR=1;
    	private final int LARGO_DESTRUCTOR=3;
    	private final int CANTIDAD_DESTRUCTORES=3;
    	private final int CANTIDAD_CRUCEROS=0;
    	private final int CANTIDAD_SUBMARINOS=0;
    	private final int CANTIDAD_ACORAZADOS=0;
    	private final int CANTIDAD_BARCOS = CANTIDAD_DESTRUCTORES+CANTIDAD_CRUCEROS+CANTIDAD_SUBMARINOS+CANTIDAD_ACORAZADOS;
    	private final String ImgDestructorV= Paths.getImgDestructorV();
    	private final String ImgDestructorH= Paths.getImgDestructorH();
    	private final String ImgFondoURL= Paths.getImgFondo();
    	private final String destructorHashCode= "destructor";
    	private final String fondoHashCode= "fondo";
    	private final String botonJugarHashCode= "botonjugar";
    	private final String tableroColocarHashCode= "tablerocolocar";
    	private final String tableroDisparoHashCode= "tablerodisparo";
    	private final String textoEsperarHashCode= "textoesperar";	
    	private Rectangle frameBounds;
    	private Rectangle tableroColocarBounds;
    	private Rectangle tableroDisparoBounds;
    	
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

		public String getImgFondoURL() {
			return ImgFondoURL;
		}

		public String getDestructorHashCode() {
			return destructorHashCode;
		}

		public String getFondoHashCode() {
			return fondoHashCode;
		}

		public String getBotonJugarHashCode() {
			return botonJugarHashCode;
		}

		public String getTableroColocarHashCode() {
			return tableroColocarHashCode;
		}

		public String getTableroDisparoHashCode() {
			return tableroDisparoHashCode;
		}

		public void setFrameBounds(Rectangle frameBounds) {
			this.frameBounds = frameBounds;
		}

		public Rectangle getFrameBounds() {
			return frameBounds;
		}

		public void setTableroColocarBounds(Rectangle tableroColocarBounds) {
			this.tableroColocarBounds = tableroColocarBounds;
		}

		public Rectangle getTableroColocarBounds() {
			return tableroColocarBounds;
		}

		public void setTableroDisparoBounds(Rectangle tableroDisparoBounds) {
			this.tableroDisparoBounds = tableroDisparoBounds;
		}

		public Rectangle getTableroDisparoBounds() {
			return tableroDisparoBounds;
		}

		public String getTextoEsperarHashCode() {
			return textoEsperarHashCode;
		}	
   }

