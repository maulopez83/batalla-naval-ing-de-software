package negocio.comunicacion.elementosgraficos;

import java.awt.Point;

import javax.swing.ImageIcon;

import datos.server.datos.Paths;


public class DestructorGUI extends BarcoGUI {
	private static final long serialVersionUID = 1L;

	public DestructorGUI(Point position){
		super(1,3,position);
		ImageIcon horizontal= new ImageIcon(Paths.getImgDestructorH());
		ImageIcon vertical= new ImageIcon(Paths.getImgDestructorV());
		setImgHorizontal(horizontal);
		setImgVertical(vertical);
		}

}
