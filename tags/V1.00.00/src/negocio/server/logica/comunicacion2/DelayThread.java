package negocio.server.logica.comunicacion2;

public class DelayThread {
	public static void delay(int milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
