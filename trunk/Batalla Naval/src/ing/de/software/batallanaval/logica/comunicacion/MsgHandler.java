package ing.de.software.batallanaval.logica.comunicacion;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;


public class MsgHandler implements Runnable,Serializable {
	private static final long serialVersionUID = 1L;
	public Queue <Mensaje> MsgQ;
	public MsgHandler(){
		MsgQ= new LinkedList<Mensaje>();
	}

	
	public void run() {
		while (true){
			while(!MsgQ.isEmpty()){
			Mensaje m=MsgQ.remove();
			System.out.println("Mira llego algooo");
			String resultado=m.decodificar();
			System.out.println(resultado);
			}
			DelayThread.delay(100);
		}
	}
	
	public void addMsg(Mensaje m){
		MsgQ.add(m);
	}
	
}
