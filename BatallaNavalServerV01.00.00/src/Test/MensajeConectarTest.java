package Test;

import static org.junit.Assert.*;
import negocio.comunicacion.mensajes.MensajeConectar;

import org.junit.Test;

public class MensajeConectarTest {

	@Test
	public void PruebaMsjConectar() {
		System.out.println("Prueba msj conectar");
		String version = "V1.0";
		MensajeConectar msj = new MensajeConectar(version);
		assertTrue(msj.getVersion() == version);
		msj.setVersion("hola");
		assertTrue(msj.getVersion() != version);
	}

}
