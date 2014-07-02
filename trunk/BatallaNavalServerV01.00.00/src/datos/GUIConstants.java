package datos;

import java.awt.Rectangle;

import datos.imagenes.Paths;

public class GUIConstants {
    	private int TAMAÑO_CASILLA=25;
    	private final int ANCHO_DESTRUCTOR=1;
    	private final int LARGO_DESTRUCTOR=3;
    	private final int ANCHO_ACORAZADO=1;
    	private final int LARGO_ACORAZADO=4;
    	private final int ANCHO_SUBMARINO=1;
    	private final int LARGO_SUBMARINO=1;
    	private final int ANCHO_CRUCERO=1;
    	private final int LARGO_CRUCERO=2;
    	private final int CANTIDAD_DESTRUCTORES=2;
    	private final int CANTIDAD_CRUCEROS=3;
    	private final int CANTIDAD_SUBMARINOS=4;
    	private final int CANTIDAD_ACORAZADOS=1;
    	private final int CANTIDAD_BARCOS = CANTIDAD_DESTRUCTORES+CANTIDAD_CRUCEROS+CANTIDAD_SUBMARINOS+CANTIDAD_ACORAZADOS;
    	private final String ImgDestructorV= Paths.getImgDestructorV();
    	private final String ImgDestructorH= Paths.getImgDestructorH();
    	private final String ImgAcorazadoV= Paths.getImgAcorazadoV();
    	private final String ImgAcorazadoH= Paths.getImgAcorazadoH();
    	private final String ImgSubmarinoV= Paths.getImgSubmarinoV();
    	private final String ImgSubmarinoH= Paths.getImgSubmarinoH();
    	private final String ImgCruceroV= Paths.getImgCruceroV();
    	private final String ImgCruceroH= Paths.getImgCruceroH();
    	private final String ImgFondoURL= Paths.getImgFondo();
    	private final String destructorHashCode= "destructor";
    	private final String cruceroHashCode= "crucero";
    	private final String submarinoHashCode= "submarino";
    	private final String acorazadoHashCode= "acorazado";
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

		public String getImgAcorazadoV() {
			return ImgAcorazadoV;
		}

		public String getImgAcorazadoH() {
			return ImgAcorazadoH;
		}

		public String getImgSubmarinoV() {
			return ImgSubmarinoV;
		}

		public String getImgSubmarinoH() {
			return ImgSubmarinoH;
		}

		public String getImgCruceroV() {
			return ImgCruceroV;
		}

		public String getImgCruceroH() {
			return ImgCruceroH;
		}

		public String getCruceroHashCode() {
			return cruceroHashCode;
		}

		public String getSubmarinoHashCode() {
			return submarinoHashCode;
		}

		public String getAcorazadoHashCode() {
			return acorazadoHashCode;
		}	
		

		public int getANCHO_ACORAZADO() {
			return ANCHO_ACORAZADO;
		}

		public int getLARGO_ACORAZADO() {
			return LARGO_ACORAZADO;
		}

		public int getANCHO_SUBMARINO() {
			return ANCHO_SUBMARINO;
		}

		public int getLARGO_SUBMARINO() {
			return LARGO_SUBMARINO;
		}

		public int getANCHO_CRUCERO() {
			return ANCHO_CRUCERO;
		}

		public int getLARGO_CRUCERO() {
			return LARGO_CRUCERO;
		}
		
		public String getImgV(String hashCode){
			if(hashCode.equals(getAcorazadoHashCode())){
				return getImgAcorazadoV();
			}
			else if(hashCode.equals(getCruceroHashCode())){
				return getImgCruceroV();
			}
			else if(hashCode.equals(getSubmarinoHashCode())){
				return getImgSubmarinoV();
			}
			else if(hashCode.equals(getDestructorHashCode())){
				return getImgDestructorV();
			}
			else return null;
		}
		public String getImgH(String hashCode){
			if(hashCode.equals(getAcorazadoHashCode())){
				return getImgAcorazadoH();
			}
			else if(hashCode.equals(getCruceroHashCode())){
				return getImgCruceroH();
			}
			else if(hashCode.equals(getSubmarinoHashCode())){
				return getImgSubmarinoH();
			}
			else if(hashCode.equals(getDestructorHashCode())){
				return getImgDestructorH();
			}
			else return null;
		}
		
		public int getLargo(String hashCode){
			if(hashCode.equals(getAcorazadoHashCode())){
				return getLARGO_ACORAZADO();
			}
			else if(hashCode.equals(getCruceroHashCode())){
				return getLARGO_CRUCERO();
			}
			else if(hashCode.equals(getSubmarinoHashCode())){
				return getLARGO_SUBMARINO();
			}
			else if(hashCode.equals(getDestructorHashCode())){
				return getLARGO_DESTRUCTOR();
			}
			else return -1;
		}
		public int getAncho(String hashCode){
			if(hashCode.equals(getAcorazadoHashCode())){
				return getANCHO_ACORAZADO();
			}
			else if(hashCode.equals(getCruceroHashCode())){
				return getANCHO_CRUCERO();
			}
			else if(hashCode.equals(getSubmarinoHashCode())){
				return getANCHO_SUBMARINO();
			}
			else if(hashCode.equals(getDestructorHashCode())){
				return getANCHO_DESTRUCTOR();
			}
			else return -1;
		}
   }

