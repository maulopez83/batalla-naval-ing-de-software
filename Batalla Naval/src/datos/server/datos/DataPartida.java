package datos.server.datos;

public class DataPartida {
	private Tablero tabBarcos;
	private Tablero tabJuego;
	public DataPartida(){
		tabBarcos= new TableroBarcos();
		tabJuego = new TableroMarcado();
	}
	public Tablero getTabBarcos() {
		return tabBarcos;
	}
	public void setTabBarcos(Tablero tabBarcos) {
		this.tabBarcos = tabBarcos;
	}
	public Tablero getTabJuego() {
		return tabJuego;
	}
	public void setTabJuego(Tablero tabJuego) {
		this.tabJuego = tabJuego;
	}
	
}
