package codice;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Simulazione {
    private static final Random random = new Random();
    private static volatile boolean inputRicevuto = false; // Variabile condivisa tra i thread

    public static void main(String[] args) {
        final List<EssereVivente> listaEsseriViventi = new ArrayList<EssereVivente>();
        
        // Popola la lista degli esseri viventi
        listaEsseriViventi.add(new Persona(new Coordinate(0, 0)));
        listaEsseriViventi.add(new Animale(new Coordinate(1, 1)));
        listaEsseriViventi.add(new Persona(new Coordinate(0, -1)));
        listaEsseriViventi.add(new Animale(new Coordinate(3, 2)));
        listaEsseriViventi.add(new Persona(new Coordinate(2, 2)));
        listaEsseriViventi.add(new Animale(new Coordinate(0, 3)));

        // Crea un thread per monitorare l'input dell'utente
        Thread inputThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Premi un tasto e poi Invio per interrompere la simulazione...");
                scanner.nextLine(); // Attende un input
                inputRicevuto = true; // Imposta il flag a true
                scanner.close();
            }
        });

        // Crea un thread per eseguire la simulazione
        Thread simulazioneThread = new Thread(new Runnable() {
            @Override
            public void run() {
                simula(listaEsseriViventi, 100);
            }
        });

        // Avvia entrambi i thread
        inputThread.start();
        simulazioneThread.start();

        // Attende il completamento della simulazione
        try {
            simulazioneThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Stampa le posizioni finali
        System.out.println("Posizioni finali degli esseri viventi:");
        for (EssereVivente essere : listaEsseriViventi) {
            System.out.printf("Posizione finale: (%d, %d)%n", 
                essere.getPosizione().getX(), 
                essere.getPosizione().getY()
            );
        }
    }

    public static void simula(List<EssereVivente> listaEsseriViventi, int passi) {
        Direzione dir = new Direzione(0, 0);

        for (int j = 0; j < passi; j++) {
            if (inputRicevuto) {
                // Interrompe la simulazione se l'input è stato ricevuto
                System.out.println("Simulazione interrotta. Posizioni intermedie:");
                for (EssereVivente essere : listaEsseriViventi) {
                    System.out.printf("Posizione Intermedia: (%d, %d)%n", 
                        essere.getPosizione().getX(), 
                        essere.getPosizione().getY()
                    );
                }
                break;
            }

            // Esegue un passo della simulazione
            for (EssereVivente essere : listaEsseriViventi) {
                int xCasuale = random.nextInt(3) - 1;
                int yCasuale = random.nextInt(3) - 1;
                dir.setDx(xCasuale);
                dir.setDy(yCasuale);
                essere.muovi(dir);
            }

            // Pausa tra i passi per rallentare la simulazione
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}