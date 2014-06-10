package ing.de.software.batallanaval.logica.comunicacion;

import java.io.Serializable;

import ing.de.software.batallanaval.datos.*;



public interface Decodificacion extends Serializable {
	String decodificar(Mensaje m);
}

class Disparo implements Decodificacion {
	private static final long serialVersionUID = 1L;
	public String decodificar(Mensaje m){
		DataSingleton GameData = DataSingleton.getInstance();
		GameData.setDato(5);
		System.out.println("El dato es: "+ GameData.getDato());
		return "Es un disparo";
	}
}

class Desconectar implements Decodificacion{
	private static final long serialVersionUID = 1L;

	public String decodificar(Mensaje m){
		DataSingleton GameData = DataSingleton.getInstance();
		GameData.setDato(8);
		System.out.println("El dato es: "+ GameData.getDato());
		return "Es Desconectar";
	}
}

class Conectar implements Decodificacion{
	private static final long serialVersionUID = 1L;

	public String decodificar(Mensaje m){
		DataSingleton GameData = DataSingleton.getInstance();
		GameData.setDato(2);
		System.out.println("El dato es: "+ GameData.getDato());
		return "Es Conectar";
	}
}

class Colocar implements Decodificacion{
	private static final long serialVersionUID = 1L;

	public String decodificar(Mensaje m){
		DataSingleton GameData = DataSingleton.getInstance();
		GameData.setDato(3);
		System.out.println("El dato es: "+ GameData.getDato());
		return "Es Colocar";
	}
}