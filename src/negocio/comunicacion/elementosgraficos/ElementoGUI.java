package negocio.comunicacion.elementosgraficos;

import java.awt.Component;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ElementoGUI implements Serializable {

	private static final long serialVersionUID = 1L;
	private byte[] imagen;
	private Rectangle bounds;
	private String text;
	private MouseAdapter adapter;
	
	public ElementoGUI(){
		this.text=null;
		this.adapter=null;
		this.imagen=null;
		this.bounds=null;
	}
	
	public byte[] getIcon() throws NullPointerException {
		if (imagen==null){throw new NullPointerException();}
		return imagen;
	}
	public void setIcon(byte[] imagen) {
		this.imagen = imagen;
		System.out.println("Largo: " +imagen.length);
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
	
	
}
