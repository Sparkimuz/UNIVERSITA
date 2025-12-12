package codice;

import java.util.Random;

public class AutoElettrica extends Veicolo{
    private final Random random = new Random();
    public AutoElettrica(Coordinate posizione){
        super(posizione);
    }
    @Override
    public Coordinate decidiProssimaDestinazione(){
        int x = random.nextInt(11) - 5;
        int y = random.nextInt(11) - 5;

        return new Coordinate(x, y);
    } 

}