package ing.de.software.batallanaval.visual;
import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.Queue;
import ing.de.software.batallanaval.visual.comunicacion.*;

public class TalkingClientGUIObserver implements Observer {
	private String host;
	private int port;
	private Queue<Mensaje> OutputMsg;
	private Socket connection;
	

	public TalkingClientGUIObserver(String host, int port) throws IOException {
		this.host = host; this.port = port;
		OutputMsg = new LinkedList<Mensaje>();
	}
	
	
	private void addMsg(Mensaje msg) {
		OutputMsg.add(msg);
	}
	
	private void sendMessage() {
			try{
			connection = new Socket(host, port);	
			ObjectOutputStream outToServer = new ObjectOutputStream(connection.getOutputStream());
			Mensaje msgToSend=OutputMsg.poll();
			if(msgToSend!=null){
				outToServer.writeObject(msgToSend);
				outToServer.flush();
			}
			outToServer.close();
			connection.close();
		  }catch(Exception e){};	
	}

	public void update(Mensaje m) {
		addMsg(m);
		sendMessage();
	}
}