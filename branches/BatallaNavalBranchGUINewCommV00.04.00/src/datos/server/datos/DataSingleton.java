package datos.server.datos;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
 * DataSingleton
 * FALTA IMPLEMENTARLA BIEN
 * Contiene todos los datos necesarios por el servidor para administrar el juego
 * Se accede de forma est�tica a la hora de decodificar mensajes
 */
public class DataSingleton {
	private static DataSingleton ServerData;
	private final MapaPartidas Datos;
	private final String CurrentVersion = "V1.0";
	private final Queue<String> WaitingClients;
	private final SocketMap socketMap;
	private DataSingleton(){
		Datos= new MapaPartidas();
		this.WaitingClients= new LinkedList<String>();
		socketMap= new SocketMap();
	}
	
	public static DataSingleton getInstance(){
		if (ServerData == null){
			ServerData= new DataSingleton();
		}
		return ServerData;
	}
	
	private DataPartida getDataPartida(String player){
		return Datos.getDataPartida(player);
	}

	public String getCurrentVersion() {
		return CurrentVersion;
	}
	
	public TableroBarcos getTableroBarcos(String PlayerID){
		return getDataPartida(PlayerID).getTableroBarcos(PlayerID);
	}
	public TableroBarcos getTableroBarcosOponente(String PlayerID){
		return getDataPartida(PlayerID).getTableroBarcosOponente(PlayerID);
	}
	public TableroMarcado getTableroJuego(String PlayerID){
		return getDataPartida(PlayerID).getTableroJuego(PlayerID);
	}
	public void setBarcosEnTablero(String PlayerID , ArrayList<ArrayList<Point>> posBarcos){
		getDataPartida(PlayerID).getTableroBarcos(PlayerID).setBarcosTablero(posBarcos);
	}
	
	public void setDisparo(String PlayerID,Point disparo){
		getTableroJuego(PlayerID).setDisparo(disparo, getTableroBarcosOponente(PlayerID));
	}
	public String getOponentID(String PlayerID){
		return getDataPartida(PlayerID).getOponentID(PlayerID);
	}
	public boolean addClient(String ClientID){
		//Prueba un solo cliente:
		//Datos.setDataPartida(ClientID, ClientID);
		
		WaitingClients.add(ClientID);
		System.out.println("Se agrego: " + ClientID + ". Ahora espera.");
		if(WaitingClients.size()%2==0){
			while(!WaitingClients.isEmpty()){
				Datos.setDataPartida(WaitingClients.poll(), WaitingClients.poll());
				System.out.println("Cree nuevos datos de partida");
			}
			return true;
		}
		else{return false;}
		
	}

	public SocketMap getSocketMap() {
		return socketMap;
	}
	
}
