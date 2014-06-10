package ing.de.software.batallanaval.visual;
import ing.de.software.batallanaval.visual.sonido.*;
import ing.de.software.batallanaval.visual.animacion.*;
import ing.de.software.batallanaval.visual.imagen.*;
import ing.de.software.batallanaval.visual.comunicacion.*;

//import ing.de.software.batallanaval.logica.*; //No hace falta en principio porque la comunicacion con la lógica del programa
//se hará por paso de mensajes a traves de sockets.

public class InterfazGrafica {

	Imagenes fondo;
	Sonidos sonidoamb;
	HilodeEnvio hiloenvio;
	HilodeEscucha hiloescucha;
	//y demas variables de clase que se necesitan para la ventana.
	
		private InterfazGrafica(){ //Implemetarlo como Singleton
			
			//Métodos necesarios para setear la ventana al formato deseado con su tablero inclusive.
			fondo= new Fondo(this);//Establecemos un fondo para el juego
			fondo.showImagen();
			sonidoamb= new Ambiente();//Establecemos un sonido ambiente que durará todo el tiempo que esté abierta la aplicacion
			sonidoamb.playSonido();
			hiloescucha = new HilodeEscucha(this);
			
			//METODOS QUE DEFINEN EL COMPORTAMIENTO ANTE LAS ACCIONES DEL USUARIO EN LA INTERGAZ GRAFICA
			//LOS CUALES VAN A ENVIAR INFORMACION AL SERVIDOR.
			
			//EJECUTAMOS METODO RUN() DE LOS HILOS.
			
		}
		
	public void createGUI(){//Método público para implementar el Singleton
	}
	
	//--------------------------Metodos que usará el Servidor (Hilo de Escucha)----------------------------------------//	
	public void setTableroPantalla(String coordenada){}//String recibido del servidor. (Manejado por el hilo de escucha)
	
	public void showMessage(String mensaje){}//String recibido del servidor. (Manejado por el hilo de escucha)
	
	public void setSonido(Sonidos evento){//Parametro recibido del servidor. (Manejado por el hilo de escucha)
		evento.playSonido();
	}
	
	public void setAnimacion(Animaciones evento){//Parametro recibido del servidor. (Manejado por el hilo de escucha)
		evento.playAnimacion();
	}
	//--------------------------------------------------------------------------------------------------------------------//
	
	
	//------------------------Metodos usados por la Interfaz (Enviados por Hilo de Envio)--------------------------------//	
	public void sendDisparo(String coordenada){
		hiloenvio.setMensaje(coordenada);
		hiloenvio.run();
	}
	public void sendPosicionesBarcos(String coordenadas){
		hiloenvio.setMensaje(coordenadas);
		hiloenvio.run();
	}
	//--------------------------------------------------------------------------------------------------------------------//
	
}
