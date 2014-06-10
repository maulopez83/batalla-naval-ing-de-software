package mensajesServer;

import java.io.Serializable;

import Otras.DataSingleton;

public interface Decodificacion extends Serializable {
	String decodificar(Mensaje m);
}

class Disparo implements Decodificacion {
	private static final long serialVersionUID = 1L;
	public String decodificar(Mensaje m){
		return null;
	}
}

class Desconectar implements Decodificacion{
	private static final long serialVersionUID = 1L;

	public String decodificar(Mensaje m){
		return null;
	}
}

class Conectar implements Decodificacion{
	private static final long serialVersionUID = 1L;

	public String decodificar(Mensaje m){
		return null;
	}
}

class Colocar implements Decodificacion{
	private static final long serialVersionUID = 1L;

	public String decodificar(Mensaje m){
		return null;
	}
}