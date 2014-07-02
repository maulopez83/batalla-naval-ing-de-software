package negocio.comunicacion.mensajes;

import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;

import negocio.comunicacion.mensajes.elementosgraficos.ElementoGUI;

public class MensajeGUI extends Mensaje implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<ElementoGUI> elementsToAdd;
	private Rectangle frameBounds;
	private boolean newWindow;
	private ArrayList<String> elementsToRemove;
	private ArrayList<String> adaptersToRemove;
	public MensajeGUI(){
		super();
		setType(new MGUI());
		this.elementsToAdd=new ArrayList<ElementoGUI>();
		this.elementsToRemove=(new ArrayList<String>());
		this.adaptersToRemove=new ArrayList<String>();
		frameBounds=null;
		newWindow=false;
	}
	
	public boolean isNewWindow() {
		return newWindow;
	}

	public void setNewWindow(boolean newWindow) {
		this.newWindow = newWindow;
	}

	public ArrayList<ElementoGUI> getElementos() {
		return elementsToAdd;
	}
	public void addElemento(ElementoGUI elemento) {
		elementsToAdd.add(elemento);
	}
	public void addElementToRemove(String hashCode) {
		elementsToRemove.add(hashCode);
	}
	public void addAdapterToRemove(String hashCode) {
		adaptersToRemove.add(hashCode);
	}
	public Rectangle getFrameBounds() {
		return frameBounds;
	}

	public void setFrameBounds(Rectangle frameBounds) {
		this.frameBounds = frameBounds;
	}

	public ArrayList<String> getAdaptersToRemove() {
		return adaptersToRemove;
	}

	public ArrayList<String> getElementsToRemove() {
		return elementsToRemove;
	}

	
}
