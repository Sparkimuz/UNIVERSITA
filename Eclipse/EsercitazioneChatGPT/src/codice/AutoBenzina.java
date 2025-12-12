package codice;

import java.util.Random;

public class AutoBenzina extends Veicolo{
	private final Random random = new Random();
    public AutoBenzina(Coordinate posizione){
        super(posizione);
    }

    @Override
    public Coordinate decidiProssimaDestinazione(){
        int x = random.nextInt(21) - 10;
        int y = random.nextInt(21) - 10;

        return new Coordinate(x, y);

    } 
}
