package ing.de.software.batallanaval.datos;


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
