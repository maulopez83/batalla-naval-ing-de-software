package negocio.comunicacion.mensajes;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import presentacion.cliente.logica.comunicacion.DelayThread;
import presentacion.cliente.visual.Ventana;


import negocio.comunicacion.elementosgraficos.ElementoGUI;
import negocio.comunicacion.mensajes.*;
import datos.server.datos.*;
import datos.server.datos.TableroMarcado.DISPARO;
import datos.server.datos.guiconfigs.PlantillaVentanaColocar;
import datos.server.datos.guiconfigs.PlantillaVentanaDisparo;
import datos.server.datos.guiconfigs.PlantillaVentanaEsperarJugador;
import datos.server.datos.guiconfigs.ResultadoDisparoGUI;

/*
 * Patron Strategy:
 * Esta interfaz declara el metodo decodificar.
 * es implementada por distintas clases que señalan tipos de Mensaje
 * Esto sirve para que cada Mensaje se decodifique de una forma especifica
 * y su implementación este oculta.
 * 
 */

public interface Decodificacion extends Serializable {
	void decodificar(Mensaje m);
}
/*
 * Disparo - implements Decodificación
 * Clase con el metodo para decodificar mensajes de Tipo Disparo
 * 
 */
class Disparo implements Decodificacion {
	private static final long serialVersionUID = 1L;
	/*
	 * decodificar()
	 * returns: String? (deberia ser void capaz dsp lo vemos)
	 * params: Mensaje m
	 * DEBE DECODIFICAR LO QUE PASA CUANDO LLEGA UN DISPARO, FALTA IMPLEMENTAR BIEN 
	 */
	public void decodificar(Mensaje m){
		MensajeDisparo msg=(MensajeDisparo) m;
		Point p= msg.getPoint();
		int Xpos= (int)(p.getX());
		int Ypos= (int)(p.getY());
		
		BaseDatosSingleton GameData = BaseDatosSingleton.getInstance();
		
		DISPARO result= GameData.setDisparo(msg.getClientID(), msg.getPoint());
		if(result==DISPARO.FINAL){
			ResultadoDisparoGUI finalGUI = new ResultadoDisparoGUI(msg.getClientID());	
			GameData.sendMsgToPlayer(msg.getClientID(),finalGUI.create(DISPARO.HUNDIDO, msg.getPoint(), true));		
			GameData.sendMsgToOponent(msg.getClientID(),finalGUI.create(DISPARO.HUNDIDO, msg.getPoint(), false));		
			MensajeGUI MsgWinner= finalGUI.create(result, msg.getPoint(), true);
			MensajeGUI MsgLoser= finalGUI.create(result, msg.getPoint(), false);
			GameData.sendMsgToPlayer(msg.getClientID(),MsgWinner);		
			GameData.sendMsgToOponent(msg.getClientID(),MsgLoser);	
			GameData.sendMsgToPlayer(msg.getClientID(),new MensajeTurno(false, DISPARO.HUNDIDO.toString()));	
			GameData.sendMsgToOponent(msg.getClientID(),new MensajeTurno(false));
		}
		else{
			ResultadoDisparoGUI rGUI= new ResultadoDisparoGUI(msg.getClientID());
			MensajeGUI MsgPlayer1= rGUI.create(result, msg.getPoint(), true);
			MsgPlayer1.setClientID(msg.getClientID());
			MensajeGUI MsgPlayer2= rGUI.create(result, msg.getPoint(), false);
		
			GameData.sendMsgToPlayer(msg.getClientID(),new MensajeTurno(false, result.toString()));	
			GameData.sendMsgToOponent(msg.getClientID(),new MensajeTurno(true, "Es su turno de disparar"));
			GameData.sendMsgToPlayer(msg.getClientID(),MsgPlayer1);		
			GameData.sendMsgToOponent(msg.getClientID(),MsgPlayer2);
		}
			System.out.println("Se presiono: ");
			System.out.println("X: "+Xpos);
			System.out.println("Y: "+Ypos);
	}
}
/*
 * Desconectar - implements Decodificación
 * Clase con el metodo para decodificar mensajes de Tipo Desconectar
 * 
 */
class Desconectar implements Decodificacion{
	private static final long serialVersionUID = 1L;
	/*
	 * decodificar()
	 * returns: String? (deberia ser void capaz dsp lo vemos)
	 * params: Mensaje m
	 * DEBE DECODIFICAR LO QUE PASA CUANDO LLEGA MENSAJE DE DESCONECTAR, FALTA IMPLEMENTAR BIEN 
	 */
	public void decodificar(Mensaje m){
		BaseDatosSingleton GameData= BaseDatosSingleton.getInstance();
			GameData.getSocketMap().getSocket(m.getClientID()).desconectar();
			if(GameData.getSocketMap().getSocket(GameData.getOponentID(m.getClientID()))!=null){
				GameData.getSocketMap().getSocket(GameData.getOponentID(m.getClientID())).desconectar();
			}
	}
}
/*
 * Conectar - implements Decodificación
 * Clase con el metodo para decodificar mensajes de Tipo Conectar
 * Conectaa
 */
class Conectar implements Decodificacion{
	private static final long serialVersionUID = 1L;
	/*
	 * decodificar()
	 * returns: String? (deberia ser void capaz dsp lo vemos)
	 * params: Mensaje m
	 * DEBE DECODIFICAR LO QUE PASA CUANDO LLEGA MENSAJE DE CONECTAR, FALTA IMPLEMENTAR BIEN 
	 */
	public void decodificar(Mensaje m){
		MensajeConectar msg = (MensajeConectar) m;
		BaseDatosSingleton GameData = BaseDatosSingleton.getInstance();
		if(msg.getVersion().equals(GameData.getCurrentVersion())){
			if(GameData.addClient(msg.getClientID())){
				System.out.println("Se agrego el cliente: " + msg.getClientID()
									+". Empieza el juego porque ya son dos");
				
				PlantillaVentanaColocar p = new PlantillaVentanaColocar(msg.getClientID());
				Mensaje respMsgClient=p.create();
				GameData.sendMsgToPlayer(msg.getClientID(), respMsgClient);
				GameData.sendMsgToOponent(msg.getClientID(), respMsgClient);
				
			}
			else{
				System.out.println("Se agrego el cliente: " + msg.getClientID()
						+". Tiene que esperar al otro cliente");
				PlantillaVentanaEsperarJugador plant= new PlantillaVentanaEsperarJugador(msg.getClientID());
				Mensaje respMsg= plant.create();
				respMsg.setClientID(msg.getClientID());
				GameData.getSocketMap().getSocket(msg.getClientID()).addOutPutMsg(respMsg);		
				
			}
			
		}
		
		else{/* Si no tiene la misma version*/
			
		}

	}
}

/*
 * Colocar - implements Decodificación
 * Clase con el metodo para decodificar mensajes de Tipo Colocar
 * 
 */
class Colocar implements Decodificacion{
	private static final long serialVersionUID = 1L;
	/*
	 * decodificar()
	 * returns: String? (deberia ser void capaz dsp lo vemos)
	 * params: Mensaje m
	 * DEBE DECODIFICAR LO QUE PASA CUANDO LLEGA MENSAJE DE COLOCAR, FALTA IMPLEMENTAR BIEN 
	 */
	public void decodificar(Mensaje m){
		BaseDatosSingleton GameData = BaseDatosSingleton.getInstance();
		MensajeColocar msg = (MensajeColocar) m;
		TableroBarcos tab= GameData.getTableroBarcos(msg.getClientID());
		tab.setBarcosTablero(msg.getTablero());
		
		System.out.println("Se agrego el tablero:");
		for (Barcos b:GameData.getTableroBarcos(msg.getClientID()).getBarcosEnTablero()) {
			System.out.println(b.toString());		
			}
		PlantillaVentanaDisparo p = new PlantillaVentanaDisparo(msg.getClientID());
		MensajeGUI respMsg= p.create();
		GameData.sendMsgToPlayer(msg.getClientID(), respMsg);
		GameData.setPlayerReady(msg.getClientID());
		if(GameData.arePlayersReady(msg.getClientID())){
			GameData.sendMsgToPlayer(msg.getClientID(), new MensajeTurno(false,"Es el turno del rival"));
			GameData.sendMsgToOponent(msg.getClientID(), new MensajeTurno(true,"Es su turno de disparar"));
		}
		else{
			GameData.sendMsgToPlayer(msg.getClientID(), new MensajeTurno(false,"Esperando al oponente"));
		}
	
		
	}
	
}

class MGUI implements Decodificacion{
		private static final long serialVersionUID = 1L;
		/*
		 * decodificar()
		 * returns: String? (deberia ser void capaz dsp lo vemos)
		 * params: Mensaje m
		 * DEBE DECODIFICAR LO QUE PASA EN EL CLIENTE CUANDO LLEGA UNA IMAGEN PARA PONER EN GUI, FALTA IMPLEMENTAR BIEN 
		 */
		public void decodificar(Mensaje m){
			MensajeGUI msg= (MensajeGUI) m;
			Ventana GameWindow = Ventana.getInstance();
			if(msg.isNewWindow()){
				GameWindow.setNewView();
			}
			if(msg.getFrameBounds()!=null){
				GameWindow.getFrame().setBounds(msg.getFrameBounds());
			}
			
			for(ElementoGUI eg : msg.getElementos()){
				GameWindow.addComponent(eg.getHashKey(),createLabel(eg));
				GameWindow.setAdapter(eg.getHashKey(), eg.getAdapter());
			}
			for(String hashCode : msg.getElementsToRemove()){
				GameWindow.removeComponent(hashCode);
			}
			for(String hashCode : msg.getAdaptersToRemove()){
				GameWindow.removeAdapter(hashCode);
			}
			
			GameWindow.getFrame().repaint();
		}
		
		public JLabel createLabel(ElementoGUI eg){
			JLabel newLabel= new JLabel();
			newLabel.setText(eg.getText());
			newLabel.setBounds(eg.getBounds());
			try{
				newLabel.setIcon(new ImageIcon(eg.getIcon()));
			} catch(Exception e){System.out.println(e.getMessage());};
			return newLabel;
		}
}

class MTurno implements Decodificacion{
	private static final long serialVersionUID = 1L;

	public void decodificar(Mensaje m) {
		MensajeTurno msg = (MensajeTurno) m;
		Ventana.getInstance().getGuiSubject().setTurno(msg.isTurno());
		if(msg.getToast()!=null){
			new Thread(new ToastThread(msg.getToast())).start();
		}
	}	
	class ToastThread implements Runnable{
		private String toastText;
		public ToastThread(String toastText){
			this.toastText=toastText;
		}
		public void run() {
			JLabel label = new JLabel(toastText);
			label.setSize(200, 20);
			Ventana.getInstance().addComponent("toast", label);
			Ventana.getInstance().getFrame().repaint();
			DelayThread.delay(5000);
			Ventana.getInstance().removeComponent("toast");
		}
		
	}

}
		

