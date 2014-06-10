package presentacion.cliente.logica.comunicacion.mensajes;

import java.io.Serializable;

/*
 * Patron Strategy:
 * Esta interfaz declara el metodo decodificar.
 * es implementada por distintas clases que señalan tipos de Mensaje
 * Esto sirve para que cada Mensaje se decodifique de una forma especifica
 * y su implementación este oculta.
 * 
 */

public interface Decodificacion extends Serializable {
	String decodificar(Mensaje m);
}


/*
 * Declaración de clase Disparo - implements Decodificación
 * Sirve para setear el tipo de mensaje, el método decodificar
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
 * Declaración de clase Desconectar - implements Decodificación
 * Sirve para setear el tipo de mensaje, el método decodificar
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
 * Declaración de clase Conectar - implements Decodificación
 * Sirve para setear el tipo de mensaje, el método decodificar
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
 * Declaración de clase Colocar - implements Decodificación
 * Sirve para setear el tipo de mensaje, el método decodificar
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