package mensajesServer;
import java.io.Serializable;

public abstract class Mensaje implements Serializable{

	private static final long serialVersionUID = 1L;
	public  Decodificacion typeofMessage;
	private String msg;
	private int senderID;
	private Data data;
	public	Mensaje(String msg,int senderID){
		this.msg=msg;
		this.senderID=senderID;
		data=null;
	}
	
	public void setData(Data d){
		this.data=d;
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

	public void setSenderID(int senderID) {
		this.senderID = senderID;
	}

	public Decodificacion getType() {
		return typeofMessage;
	}
	
	public String decodificar(){
		return getType().decodificar(this);
	}
	
	
}
