package prop;

import prop.gui.GUI;
import prop.sim.Coordinate;
import prop.sim.Simulatore;


/**
 * Eseguire il metodo {@linkplain #main(String[])} 
 * di questa classe per lanciare l'applicazione.
 */
public class Main {

	public static void main(String[] args) throws Exception {
//		Coordinate c1 = new Coordinate(20, 1);
//		Coordinate c2 = new Coordinate(10, 30);
//		double dis = Coordinate.distanza(c1, c2);
		
//		System.out.printf("Distanza tra le due coordinate: %f", dis);
		final Simulatore simulatore = new Simulatore();
		final GUI gui = new GUI(simulatore);
		gui.initControlliDaTastiera(simulatore);
		simulatore.setGUI(gui);
		simulatore.simula();
	}

}
