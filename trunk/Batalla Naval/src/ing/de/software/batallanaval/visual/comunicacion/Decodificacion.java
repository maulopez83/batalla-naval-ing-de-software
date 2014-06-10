package ing.de.software.batallanaval.visual.comunicacion;

import java.io.Serializable;

import ing.de.software.batallanaval.datos.*;//VER BIEN QUE ESTA CAPA DE USUARIO NO PUEDE TENDRIA QUE TOCAR DATOS

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