package presentacion.cliente.visual;

import java.awt.Component;
import javax.swing.JFrame;
import presentacion.cliente.logica.comunicacion.GUISubject;

import java.awt.event.MouseAdapter;
import java.util.HashMap;
import java.util.Map;

public class Ventana {
	private static Ventana GameWindow;
	private static int GridSize;
	private  Map <String,Component> mapaComponents;
	private  JFrame frame;
	private  GUISubject guiSubject;
	private Ventana() {
		guiSubject= new GUISubject();
		GridSize=0;
		mapaComponents= new HashMap<String,Component>();
	}
	
	public static Ventana getInstance(){
		if (GameWindow == null){
			GameWindow= new Ventana();
		}
		return GameWindow;
	}
	
	public JFrame getFrame(){
	return frame;
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public GUISubject getGuiSubject() {
		return guiSubject;
	}
	
	
	public int getGridSize() {
		return GridSize;
	}
	public void setGridSize(int gridSize) {
		GridSize = gridSize;
	}
		
	public void setNewView(){
		if(getInstance().getFrame()!=null){getInstance().getFrame().dispose();}
		JFrame frame= new JFrame();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		getInstance().setFrame(frame);
		getInstance().getFrame().setVisible(true);
	}
	
	public void addComponent(String key, Component value){
		if (mapaComponents.get(key)!=null){
			removeComponent(key);
		}
		mapaComponents.put(key,value);
		if (key.equalsIgnoreCase("fondo")){
			getInstance().getFrame().getContentPane().add(value);
		}
		else{getInstance().getFrame().getContentPane().add(value,0);}
	}
	
	public void removeAdapter(String key){
		Component component=mapaComponents.get(key);
		if (component!=null){
			while(!(component.getMouseListeners().length==0)){
				component.removeMouseListener(component.getMouseListeners()[0]);
			}
			while(!(component.getMouseMotionListeners().length==0)){
				component.removeMouseMotionListener(component.getMouseMotionListeners()[0]);
			}
		}
	}
	public void setAdapter(String key, MouseAdapter adapter){
		mapaComponents.get(key).addMouseListener(adapter);
		mapaComponents.get(key).addMouseMotionListener(adapter);
	}
	
	public void removeComponent(String key){
		if (mapaComponents.get(key)!=null){
			mapaComponents.get(key).setVisible(false);
			getInstance().getFrame().getContentPane().remove(mapaComponents.get(key));
			mapaComponents.remove(key);
		}
		
	}
	
}
