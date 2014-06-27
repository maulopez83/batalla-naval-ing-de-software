package negocio.comunicacion.mensajes;

import java.io.Serializable;
/*
 * Mensaje Conectar extends Mensaje
 * Subtipo de mensaje, se decodifica con Conectar.decodificar()
 */
public class MensajeConectar extends Mensaje implements Serializable {
	private static final long serialVersionUID = 1L;
	private String Version;
	public MensajeConectar(String Version, String clientID ) {
		super();
		setType(new Conectar());
		setVersion(Version);
	}
	public void setVersion(String version) {
		Version = version;
	}
	public String getVersion() {
		return Version;
	}
	
}
