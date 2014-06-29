package datos.server.datos;

import java.awt.Point;
import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Semaphore;

import negocio.comunicacion.mensajes.Mensaje;

import datos.server.datos.TableroMarcado.DISPARO;

/*
 * DataSingleton
 * FALTA IMPLEMENTARLA BIEN
 * Contiene todos los datos necesarios por el servidor para administrar el juego
 * Se accede de forma estática a la hora de decodificar mensajes
 */
public class DataSingleton {
	private static DataSingleton ServerData= new DataSingleton();
	private final MapaPartidas Datos;
	private final String CurrentVersion = "V1.0";
	private final Queue<String> WaitingClients;
	private final SocketMap socketMap;
	private Semaphore mutex;
	private DataSingleton(){
		Datos= new MapaPartidas();
		this.WaitingClients= new LinkedList<String>();
		socketMap= new SocketMap();
		mutex= new Semaphore(1);
	}
	
	public static DataSingleton getInstance(){
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
	
	public DISPARO setDisparo(String PlayerID,Point disparo){
		DISPARO result=null;
		try{
			result= getTableroJuego(PlayerID).setDisparo(disparo, getTableroBarcosOponente(PlayerID));
		} catch(InvalidAlgorithmParameterException e){System.out.println(e.getMessage());};
		return result;
	}
	public String getOponentID(String PlayerID){
		return getDataPartida(PlayerID).getOponentID(PlayerID);
	}
	public boolean addClient(String ClientID){
		boolean result= false;
		try{
		mutex.acquire();
		try{
			WaitingClients.add(ClientID);
			System.out.println("Se agrego: " + ClientID + ". Ahora espera.");
			if(WaitingClients.size()%2==0){
				while(!WaitingClients.isEmpty()){
					Datos.setDataPartida(WaitingClients.poll(), WaitingClients.poll());
					System.out.println("Cree nuevos datos de partida");
					result=true;
				}
			}
		}	finally{mutex.release();}
		}	catch(Exception e){e.printStackTrace();};
		return result;

		
	}

	public SocketMap getSocketMap() {
		return socketMap;
	}
	
	public void sendMsgToPlayer(String ClientID, Mensaje msg){
		getSocketMap().getSocket(ClientID).addOutPutMsg(msg);
	}
	public void sendMsgToOponent(String ClientID, Mensaje msg){
		sendMsgToPlayer(getOponentID(ClientID),msg);
	}
	public GUIConstants getGUIConstants(String ClientID){
		if(getDataPartida(ClientID)!=null){
			return getDataPartida(ClientID).getGuiConstants();
		}
		else return new GUIConstants();
	}
	public boolean arePlayersReady(String ClientID){
		return (getDataPartida(ClientID).isPlayer1Ready() && getDataPartida(ClientID).isPlayer2Ready());
	}
	public void setPlayerReady(String ClientID){
		getDataPartida(ClientID).setPlayerReady(ClientID);
	}
	
}
