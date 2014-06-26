package presentacion.cliente.logica.comunicacion;

import negocio.comunicacion.mensajes.Mensaje;

public interface StrategyTurno {
	public void sendMsg(Mensaje msg);
}

class esTurno implements StrategyTurno{

	public void sendMsg(Mensaje msg) {
		
		
	}
	
}