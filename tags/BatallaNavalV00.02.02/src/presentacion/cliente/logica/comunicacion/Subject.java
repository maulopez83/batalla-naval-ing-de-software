package presentacion.cliente.logica.comunicacion;

public interface Subject {
	void register(Observer o);
	void unregister(Observer o);
	void notifyObservers();
}
