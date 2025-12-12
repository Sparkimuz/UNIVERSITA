import java.util.Random;

public abstract class Veicolo{
    protected Coordinate posizione;

    public Veicolo(Coordinate posizione){
        this.posizione = posizione;
    }

    public Coordinate getPosizione(){
        return this.posizione;
    }

    public abstract void muovi(Direzione dir){
        this.posizione = dir.sposta(this.posizione);
    }

    public abstract Coordinate decidiProssimaDestinazione(){
    }

    public void simulaMovimento(Coordinate destinazione){
        for (int i = 0; i < 10; i++) {
            if (destinazione.getX() > this.posizione.getX()) {
                this.muovi(Direzione.EST);
            } else if (destinazione.getX() < this.posizione.getX()) {
                this.muovi(Direzione.OVEST);
            }
    
            if (destinazione.getY() > this.posizione.getY()) {
                this.muovi(Direzione.NORD);
            } else if (destinazione.getY() < this.posizione.getY()) {
                this.muovi(Direzione.SUD);
            }
            
            // Se il veicolo ha raggiunto la destinazione, interrompi il ciclo
            if (this.posizione.equals(destinazione)) {
                break;
            }
    }

}

public class AutoElettrica extends Veicolo{
    private static final Random random = new Random();
    public AutoElettrica(Coordinate posizione){
        super(posizione);
    }
    @Override
    public abstract Coordinate decidiProssimaDestinazione(){
        int x = random.nextInt(11) - 5;
        int y = random.nextInt(11) - 5;

        return new Coordinate(x, y);
    } 

}

public class AutoBenzina extends Veicolo{
    public AutoBenzina(Coordinate posizione){
        super(posizione);
    }

    @Override
    public abstract Coordinate decidiProssimaDestinazione(){
        int x = random.nextInt(21) - 10;
        int y = random.nextInt(21) - 10;

        return new Coordinate(x, y);

    } 
}











