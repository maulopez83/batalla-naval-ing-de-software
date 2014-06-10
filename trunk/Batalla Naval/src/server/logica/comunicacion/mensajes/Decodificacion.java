package server.logica.comunicacion.mensajes;

import java.io.Serializable;

import server.datos.*;

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
	public String decodificar(Mensaje m){
		DataSingleton GameData = DataSingleton.getInstance();
		GameData.setDato(5);
		System.out.println("El dato es: "+ GameData.getDato());
		return "Es un disparo";
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
	public String decodificar(Mensaje m){
		DataSingleton GameData = DataSingleton.getInstance();
		GameData.setDato(8);
		System.out.println("El dato es: "+ GameData.getDato());
		return "Es Desconectar";
	}
}
/*
 * Conectar - implements Decodificación
 * Clase con el metodo para decodificar mensajes de Tipo Conectar
 * 
 */
class Conectar implements Decodificacion{
	private static final long serialVersionUID = 1L;
	/*
	 * decodificar()
	 * returns: String? (deberia ser void capaz dsp lo vemos)
	 * params: Mensaje m
	 * DEBE DECODIFICAR LO QUE PASA CUANDO LLEGA MENSAJE DE CONECTAR, FALTA IMPLEMENTAR BIEN 
	 */
	public String decodificar(Mensaje m){
		DataSingleton GameData = DataSingleton.getInstance();
		GameData.setDato(2);
		System.out.println("El dato es: "+ GameData.getDato());
		return "Es Conectar";
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
	public String decodificar(Mensaje m){
		DataSingleton GameData = DataSingleton.getInstance();
		GameData.setDato(3);
		System.out.println("El dato es: "+ GameData.getDato());
		return "Es Colocar";
	}
}