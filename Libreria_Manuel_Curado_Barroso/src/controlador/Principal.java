package controlador;

import java.awt.EventQueue;
import vista.UI;

public class Principal {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try {
					ParaUI frame = new ParaUI();
					frame.setVisible(true);
				}	catch(Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
