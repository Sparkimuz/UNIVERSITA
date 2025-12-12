import java.util.*;
import EssereVivente;

public class Simulazione{
    


    public static void main(String[] args) {
        List<EssereVivente> listaEsseriViventi = new ArrayList<>();
        List<Coordinate> listaPosizioni = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        simula(listaEsseriViventi, scanner, 10);
        
        for(EssereVivente essere: ListaEsseriViventi){
            System.out.printf("Posizione finale: (%d, %d)%n", essere.getPosizione().getX(), essere.getPosizione().getY());
        }
        scanner.close();
        }

    public Coordinate simula(List<EssereVivente> ListaEsseriViventi, int passi, Scanner scanner){
        private static final Random random = new Random();
        Direzione dir = new Direzione(0,0);
        boolean InputRicevuto = false;

        for(int i=0, i<passi, i++){
            for(EssereVivente essere : ListaEsseriViventi){
                dir.setDirezione(random.nextInt(3)-1, random.nextInt(3)-1);
                essere.muovi(dir);

                if(scanner.hasNextLine()){
                    scanner.nextLine();
                    for(EssereVivente essere: ListaEsseriViventi){
                        System.out.printf("Posizione Intermedia: (%d, %d)%n", essere.getPosizione().getX(), essere.getPosizione().getY());
                    }
                    InputRicevuto = true;
                }
                if(InputRicevuto)
                    break;
            }
        }
    }
}