package negocio.comunicacion.mensajes;
import java.io.Serializable;
import java.util.ArrayList;

/*
 * abstract Mensaje - implements Serializable
 * Clase que permite almacenar los datos de juego que deben ser
 * enviados entre el cliente y el servidor. Puede enviarse a través de un
 * Socket mediante la funcion ObjectOutputStream.writeObject() 
 * y ObjectInputStream.readObject()
 */
public abstract class Mensaje implements Serializable{

	private static final long serialVersionUID = 1L;
	public  Decodificacion typeofMessage;
	private String msg;
	private String clientID;
	public	Mensaje(String clientID){
		this.clientID=clientID;
	}
	
	
	public String getClientID() {
		return clientID;
	}


	public void setClientID(String clientID) {
		this.clientID = clientID;
	}


	public void setType(Decodificacion type){
		typeofMessage=type;
	}
	
	public void setMsg(String msg){
		this.msg=msg;
	}
	public String getMsg(){
		return this.msg;
	}


	public Decodificacion getType() {
		return typeofMessage;
	}
	/*
	 * decodificar()
	 * returns: String
	 * params: void
	 * Se encarga de decodificar el contenido del mensaje y
	 * realizar con el todas las acciones necesarias para su 
	 * almacenamiento y/o manipulación, teniendo en cuenta
	 * el tipo de mensaje que es. Para ello implementa un patron
	 * Strategy, llamando a decodificar del campo Decodificacion typeOfMessage
	 */
	public ArrayList<Mensaje> decodificar(){
		return getType().decodificar(this);
	}
	
	
}
