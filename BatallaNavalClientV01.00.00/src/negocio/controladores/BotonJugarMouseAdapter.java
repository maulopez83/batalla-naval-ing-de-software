package negocio.controladores;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import presentacion.Ventana;

import negocio.comunicacion.DelayThread;
import negocio.comunicacion.mensajes.MensajeColocar;

public class BotonJugarMouseAdapter extends MouseAdapter implements Serializable{
	private static final long serialVersionUID = 1L;
	ArrayList<ArrayList<Point>> tablero;
	int cantBarcos;
	public BotonJugarMouseAdapter(ArrayList<ArrayList<Point>> tablero, int cantBarcos){
		this.tablero=tablero;
		this.cantBarcos=cantBarcos;
	}
	@Override
	public void mouseClicked (MouseEvent e){
		if(tablero.size()==cantBarcos){
			MensajeColocar msg= new MensajeColocar(tablero);
			Ventana.getInstance().getGuiSubject().sendMsg(msg);	
		}
		else{
			new Thread(new Runnable(){
				public void run(){
				 JFrame frame= Ventana.getInstance().getFrame();
				 JLabel Error = new JLabel();
				 Error.setBounds(0,0,300,20);
				 Error.setText("Error, no se ingresaron todos los barcos");
				 Error.setForeground(Color.RED);
				 frame.getContentPane().add(Error,0);
				 frame.repaint();
				 DelayThread.delay(2000);
				 Error.setVisible(false);
				 frame.getContentPane().remove(Error);
			 }
			}).start();
		}
	}
}
