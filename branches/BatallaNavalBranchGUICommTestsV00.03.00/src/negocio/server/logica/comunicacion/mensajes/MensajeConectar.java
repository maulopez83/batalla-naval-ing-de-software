package negocio.server.logica.comunicacion.mensajes;

import java.io.Serializable;
/*
 * Mensaje Conectar extends Mensaje
 * Subtipo de mensaje, se decodifica con Conectar.decodificar()
 */
public class MensajeConectar extends Mensaje implements Serializable {
	private static final long serialVersionUID = 1L;
	private String Version;
	private String ClientID;
	public MensajeConectar(String Version, String ClientID ) {
		super();
		setType(new Conectar());
		setVersion(Version);
		setClientID(ClientID);
	}
	public void setVersion(String version) {
		Version = version;
	}
	public String getVersion() {
		return Version;
	}
	public void setClientID(String clientID) {
		ClientID = clientID;
	}
	public String getClientID() {
		return ClientID;
	}
	
}
