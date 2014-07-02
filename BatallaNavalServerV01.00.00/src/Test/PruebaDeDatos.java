package Test;

import static org.junit.Assert.*;

import java.awt.Point;
import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;

import org.junit.Test;

import datos.BaseDatosSingleton;
import datos.partida.TableroBarcos;

public class PruebaDeDatos {

	
	@Test
	public void test() {
		BaseDatosSingleton Data=BaseDatosSingleton.getInstance();
		String Player1 ="Hernan1";
		String Player2 ="Hernan2";
		
		ArrayList<Point> posicBarco1 = new ArrayList<Point>(); // array que tiene las posiciones del barco1
		posicBarco1.add( new Point(0,0)); // agrego las posiciones al array
		posicBarco1.add( new Point(0,1));
		posicBarco1.add (new Point(0,2));
		ArrayList<Point> posicBarco2 = new ArrayList<Point>();// array que tiene las posiciones del barco2
		posicBarco2.add( new Point(3,0));// agrego las posiciones al array
		posicBarco2.add( new Point(4,0));
		posicBarco2.add (new Point(5,0));
		
		assertTrue(posicBarco1.get(0).equals(new Point(0,0)));
		assertTrue(posicBarco1.get(1).equals(new Point(0,1)));
		assertTrue(posicBarco1.get(2).equals(new Point(0,2)));
		assertTrue(posicBarco2.get(0).equals(new Point(3,0)));
		assertTrue(posicBarco2.get(1).equals(new Point(4,0)));
		assertTrue(posicBarco2.get(2).equals(new Point(5,0)));
		
		ArrayList<ArrayList<Point>> posicBarcosEnTableroP1= new ArrayList<ArrayList<Point>>(); // esto es lo que recibo en el mensaje del cliente despues de colocar ls barcos
		posicBarcosEnTableroP1.add(posicBarco1);// le agrego el barco 1
		posicBarcosEnTableroP1.add(posicBarco2);// le agrego el barco 2
		// aca posicBarcosEnTableroP1 tiene los dos barcos como me llegan en el mensaje desde el Cliente
		ArrayList<ArrayList<Point>> posicBarcosEnTableroP2= new ArrayList<ArrayList<Point>>();
		posicBarcosEnTableroP2.add(posicBarco1);// le agrego el mismo barco 1
		posicBarcosEnTableroP2.add(posicBarco2);// le agrego el mismo barco 2
		
		assertTrue(posicBarcosEnTableroP1.get(0).get(0).equals(new Point(0,0)));
		assertTrue(posicBarcosEnTableroP1.get(0).get(1).equals(new Point(0,1)));
		assertTrue(posicBarcosEnTableroP1.get(0).get(2).equals(new Point(0,2)));
		
		assertTrue(posicBarcosEnTableroP1.get(1).get(0).equals(new Point(3,0)));
		assertTrue(posicBarcosEnTableroP1.get(1).get(1).equals(new Point(4,0)));
		assertTrue(posicBarcosEnTableroP1.get(1).get(2).equals(new Point(5,0)));
		
		
		assertTrue(posicBarcosEnTableroP2.get(0).get(0).equals(new Point(0,0)));
		assertTrue(posicBarcosEnTableroP2.get(0).get(1).equals(new Point(0,1)));
		assertTrue(posicBarcosEnTableroP2.get(0).get(2).equals(new Point(0,2)));
		
		assertTrue(posicBarcosEnTableroP2.get(1).get(0).equals(new Point(3,0)));
		assertTrue(posicBarcosEnTableroP2.get(1).get(1).equals(new Point(4,0)));
		assertTrue(posicBarcosEnTableroP2.get(1).get(2).equals(new Point(5,0)));
		
		
		Data.addClient(Player1);
		Data.addClient(Player2);
		
		
		
		assertEquals((String)Data.getOponentID(Player1), "Hernan2" );
		assertEquals((String)Data.getOponentID(Player2), "Hernan1" );
		
		
		Data.setBarcosEnTablero(Player1, posicBarcosEnTableroP1); 
		Data.setBarcosEnTablero(Player2, posicBarcosEnTableroP2);
		
		assertEquals(Data.getTableroBarcos(Player1), Data.getTableroBarcosOponente(Player2));
		assertEquals(Data.getTableroBarcos(Player2), Data.getTableroBarcosOponente(Player1));
		
		TableroBarcos tbP1=Data.getTableroBarcos(Player1); 
		TableroBarcos tbP2=Data.getTableroBarcos(Player2);
		
		Point disparo1 = new Point(3,2);
		
		Data.setDisparo(Player1,disparo1);
		
		
		//assertTrue(, Data.getTableroJuego(Player1).setDisparo(disparo1, Data.getTableroBarcosOponente(Player1)));
	
		
		Data.setDisparo(Player1,disparo1);
		
		disparo1 = new Point(0,0);
		
		Data.setDisparo(Player1,disparo1);
		
		Data.setDisparo(Player1,disparo1);
		
		disparo1 = new Point(0,1);
		
		Data.setDisparo(Player1,disparo1);
		
		disparo1 = new Point(0,2);
		
		Data.setDisparo(Player1,disparo1);
		
		disparo1 = new Point(3,0);
		
		Data.setDisparo(Player1,disparo1);
		
		disparo1 = new Point(4,0);
		
		Data.setDisparo(Player1,disparo1);
		
		disparo1 = new Point(5,0);
		
		Data.setDisparo(Player1,disparo1);
	}

}
