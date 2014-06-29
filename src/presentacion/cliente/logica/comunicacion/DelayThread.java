package presentacion.cliente.logica.comunicacion;

/*
 * DelayThread
 * Contiene �nico metodo delay() que llama a Thread.Sleep
 * Sirve para hacer mas entendible el c�digo
 * Se accede de forma est�tica
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
