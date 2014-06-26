package datos.server.datos;

import java.util.LinkedList;

public class Paths {
	private static Paths path;
	private final String ImgDestructorV = "src/datos/server/datos/imagenes/ImgDestructorV.png";
	private final String ImgDestructorH = "src/datos/server/datos/imagenes/ImgDestructorH.png";
	private final String BarcosMouseAdapter = "src/pesentacion/cliente/logica/controladores/BarcosMouseAdapter";
	private final String BotonJugarMouseAdapter = "src/pesentacion/cliente/logica/controladores/BotonJugarMouseAdapter";
	private final String FondoColocarBarcos = "src/datos/server/datos/imagenes/TableroChico.png";
	private Paths(){
	}
	private static Paths getInstance(){
		if (path == null){
			path= new Paths();
		}
		return path;
	}
	
	public static String getImgDestructorV() {
		return getInstance().ImgDestructorV;
	}
	public static String getImgDestructorH() {
		return getInstance().ImgDestructorH;
	}
	public static String getBarcosMouseAdapter() {
		return getInstance().BarcosMouseAdapter;
	}
	public static String getBotonJugarMouseAdapter() {
		return getInstance().BotonJugarMouseAdapter;
	}	
	public static String getFondoColocarBarcos() {
		return getInstance().FondoColocarBarcos;
	}
	
}
