package datos.server.datos;

public class DataPartida {
	private TableroBarcos tabBarcosP1;
	private TableroMarcado tabJuegoP1;
	private TableroBarcos tabBarcosP2;
	private TableroMarcado tabJuegoP2;
	private String Player2;
	private String Player1;
	
	public DataPartida(String Player1,String Player2){
		tabBarcosP1= new TableroBarcos();
		tabJuegoP1 = new TableroMarcado();
		tabBarcosP2= new TableroBarcos();
		tabJuegoP2 = new TableroMarcado();
		this.Player1=Player1;
		this.Player2=Player2;
	}
	
	public TableroBarcos getTableroBarcos(String Player){
		if(Player.equalsIgnoreCase(Player1)){
			return tabBarcosP1;
		}
		else if (Player.equalsIgnoreCase(Player2)){
			return tabBarcosP2;
		}
		else{
			return null;
		}
	}
	
	public TableroMarcado getTableroJuego(String Player){
		if(Player.equalsIgnoreCase(Player1)){
			return tabJuegoP1;
		}
		else if (Player.equalsIgnoreCase(Player2)){
			return tabJuegoP2;
		}
		else{
			return null;
		}
	}
	
	public TableroBarcos getTableroBarcosOponente(String Player){
		if(Player.equalsIgnoreCase(Player1)){
			return tabBarcosP2;
		}
		else if (Player.equalsIgnoreCase(Player2)){
			return tabBarcosP1;
		}
		else{
			return null;
		}
	}
	
	public String getOponentID(String Player){
		if(Player.equalsIgnoreCase(Player1)){
			return Player2;
		}
		else if (Player.equalsIgnoreCase(Player2)){
			return Player1;
		}
		return null;
	}


	
}
