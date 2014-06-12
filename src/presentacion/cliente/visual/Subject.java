package presentacion.cliente.visual;

public interface Subject {
	void register(Observer o);
	void unregister(Observer o);
	void notifyObservers();
}
