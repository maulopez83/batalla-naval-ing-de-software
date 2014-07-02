package Test;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import negocio.comunicacion.mensajes.*;
import negocio.comunicacion.mensajes.Decodificacion.*;

import org.junit.Test;

public class DecodificacionTest {

	@Test
	public void DecodificarMsjConectar() {
		System.out.println("Decodificacion msj conectar");
		MensajeConectar msj = new MensajeConectar("");
		assertTrue(msj.getType().toString().contains("negocio.comunicacion.mensajes.Conectar") );
		assertFalse(msj.getType().toString().contains("negocio.comunicacion.mensajes.Desconectar") );
		assertFalse(msj.getType().toString().contains("negocio.comunicacion.mensajes.Disparo") );
		assertFalse(msj.getType().toString().contains("negocio.comunicacion.mensajes.Colocar") );
	}
	
	@Test
	public void DecodificarMsjDesconectar() {
		System.out.println("Decodificacion msj desconectar");
		MensajeDesconectar msj = new MensajeDesconectar();
		assertFalse(msj.getType().toString().contains("negocio.comunicacion.mensajes.Conectar") );
		assertTrue(msj.getType().toString().contains("negocio.comunicacion.mensajes.Desconectar") );
		assertFalse(msj.getType().toString().contains("negocio.comunicacion.mensajes.Disparo") );
		assertFalse(msj.getType().toString().contains("negocio.comunicacion.mensajes.Colocar") );
	}
	
	@Test
	public void DecodificarMsjDisparo() {
		System.out.println("Decodificacion msj disparo");
		MensajeDisparo msj = new MensajeDisparo(new Point(2,6));
		assertFalse(msj.getType().toString().contains("negocio.comunicacion.mensajes.Conectar") );
		assertFalse(msj.getType().toString().contains("negocio.comunicacion.mensajes.Desconectar") );
		assertTrue(msj.getType().toString().contains("negocio.comunicacion.mensajes.Disparo") );
		assertFalse(msj.getType().toString().contains("negocio.comunicacion.mensajes.Colocar") );
	}
	
	@Test
	public void DecodificarMsjColocar() {
		System.out.println("Decodificacion msj conectar");
		ArrayList<ArrayList<Point>> t = new ArrayList<ArrayList<Point>>();
		MensajeColocar msj = new MensajeColocar(t);
		assertFalse(msj.getType().toString().contains("negocio.comunicacion.mensajes.Conectar") );
		assertFalse(msj.getType().toString().contains("negocio.comunicacion.mensajes.Desconectar") );
		assertFalse(msj.getType().toString().contains("negocio.comunicacion.mensajes.Disparo") );
		assertTrue(msj.getType().toString().contains("negocio.comunicacion.mensajes.Colocar") );
	}

}
