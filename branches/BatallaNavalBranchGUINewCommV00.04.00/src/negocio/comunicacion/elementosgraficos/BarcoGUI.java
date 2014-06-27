package negocio.comunicacion.elementosgraficos;

import java.awt.Point;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BarcoGUI implements Serializable{
	private static final long serialVersionUID = 1L;
	private ImageIcon ImgVertical;
	private ImageIcon ImgHorizontal;
	private int width;
	private int height;
	private JLabel GUIElement;
	public BarcoGUI(int width , int height, Point Position){
		this.setHeight(height);
		this.setWidth(width);
		GUIElement = new JLabel();
		
	}

	public void setImgVertical(ImageIcon imgVertical) {
		ImgVertical = imgVertical;
	}

	public ImageIcon getImgVertical() {
		return ImgVertical;
	}

	public void setImgHorizontal(ImageIcon imgHorizontal) {
		ImgHorizontal = imgHorizontal;
	}

	public ImageIcon getImgHorizontal() {
		return ImgHorizontal;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getWidth() {
		return width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	public JLabel getGUIElement() {
		return GUIElement;
	}
	
}

