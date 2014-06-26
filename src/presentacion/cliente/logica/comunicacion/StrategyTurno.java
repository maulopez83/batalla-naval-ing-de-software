package presentacion.cliente.logica.comunicacion;

import negocio.server.logica.comunicacion.mensajes.Mensaje;

public interface StrategyTurno {
	public void sendMsg(Mensaje msg);
}

class esTurno implements StrategyTurno{

	public void sendMsg(Mensaje msg) {
		
		
	}
	
}