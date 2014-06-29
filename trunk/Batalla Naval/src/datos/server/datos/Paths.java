package datos.server.datos;

public class Paths {
	private static Paths path;
	private final String ImgDestructorV = "src/datos/server/datos/imagenes/ImgDestructorV.png";
	private final String ImgDestructorH = "src/datos/server/datos/imagenes/ImgDestructorH.png";
	private final String ImgTableroColocar = "src/datos/server/datos/imagenes/ImgTableroColocar.png";
	private final String ImgTableroDisparos = "src/datos/server/datos/imagenes/ImgTableroDisparos.png";
	private final String ImgFondo = "src/datos/server/datos/imagenes/ImgFondo2.png";
	private final String ImgAveriado = "src/datos/server/datos/imagenes/ImgAveriado.png";
	private final String ImgAgua = "src/datos/server/datos/imagenes/ImgAgua.png";
	private final String ImgWinner = "src/datos/server/datos/imagenes/ImgWinner.png";
	private final String ImgLoser = "src/datos/server/datos/imagenes/ImgLoser.png";
	private final String BarcosMouseAdapter = "src/pesentacion/cliente/logica/controladores/BarcosMouseAdapter";
	private final String BotonJugarMouseAdapter = "src/pesentacion/cliente/logica/controladores/BotonJugarMouseAdapter";

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
	public static String getImgTableroColocar() {
		return getInstance().ImgTableroColocar;
	}
	public static String getImgTableroDisparos() {
		return getInstance().ImgTableroDisparos;
	}
	public static String getImgFondo() {
		return getInstance().ImgFondo;
	}
	public static String getImgAveriado() {
		return getInstance().ImgAveriado;
	}
	public static String getImgAgua() {
		return getInstance().ImgAgua;
	}
	public static String getImgWinner() {
		return getInstance().ImgWinner;
	}
	public static String getImgLoser() {
		return getInstance().ImgLoser;
	}
	
}
