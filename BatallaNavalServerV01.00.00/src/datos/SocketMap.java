package datos;

import java.util.HashMap;

import negocio.comunicacion.SocketThread;

public class SocketMap {
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
