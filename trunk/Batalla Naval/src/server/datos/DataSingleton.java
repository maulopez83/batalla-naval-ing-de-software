package server.datos;

/*
 * DataSingleton
 * FALTA IMPLEMENTARLA BIEN
 * Contiene todos los datos necesarios por el servidor para administrar el juego
 * Se accede de forma estática a la hora de decodificar mensajes
 */
public class DataSingleton {
	private static DataSingleton GameData;
	
	private int Dato;
	private DataSingleton(){
		Dato=0;
	}
	
	public static DataSingleton getInstance(){
		if (GameData == null){
			GameData= new DataSingleton();
		}
		return GameData;
	}
	
	public int getDato(){
		return getInstance().Dato;
	}
	public void setDato(int d){
		getInstance().Dato=d;
	}

}
