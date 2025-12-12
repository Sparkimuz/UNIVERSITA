public class DirezioneTest{


    @Test
    public void oppostaTest(){
        assertEquals("Non è la direzione opposta", Direzione.SUD, Direzione.opposta(Direzione.NORD));
        assertEquals("Non è la direzione opposta", Direzione.NORD, Direzione.opposta(Direzione.SUD));
        assertEquals("Non è la direzione opposta", Direzione.OVEST, Direzione.opposta(Direzione.EST));
        assertEquals("Non è la direzione opposta", Direzione.EST, Direzione.opposta(Direzione.OVEST));
    } 

    @Test
    public void spostaTest(){
        Coordinate Punto = new Coordinate(10, 20);
        Coordinate puntoSpostato = Direzione.NORD.sposta(Punto);

        assertEquals("Non si è spostato nella direzione giusta", 21, puntoSpostato.getY());
        assertEquals("Non si è spostato nella direzione giusta", 10, puntoSpostato.getX());

        Coordinate puntoSpostato = Direzione.EST.sposta(Punto);

        assertEquals("Non si è spostato nella direzione giusta", 21, puntoSpostato.getY());
        assertEquals("Non si è spostato nella direzione giusta", 11, puntoSpostato.getX());

    }  
}