package negocio.server.main;

import java.awt.Point;
import java.util.ArrayList;

import datos.server.datos.Barcos;
import datos.server.datos.BaseDatosSingleton;
import datos.server.datos.TableroBarcos;
import datos.server.datos.TableroMarcado;

public class PruebaDatosMain {
	public static void main(String args[]){
		BaseDatosSingleton Data=BaseDatosSingleton.getInstance();
		String Player1 ="Juan";
		String Player2 ="Pibe";
		
		ArrayList<Point> posicBarco1 = new ArrayList<Point>(); // array que tiene las posiciones del barco1
		posicBarco1.add( new Point(0,0)); // agrego las posiciones al array
		posicBarco1.add( new Point(0,1));
		posicBarco1.add (new Point(0,2));
		ArrayList<Point> posicBarco2 = new ArrayList<Point>();// array que tiene las posiciones del barco2
		posicBarco2.add( new Point(3,0));// agrego las posiciones al array
		posicBarco2.add( new Point(4,0));
		posicBarco2.add (new Point(5,0));
		
		ArrayList<ArrayList<Point>> posicBarcosEnTableroP1= new ArrayList<ArrayList<Point>>(); // esto es lo que recibo en el mensaje del cliente despues de colocar ls barcos
		posicBarcosEnTableroP1.add(posicBarco1);// le agrego el barco 1
		posicBarcosEnTableroP1.add(posicBarco2);// le agrego el barco 2
		// aca posicBarcosEnTableroP1 tiene los dos barcos como me llegan en el mensaje desde el Cliente
		ArrayList<ArrayList<Point>> posicBarcosEnTableroP2= new ArrayList<ArrayList<Point>>();
		posicBarcosEnTableroP2.add(posicBarco1);// le agrego el mismo barco 1
		posicBarcosEnTableroP2.add(posicBarco2);// le agrego el mismo barco 2

		Data.addClient(Player1);
		Data.addClient(Player2);
		// aca se crean los datos del juego porque añadi dos clientes al server
		
		Data.setBarcosEnTablero(Player1, posicBarcosEnTableroP1); // seteo los barcos en el TableroBarcos de Player1
		Data.setBarcosEnTablero(Player2, posicBarcosEnTableroP2); // seteo los barcos en el TableroBarcos de Player2
		
		TableroBarcos tbP1=Data.getTableroBarcos(Player1); // obtengo el TableroBarcos de Player1
		TableroBarcos tbP2=Data.getTableroBarcos(Player2);// obtengo el TableroBarcos de Player2
	
		/*
		 * Para cada barco del TableroBarcos de Player1
		 * veo cada posicion del barco y la imprimo
		 */
		System.out.println("Tablero de " + Player1);
		int i=0;
		for(Barcos b: tbP1.getBarcosEnTablero()){
			System.out.println("Barco : " + (++i));
			for(Point p: b.getPosiciones()){
				System.out.println("("+(int)p.getX() +", " +(int)p.getY() +")");
			}
		}
		
		/*
		 * Para cada barco del TableroBarcos de Player2
		 * veo cada posicion del barco y la imprimo 
		 */
		System.out.println("Tablero de " + Player2);
		i=0;
		for(Barcos b: tbP2.getBarcosEnTablero()){
			System.out.println("Barco : " + (++i));
			for(Point p: b.getPosiciones()){
				System.out.println("("+(int)p.getX() +", " +(int)p.getY() +")");
			}
		}

		Point disparo1 = new Point(3,2); // creo una posicion de disparo
		
		Data.setDisparo(Player1,disparo1); // disparo en una posicion que no hay barco hacia el tablero de P2
		// por ahora internamente debe imprimir "Agua" en consola.
		Data.setDisparo(Player1,disparo1);// repito el mismo disparo
		// se debe imprimir que repeti el disparo
		disparo1 = new Point(0,0); // pongo un disparo donde si hay un barco	
		Data.setDisparo(Player1,disparo1); // disparo donde hay barco
		// se debe imprimir averiado
		Data.setDisparo(Player1,disparo1); // repito el mismo disparo
		// se debe imprimir que repeti el disparo
		disparo1 = new Point(0,1); // sigo averiando el barco poniendo disparo aca
		Data.setDisparo(Player1,disparo1); // disparo donde hay barco
		// se debe imprimir averiado
		disparo1 = new Point(0,2); // pongo para hundir el barco
		Data.setDisparo(Player1,disparo1); // disparo donde hay barco
		// se debe imprimir hundido.
		disparo1 = new Point(3,0);
		Data.setDisparo(Player1,disparo1); // disparo donde hay barco
		// se debe imprimir averiado
		disparo1 = new Point(4,0);
		Data.setDisparo(Player1,disparo1); // disparo donde hay barco
		// se debe imprimir averiado
		disparo1 = new Point(5,0);
		Data.setDisparo(Player1,disparo1); // disparo donde hay barco
		// se debe imprimir hundido.
	}
}
