package mensajesServer;

import java.io.Serializable;

public class Data implements Serializable{
	private static final long serialVersionUID = 1L;
	int tablero;
	
	public void setTablero(int tablero) {
		this.tablero=tablero;
		System.out.println("Tablero es:" + this.tablero);
	}

}
