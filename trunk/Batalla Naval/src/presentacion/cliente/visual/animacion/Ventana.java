package presentacion.cliente.visual.animacion;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ventana {

	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1380, 820);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel t1_0_0 = new JLabel("");
		t1_0_0.setBounds(150, 100, 50, 50);
		frame.getContentPane().add(t1_0_0);
		
		JLabel t1_0_1 = new JLabel("");
		t1_0_1.setBounds(200, 100, 50, 50);
		frame.getContentPane().add(t1_0_1);
		
		JLabel t1_0_2 = new JLabel("");
		t1_0_2.setBounds(250, 100, 50, 50);
		frame.getContentPane().add(t1_0_2);
		
		JLabel t1_0_3 = new JLabel("");
		t1_0_3.setBounds(300, 100, 50, 50);
		frame.getContentPane().add(t1_0_3);
		
		JLabel t1_0_4 = new JLabel("");
		t1_0_4.setBounds(350, 100, 50, 50);
		frame.getContentPane().add(t1_0_4);
		
		JLabel t1_0_5 = new JLabel("");
		t1_0_5.setBounds(400, 100, 50, 50);
		frame.getContentPane().add(t1_0_5);
		
		JLabel t1_0_6 = new JLabel("");
		t1_0_6.setBounds(450, 100, 50, 50);
		frame.getContentPane().add(t1_0_6);
		
		JLabel t1_0_7 = new JLabel("");
		t1_0_7.setBounds(500, 100, 50, 50);
		frame.getContentPane().add(t1_0_7);
		
		JLabel t1_0_8 = new JLabel("");
		t1_0_8.setBounds(550, 100, 50, 50);
		frame.getContentPane().add(t1_0_8);
		
		JLabel t1_0_9 = new JLabel("");
		t1_0_9.setBounds(600, 100, 50, 50);
		frame.getContentPane().add(t1_0_9);
		
		JLabel t1_1_0 = new JLabel("");
		t1_1_0.setBounds(150, 150, 50, 50);
		frame.getContentPane().add(t1_1_0);
		
		JLabel t1_1_1 = new JLabel("");
		t1_1_1.setBounds(200, 150, 50, 50);
		frame.getContentPane().add(t1_1_1);
		
		JLabel t1_1_2 = new JLabel("");
		t1_1_2.setBounds(250, 150, 50, 50);
		frame.getContentPane().add(t1_1_2);
		
		JLabel t1_1_3 = new JLabel("");
		t1_1_3.setBounds(300, 150, 50, 50);
		frame.getContentPane().add(t1_1_3);
		
		JLabel t1_1_4 = new JLabel("");
		t1_1_4.setBounds(350, 150, 50, 50);
		frame.getContentPane().add(t1_1_4);
		
		JLabel t1_1_5 = new JLabel("");
		t1_1_5.setBounds(400, 150, 50, 50);
		frame.getContentPane().add(t1_1_5);
		
		JLabel t1_1_6 = new JLabel("");
		t1_1_6.setBounds(450, 150, 50, 50);
		frame.getContentPane().add(t1_1_6);
		
		JLabel t1_1_7 = new JLabel("");
		t1_1_7.setBounds(500, 150, 50, 50);
		frame.getContentPane().add(t1_1_7);
		
		JLabel t1_1_8 = new JLabel("");
		t1_1_8.setBounds(550, 150, 50, 50);
		frame.getContentPane().add(t1_1_8);
		
		JLabel t1_1_9 = new JLabel("");
		t1_1_9.setBounds(600, 150, 50, 50);
		frame.getContentPane().add(t1_1_9);
		
		JLabel t1_2_0 = new JLabel("");
		t1_2_0.setBounds(150, 200, 50, 50);
		frame.getContentPane().add(t1_2_0);
		
		JLabel t1_2_1 = new JLabel("");
		t1_2_1.setBounds(200, 200, 50, 50);
		frame.getContentPane().add(t1_2_1);
		
		JLabel t1_2_2 = new JLabel("");
		t1_2_2.setBounds(250, 200, 50, 50);
		frame.getContentPane().add(t1_2_2);
		
		JLabel t1_2_3 = new JLabel("");
		t1_2_3.setBounds(300, 200, 50, 50);
		frame.getContentPane().add(t1_2_3);
		
		JLabel t1_2_4 = new JLabel("");
		t1_2_4.setBounds(350, 200, 50, 50);
		frame.getContentPane().add(t1_2_4);
		
		JLabel t1_2_5 = new JLabel("");
		t1_2_5.setBounds(400, 200, 50, 50);
		frame.getContentPane().add(t1_2_5);
		
		JLabel t1_2_6 = new JLabel("");
		t1_2_6.setBounds(450, 200, 50, 50);
		frame.getContentPane().add(t1_2_6);
		
		JLabel t1_2_7 = new JLabel("");
		t1_2_7.setBounds(500, 200, 50, 50);
		frame.getContentPane().add(t1_2_7);
		
		JLabel t1_2_8 = new JLabel("");
		t1_2_8.setBounds(550, 200, 50, 50);
		frame.getContentPane().add(t1_2_8);
		
		JLabel t1_2_9 = new JLabel("");
		t1_2_9.setBounds(600, 200, 50, 50);
		frame.getContentPane().add(t1_2_9);
		
		JLabel t1_3_0 = new JLabel("");
		t1_3_0.setBounds(150, 250, 50, 50);
		frame.getContentPane().add(t1_3_0);
		
		JLabel t1_3_1 = new JLabel("");
		t1_3_1.setBounds(200, 250, 50, 50);
		frame.getContentPane().add(t1_3_1);
		
		JLabel t1_3_2 = new JLabel("");
		t1_3_2.setBounds(250, 250, 50, 50);
		frame.getContentPane().add(t1_3_2);
		
		JLabel t1_3_3 = new JLabel("");
		t1_3_3.setBounds(300, 250, 50, 50);
		frame.getContentPane().add(t1_3_3);
		
		JLabel t1_3_4 = new JLabel("");
		t1_3_4.setBounds(350, 250, 50, 50);
		frame.getContentPane().add(t1_3_4);
		
		JLabel t1_3_5 = new JLabel("");
		t1_3_5.setBounds(400, 250, 50, 50);
		frame.getContentPane().add(t1_3_5);
		
		JLabel t1_3_6 = new JLabel("");
		t1_3_6.setBounds(450, 250, 50, 50);
		frame.getContentPane().add(t1_3_6);
		
		JLabel t1_3_7 = new JLabel("");
		t1_3_7.setBounds(500, 250, 50, 50);
		frame.getContentPane().add(t1_3_7);
		
		JLabel t1_3_8 = new JLabel("");
		t1_3_8.setBounds(550, 250, 50, 50);
		frame.getContentPane().add(t1_3_8);
		
		JLabel t1_3_9 = new JLabel("");
		t1_3_9.setBounds(600, 250, 50, 50);
		frame.getContentPane().add(t1_3_9);
		
		JLabel t1_4_0 = new JLabel("");
		t1_4_0.setBounds(150, 300, 50, 50);
		frame.getContentPane().add(t1_4_0);
		
		JLabel t1_4_1 = new JLabel("");
		t1_4_1.setBounds(200, 300, 50, 50);
		frame.getContentPane().add(t1_4_1);
		
		JLabel t1_4_2 = new JLabel("");
		t1_4_2.setBounds(250, 300, 50, 50);
		frame.getContentPane().add(t1_4_2);
		
		JLabel t1_4_3 = new JLabel("");
		t1_4_3.setBounds(300, 300, 50, 50);
		frame.getContentPane().add(t1_4_3);
		
		JLabel t1_4_4 = new JLabel("");
		t1_4_4.setBounds(350, 300, 50, 50);
		frame.getContentPane().add(t1_4_4);
		
		JLabel t1_4_5 = new JLabel("");
		t1_4_5.setBounds(400, 300, 50, 50);
		frame.getContentPane().add(t1_4_5);
		
		JLabel t1_4_6 = new JLabel("");
		t1_4_6.setBounds(450, 300, 50, 50);
		frame.getContentPane().add(t1_4_6);
		
		JLabel t1_4_7 = new JLabel("");
		t1_4_7.setBounds(500, 300, 50, 50);
		frame.getContentPane().add(t1_4_7);
		
		JLabel t1_4_8 = new JLabel("");
		t1_4_8.setBounds(550, 300, 50, 50);
		frame.getContentPane().add(t1_4_8);
		
		JLabel t1_4_9 = new JLabel("");
		t1_4_9.setBounds(600, 300, 50, 50);
		frame.getContentPane().add(t1_4_9);
		
		JLabel t1_5_0 = new JLabel("");
		t1_5_0.setBounds(150, 350, 50, 50);
		frame.getContentPane().add(t1_5_0);
		
		JLabel t1_5_1 = new JLabel("");
		t1_5_1.setBounds(200, 350, 50, 50);
		frame.getContentPane().add(t1_5_1);
		
		JLabel t1_5_2 = new JLabel("");
		t1_5_2.setBounds(250, 350, 50, 50);
		frame.getContentPane().add(t1_5_2);
		
		JLabel t1_5_3 = new JLabel("");
		t1_5_3.setBounds(300, 350, 50, 50);
		frame.getContentPane().add(t1_5_3);
		
		JLabel t1_5_4 = new JLabel("");
		t1_5_4.setBounds(350, 350, 50, 50);
		frame.getContentPane().add(t1_5_4);
		
		JLabel t1_5_5 = new JLabel("");
		t1_5_5.setBounds(400, 350, 50, 50);
		frame.getContentPane().add(t1_5_5);
		
		JLabel t1_5_6 = new JLabel("");
		t1_5_6.setBounds(450, 350, 50, 50);
		frame.getContentPane().add(t1_5_6);
		
		JLabel t1_5_7 = new JLabel("");
		t1_5_7.setBounds(500, 350, 50, 50);
		frame.getContentPane().add(t1_5_7);
		
		JLabel t1_5_8 = new JLabel("");
		t1_5_8.setBounds(550, 350, 50, 50);
		frame.getContentPane().add(t1_5_8);
		
		JLabel t1_5_9 = new JLabel("");
		t1_5_9.setBounds(600, 350, 50, 50);
		frame.getContentPane().add(t1_5_9);
		
		JLabel label_20 = new JLabel("");
		label_20.setBounds(150, 400, 50, 50);
		frame.getContentPane().add(label_20);
		
		JLabel label_21 = new JLabel("");
		label_21.setBounds(200, 400, 50, 50);
		frame.getContentPane().add(label_21);
		
		JLabel label_22 = new JLabel("");
		label_22.setBounds(250, 400, 50, 50);
		frame.getContentPane().add(label_22);
		
		JLabel label_23 = new JLabel("");
		label_23.setBounds(300, 400, 50, 50);
		frame.getContentPane().add(label_23);
		
		JLabel label_24 = new JLabel("");
		label_24.setBounds(350, 400, 50, 50);
		frame.getContentPane().add(label_24);
		
		JLabel label_25 = new JLabel("");
		label_25.setBounds(400, 400, 50, 50);
		frame.getContentPane().add(label_25);
		
		JLabel label_26 = new JLabel("");
		label_26.setBounds(450, 400, 50, 50);
		frame.getContentPane().add(label_26);
		
		JLabel label_27 = new JLabel("");
		label_27.setBounds(500, 400, 50, 50);
		frame.getContentPane().add(label_27);
		
		JLabel label_28 = new JLabel("");
		label_28.setBounds(550, 400, 50, 50);
		frame.getContentPane().add(label_28);
		
		JLabel label_29 = new JLabel("");
		label_29.setBounds(600, 400, 50, 50);
		frame.getContentPane().add(label_29);
		
		JLabel label_30 = new JLabel("");
		label_30.setBounds(150, 450, 50, 50);
		frame.getContentPane().add(label_30);
		
		JLabel label_31 = new JLabel("");
		label_31.setBounds(200, 450, 50, 50);
		frame.getContentPane().add(label_31);
		
		JLabel label_32 = new JLabel("");
		label_32.setBounds(250, 450, 50, 50);
		frame.getContentPane().add(label_32);
		
		JLabel label_33 = new JLabel("");
		label_33.setBounds(300, 450, 50, 50);
		frame.getContentPane().add(label_33);
		
		JLabel label_34 = new JLabel("");
		label_34.setBounds(350, 450, 50, 50);
		frame.getContentPane().add(label_34);
		
		JLabel label_35 = new JLabel("");
		label_35.setBounds(400, 450, 50, 50);
		frame.getContentPane().add(label_35);
		
		JLabel label_36 = new JLabel("");
		label_36.setBounds(450, 450, 50, 50);
		frame.getContentPane().add(label_36);
		
		JLabel label_37 = new JLabel("");
		label_37.setBounds(500, 450, 50, 50);
		frame.getContentPane().add(label_37);
		
		JLabel label_38 = new JLabel("");
		label_38.setBounds(550, 450, 50, 50);
		frame.getContentPane().add(label_38);
		
		JLabel label_39 = new JLabel("");
		label_39.setBounds(600, 450, 50, 50);
		frame.getContentPane().add(label_39);
		
		JLabel Fondo = new JLabel("");
		Fondo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			JLabel aux =(JLabel) frame.getContentPane().getComponentAt(e.getPoint());
			aux.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/cliente/visual/imagen/Cruz Averiado.png")));
			}
		});
		Fondo.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/cliente/visual/imagen/Tablero2.png")));
		Fondo.setBounds(0, 0, 1280, 727);
		frame.getContentPane().add(Fondo);
		
	}
	
}
