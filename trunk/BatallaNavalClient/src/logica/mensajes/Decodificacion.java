package logica.mensajes;

import java.io.Serializable;

/*
 * Patron Strategy:
 * Esta interfaz declara el metodo decodificar.
 * es implementada por distintas clases que se�alan tipos de Mensaje
 * Esto sirve para que cada Mensaje se decodifique de una forma especifica
 * y su implementaci�n este oculta.
 * 
 */

public interface Decodificacion extends Serializable {
	String decodificar(Mensaje m);
}


/*
 * Declaraci�n de clase Disparo - implements Decodificaci�n
 * Sirve para setear el tipo de mensaje, el m�todo decodificar
 * se encuentra del lado del servidor ya que no se decodifica
 * en el cliente.
 * 
 */
class Disparo implements Decodificacion {
	private static final long serialVersionUID = 1L;
	public String decodificar(Mensaje m){
		return null;
	}
}

/*
 * Declaraci�n de clase Desconectar - implements Decodificaci�n
 * Sirve para setear el tipo de mensaje, el m�todo decodificar
 * se encuentra del lado del servidor ya que no se decodifica
 * en el cliente.
 * 
 */
class Desconectar implements Decodificacion{
	private static final long serialVersionUID = 1L;

	public String decodificar(Mensaje m){
		return null;
	}
}

/*
 * Declaraci�n de clase Conectar - implements Decodificaci�n
 * Sirve para setear el tipo de mensaje, el m�todo decodificar
 * se encuentra del lado del servidor ya que no se decodifica
 * en el cliente.
 * 
 */
class Conectar implements Decodificacion{
	private static final long serialVersionUID = 1L;

	public String decodificar(Mensaje m){
		return null;
	}
}

/*
 * Declaraci�n de clase Colocar - implements Decodificaci�n
 * Sirve para setear el tipo de mensaje, el m�todo decodificar
 * se encuentra del lado del servidor ya que no se decodifica
 * en el cliente.
 * 
 */
class Colocar implements Decodificacion{
	private static final long serialVersionUID = 1L;

	public String decodificar(Mensaje m){
		return null;
	}
}