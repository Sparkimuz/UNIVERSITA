package dist.gui;


import static java.awt.Color.LIGHT_GRAY;

import java.awt.Color;

public interface CostantiGUI {

	/* Dimensione in px di una cella in cui si svolge la simulazione */
	
	static final public int DIM_CELLE = 24;
	
	static final public Color COLORE_BORDO  = LIGHT_GRAY;

	static public String RISORSA_IMMAGINE_BIANCO = "dist/white.png";

	static public String RISORSA_IMMAGINE_ROSSO = "dist/red.png";

	static public String RISORSA_IMMAGINE_MATTONE = "dist/brick.png";

	static public float IMMAGINE_SCALA = 1.2f;

}

