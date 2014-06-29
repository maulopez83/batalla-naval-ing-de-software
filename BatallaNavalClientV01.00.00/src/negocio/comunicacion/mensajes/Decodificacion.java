package negocio.comunicacion.mensajes;

import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import presentacion.cliente.logica.comunicacion.DelayThread;
import presentacion.cliente.visual.Ventana;


import negocio.comunicacion.elementosgraficos.ElementoGUI;

/*
 * Patron Strategy:
 * Esta interfaz declara el metodo decodificar.
 * es implementada por distintas clases que señalan tipos de Mensaje
 * Esto sirve para que cada Mensaje se decodifique de una forma especifica
 * y su implementación este oculta.
 * 
 */

public interface Decodificacion extends Serializable {
	void decodificar(Mensaje m);
}
/*
 * Disparo - implements Decodificación
 * Clase con el metodo para decodificar mensajes de Tipo Disparo
 * 
 */
class Disparo implements Decodificacion {
	private static final long serialVersionUID = 1L;
	public void decodificar(Mensaje m){}
}
/*
 * Desconectar - implements Decodificación
 * Clase con el metodo para decodificar mensajes de Tipo Desconectar
 * 
 */
class Desconectar implements Decodificacion{
	private static final long serialVersionUID = 1L;
	public void decodificar(Mensaje m){
	}
}
/*
 * Conectar - implements Decodificación
 * Clase con el metodo para decodificar mensajes de Tipo Conectar
 * Conectaa
 */
class Conectar implements Decodificacion{
	private static final long serialVersionUID = 1L;
	/*
	 * decodificar()
	 * returns: String? (deberia ser void capaz dsp lo vemos)
	 * params: Mensaje m
	 * DEBE DECODIFICAR LO QUE PASA CUANDO LLEGA MENSAJE DE CONECTAR, FALTA IMPLEMENTAR BIEN 
	 */
	public void decodificar(Mensaje m){}
}

/*
 * Colocar - implements Decodificación
 * Clase con el metodo para decodificar mensajes de Tipo Colocar
 * 
 */
class Colocar implements Decodificacion{
	private static final long serialVersionUID = 1L;
	/*
	 * decodificar()
	 * returns: String? (deberia ser void capaz dsp lo vemos)
	 * params: Mensaje m
	 * DEBE DECODIFICAR LO QUE PASA CUANDO LLEGA MENSAJE DE COLOCAR, FALTA IMPLEMENTAR BIEN 
	 */
	public void decodificar(Mensaje m){}
	
}

class MGUI implements Decodificacion{
		private static final long serialVersionUID = 1L;
		/*
		 * decodificar()
		 * returns: String? (deberia ser void capaz dsp lo vemos)
		 * params: Mensaje m
		 * DEBE DECODIFICAR LO QUE PASA EN EL CLIENTE CUANDO LLEGA UNA IMAGEN PARA PONER EN GUI, FALTA IMPLEMENTAR BIEN 
		 */
		public void decodificar(Mensaje m){
			MensajeGUI msg= (MensajeGUI) m;
			Ventana GameWindow = Ventana.getInstance();
			if(msg.isNewWindow()){
				GameWindow.setNewView();
			}
			if(msg.getFrameBounds()!=null){
				GameWindow.getFrame().setBounds(msg.getFrameBounds());
			}
			
			for(ElementoGUI eg : msg.getElementos()){
				GameWindow.addComponent(eg.getHashKey(),createLabel(eg));
				GameWindow.setAdapter(eg.getHashKey(), eg.getAdapter());
			}
			for(String hashCode : msg.getElementsToRemove()){
				GameWindow.removeComponent(hashCode);
			}
			for(String hashCode : msg.getAdaptersToRemove()){
				GameWindow.removeAdapter(hashCode);
			}
			
			GameWindow.getFrame().repaint();
		}
		
		public JLabel createLabel(ElementoGUI eg){
			JLabel newLabel= new JLabel();
			newLabel.setText(eg.getText());
			newLabel.setBounds(eg.getBounds());
			try{
				newLabel.setIcon(new ImageIcon(eg.getIcon()));
			} catch(Exception e){System.out.println(e.getMessage());};
			return newLabel;
		}
}

class MTurno implements Decodificacion{
	private static final long serialVersionUID = 1L;

	public void decodificar(Mensaje m) {
		MensajeTurno msg = (MensajeTurno) m;
		Ventana.getInstance().setTurno(msg.isTurno());
		if(msg.getToast()!=null){
			new Thread(new ToastThread(msg.getToast())).start();
		}
	}	
	class ToastThread implements Runnable{
		private String toastText;
		public ToastThread(String toastText){
			this.toastText=toastText;
		}
		public void run() {
			JLabel label = new JLabel(toastText);
			label.setSize(200, 20);
			Ventana.getInstance().addComponent("toast", label);
			Ventana.getInstance().getFrame().repaint();
			DelayThread.delay(5000);
			Ventana.getInstance().removeComponent("toast");
		}
		
	}

}
		

