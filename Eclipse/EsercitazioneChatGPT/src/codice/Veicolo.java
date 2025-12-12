package codice;

public abstract class Veicolo{
    protected Coordinate posizione;

    public Veicolo(Coordinate posizione){
        this.posizione = posizione;
    }

    public Coordinate getPosizione(){
        return this.posizione;
    }

    public void muovi(Direzione dir){
        dir.sposta(this.posizione);
    }

    public abstract Coordinate decidiProssimaDestinazione();

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




}
