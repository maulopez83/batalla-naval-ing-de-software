package ing.de.software.batallanaval.logica.comunicacion;

public class DelayThread {
	public static void delay(int milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
