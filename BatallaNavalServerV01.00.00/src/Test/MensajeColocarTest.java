package Test;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import negocio.comunicacion.mensajes.MensajeColocar;

import org.junit.Test;

public class MensajeColocarTest {

	@Test
	public void DecodificarMsjColocar() {
		System.out.println("Prueba msj conectar");
		ArrayList<ArrayList<Point>> t = new ArrayList<ArrayList<Point>>();
		MensajeColocar msj = new MensajeColocar(t);
		assertEquals(t, msj.getTablero());
		
	}
}
