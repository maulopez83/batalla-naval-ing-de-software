package cliente.logica.comunicacion;

/*
 * DelayThread
 * Contiene único metodo delay() que llama a Thread.Sleep
 * Sirve para hacer mas entendible el código
 * Se accede de forma estática
 */
public class DelayThread {
	public static void delay(int milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
