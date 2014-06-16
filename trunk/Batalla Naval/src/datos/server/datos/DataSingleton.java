package datos.server.datos;

import java.util.HashMap;
import java.util.Map;

/*
 * DataSingleton
 * FALTA IMPLEMENTARLA BIEN
 * Contiene todos los datos necesarios por el servidor para administrar el juego
 * Se accede de forma estática a la hora de decodificar mensajes
 */
public class DataSingleton {
	private static DataSingleton ServerData;
	private MapaPartidas Datos;

	private DataSingleton(){
		Datos= new MapaPartidas();
	}
	
	public static DataSingleton getInstance(){
		if (ServerData == null){
			ServerData= new DataSingleton();
		}
		return ServerData;
	}
	
	public DataPartida getDataPartida(String player){
		return Datos.getDataPartida(player);
	}

}
