package Otras;
import java.io.IOException;

import mensajesServer.*;


public class MainServer {
	
	public static void main(String args[]) throws IOException{
	int port = 2344;
	
	MsgHandler handler=new MsgHandler();
	new Thread(handler).start();
	
	if(args.length == 1)
		port = Integer.parseInt(args[0]);		
	ListeningServer lserver = new ListeningServer(port,"hola",handler);
	new Thread(lserver).start();
	port = 2343;
	if(args.length == 1)
		port = Integer.parseInt(args[0]);		
	TalkingServer tserver = new TalkingServer(port,"hola");
	new Thread(tserver).start();
	}
}
