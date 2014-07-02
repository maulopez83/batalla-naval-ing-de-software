package negocio.comunicacion.mensajes.elementosgraficos;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.io.Serializable;

public class ElementoGUI implements Serializable {

	private static final long serialVersionUID = 1L;
	private byte[] imagen;
	private Rectangle bounds;
	private String text;
	private MouseAdapter adapter;
	private String hashKey;
	public ElementoGUI(String hashKey){
		this.text=null;
		this.adapter=null;
		this.imagen=null;
		this.bounds=null;
		this.setHashKey(hashKey);
	}
	
	public byte[] getIcon() throws NullPointerException {
		if (imagen==null){throw new NullPointerException("Exception: La imagen es nula");}
		return imagen;
	}
	public void setIcon(byte[] imagen) {
		this.imagen = imagen;
	}
	public Rectangle getBounds() {
		return bounds;
	}
	public int getX() {
		return (int)bounds.getX();
	}
	public int getY() {
		return (int)bounds.getY();
	}
	public int getWidth() {
		return (int)bounds.getWidth();
	}
	public int getHeight() {
		return (int)bounds.getHeight();
	}
	public void setSize(int w,int h){
		this.bounds.setSize(w,h);
	}
	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}
	public void setBounds(int x,int y,int w,int h) {
		this.bounds = new Rectangle(x,y,w,h);
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public void setAdapter(MouseAdapter adapter) {
		this.adapter = adapter;
	}

	public MouseAdapter getAdapter() {
		return adapter;
	}

	public void setHashKey(String hashKey) {
		this.hashKey = hashKey;
	}

	public String getHashKey() {
		return hashKey;
	}
	
	
}
