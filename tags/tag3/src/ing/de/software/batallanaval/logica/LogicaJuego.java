package ing.de.software.batallanaval.logica;
import ing.de.software.batallanaval.datos.*;
import ing.de.software.batallanaval.logica.comunicacion.*;
/*import ing.de.software.batallanaval.visual.*;*/ //Se va a comunicar por puerto con la Visual Mediante Paso de Mensajes

public class LogicaJuego {

	HilodeEnvio hiloenvio;
	HilodeEscucha hiloescucha;
	
	
	public LogicaJuego(){
		
	}
	
	public void ColocarBarcos(Coordenada coord, Players jugador, EnumTablero tipodebarco){
		jugador.setDatoTablero1(coord, tipodebarco);//Tablero 1 donde estarán sus barcos colocados
	}
	
	public void Disparo(Coordenada coord, Players turno, Players noturno){
		/*if(noturno.getDatoTablero1(coord)!=EnumTablero.AGUA){
			turno.setDatoTablero2(coord, EnumTablero.EXITOSO);//Tablero 2 donde estarán los disparos que va haciendo el jugador.
			//se cargará un AVERIADO si el disparo fue exitoso y se cargará un FALLIDO si el disparo no lo fué.
			//se deberá enviar el mensaje de EXITOSO o HUNDIDO
		}
		else{
			turno.setDatoTablero2(coord, EnumTablero.FALLIDO);
		}*/
	}
	
}
