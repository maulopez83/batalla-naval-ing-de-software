package datos;

import java.awt.Point;
import java.net.Socket;
import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Semaphore;

import negocio.comunicacion.SocketThread;
import negocio.comunicacion.mensajes.Mensaje;

import datos.configuracionesgui.GUIConstants;
import datos.partida.DataPartida;
import datos.partida.TableroBarcos;
import datos.partida.TableroMarcado;
import datos.partida.TableroMarcado.DISPARO;

/*
 * DataSingleton
 * FALTA IMPLEMENTARLA BIEN
 * Contiene todos los datos necesarios por el servidor para administrar el juego
 * Se accede de forma estática a la hora de decodificar mensajes
 */
public class BaseDatosSingleton {
	private static BaseDatosSingleton ServerData= new BaseDatosSingleton();
	private final MapaPartidas Datos;
	private final String CurrentVersion = "V1.0";
	private final Queue<String> WaitingClients;
	private final SocketMap socketMap;
	private Semaphore mutex;
	private BaseDatosSingleton(){
		Datos= new MapaPartidas();
		this.WaitingClients= new LinkedList<String>();
		socketMap= new SocketMap();
		mutex= new Semaphore(1);
	}
	
	public static BaseDatosSingleton getInstance(){
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

	public SocketThread getSocket(int hashCode) {
		return socketMap.getSocket(Integer.toString(hashCode));
	}
	public SocketThread getSocket(String hashCode) {
		return socketMap.getSocket(hashCode);
	}
	public void sendMsgToPlayer(String ClientID, Mensaje msg){
		socketMap.getSocket(ClientID).addOutPutMsg(msg);
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
	public boolean isGameFinished(String ClientID){
		return getDataPartida(ClientID).isGameFinished();
	}
	public void deleteClient(String ClientID){
		Datos.remove(ClientID);
		socketMap.removeSocket(ClientID);
	}
	public void addSocket(String key,SocketThread s){
		socketMap.addSocket(key, s);
	}
	
	
	class MapaPartidas {
		private Map<String,DataPartida> searchByPlayer1;
		private Map<String,String> searchByPlayer2;
		
		public MapaPartidas(){
			searchByPlayer1= new HashMap<String,DataPartida>();
			searchByPlayer2= new HashMap<String,String>();
		}
		
		public DataPartida getDataPartida(String playerID){
			if(searchByPlayer1.containsKey(playerID)){
				return(DataPartida)searchByPlayer1.get(playerID);
			}
			else if(searchByPlayer2.containsKey(playerID)){
				if(searchByPlayer1.containsKey(searchByPlayer2.get(playerID)))
					return (DataPartida)searchByPlayer1.get((String)searchByPlayer2.get(playerID));
			}
			return null;
		}
		
		public void setDataPartida(String Player1,String Player2){
			searchByPlayer1.put(Player1, new DataPartida(Player1,Player2));
			searchByPlayer2.put(Player2, Player1);
		}
		
		public void remove(String Player){
			if(searchByPlayer1.containsKey(getDataPartida(Player).getOponentID(Player))){
				searchByPlayer1.remove(getDataPartida(Player).getOponentID(Player));
				searchByPlayer2.remove(Player);
			}
			else if(searchByPlayer1.containsKey(Player)){
				searchByPlayer1.remove(Player);
				searchByPlayer2.remove(getDataPartida(Player).getOponentID(Player));
			}
		}
	}
	
	class SocketMap {
		HashMap<String,SocketThread> socketMap;
		
		public SocketMap(){
			socketMap= new HashMap<String,SocketThread>();
		}
		
		public void addSocket(String key, SocketThread st){
			socketMap.put(key,st);
		}
		
		public SocketThread getSocket(String key){
			return socketMap.get(key);
		}
		public void removeSocket(String key){
			socketMap.remove(key);
		}
	}
}
