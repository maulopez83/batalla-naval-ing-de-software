package Test;

import static org.junit.Assert.*;

import java.awt.Point;

import negocio.comunicacion.mensajes.MensajeDisparo;

import org.junit.Test;

public class MensajeDisparoTest {

	@Test
	public void DecodificarMsjDisparo() {
		System.out.println("Prueba msj disparo");
		Point p = new Point(2,6);
		MensajeDisparo msj = new MensajeDisparo(p);
		assertTrue(msj.getPoint().getX() == 2);
		assertTrue(msj.getPoint().getY() == 6);
	}


}
