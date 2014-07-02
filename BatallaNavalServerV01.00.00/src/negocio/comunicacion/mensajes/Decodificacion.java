package negocio.comunicacion.mensajes;

import java.awt.Point;
import java.io.Serializable;

import negocio.comunicacion.DelayThread;

import datos.*;
import datos.configuracionesgui.PlantillaVentanaColocar;
import datos.configuracionesgui.PlantillaVentanaDisparo;
import datos.configuracionesgui.PlantillaVentanaEsperarJugador;
import datos.configuracionesgui.ResultadoDisparoGUI;
import datos.partida.TableroBarcos;
import datos.partida.TableroMarcado.DISPARO;

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
			GameData.getSocket(m.getClientID()).desconectar();
			
			if(GameData.getSocket(GameData.getOponentID(m.getClientID()))!=null){
				if(!GameData.isGameFinished(m.getClientID())){
					ResultadoDisparoGUI finalGUI = new ResultadoDisparoGUI(m.getClientID());	
					MensajeGUI MsgWinner= finalGUI.create(DISPARO.FINAL, null, true);
					GameData.sendMsgToOponent(m.getClientID(),MsgWinner);
					GameData.sendMsgToOponent(m.getClientID(), new MensajeTurno(false,"Su oponente se desconecto"));
				}
				GameData.getSocket(GameData.getOponentID(m.getClientID())).desconectar();
			}
			GameData.deleteClient(m.getClientID());
			GameData.deleteClient(GameData.getOponentID(m.getClientID()));
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
				PlantillaVentanaColocar p = new PlantillaVentanaColocar(msg.getClientID());
				Mensaje respMsgClient=p.create();
				GameData.sendMsgToPlayer(msg.getClientID(), respMsgClient);
				GameData.sendMsgToOponent(msg.getClientID(), respMsgClient);
				
			}
			else{
				PlantillaVentanaEsperarJugador plant= new PlantillaVentanaEsperarJugador(msg.getClientID());
				Mensaje respMsg= plant.create();
				respMsg.setClientID(msg.getClientID());
				GameData.getSocket(msg.getClientID()).addOutPutMsg(respMsg);		
				
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
		public void decodificar(Mensaje m){}
}

class MTurno implements Decodificacion{
	private static final long serialVersionUID = 1L;

	public void decodificar(Mensaje m) {}

}
		

