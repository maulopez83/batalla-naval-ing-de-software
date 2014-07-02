package datos;

import java.util.HashMap;
import java.util.Map;

public class MapaPartidas {
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
