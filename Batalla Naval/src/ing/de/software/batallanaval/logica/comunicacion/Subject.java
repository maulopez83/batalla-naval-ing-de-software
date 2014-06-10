package ing.de.software.batallanaval.logica.comunicacion;

public interface Subject {
	void register(Observer o);
	void unregister(Observer o);
	void notifyObservers();
}
