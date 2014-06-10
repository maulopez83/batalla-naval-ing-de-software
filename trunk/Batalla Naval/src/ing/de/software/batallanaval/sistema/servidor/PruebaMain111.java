package ing.de.software.batallanaval.sistema.servidor;


import ing.de.software.batallanaval.logica.comunicacion.*;

public class PruebaMain111 {

	public static void main(String args[]){
		MsgHandler handler= new MsgHandler();
		new Thread(handler).start();
		while (true){
			System.out.println("ENTRE");
		MensajeDisparo m= new MensajeDisparo("dispare", 0);
		MensajeColocar m2= new MensajeColocar("coloque", 0);
		MensajeConectar m3= new MensajeConectar("conecte", 0);
		MensajeDesconectar m4= new MensajeDesconectar("desconecte", 0);

			handler.addMsg(m);
			handler.addMsg(m2);
			handler.addMsg(m3);
			handler.addMsg(m4);
		DelayThread.delay(1000);
		}
	}
}
