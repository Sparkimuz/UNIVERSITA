```java
public class AcmePizza(){
	private Pizzeria pizzeriaCorrente;
	public void inserisciPizzaNelMenu(String nomePizza, String descrizione, int prezzoUnitario){
		pizzeriaCorrente.inserisciPizzaNelMenu(nomePizza, descrizione, prezzoUnitario);
		}
	}
	
public class Pizzeria{
	private Menu menu;
	public void inserisciPizzaNelMenu(String nomePizza, String descrizione, int prezzoUnitario){
		menu.inserisciPizzaNelMenu(nomePizza, descrizione, prezzoUnitario);
		}
	}

public class Menu{
	
	private Collection<DescrizionePizza> descrizioniPizze;
	public void inserisciPizzaNelMenu(String nomePizza, String descrizione, int prezzoUnitario){
		DescrizionePizza pizza = new DescrizionePizza(nomePizza, descrizione, prezzoUnitario);
		descrizioniPizze.add(pizza);
		}
	}

public class DescrizionePizza{
	private UUID id = UUID.randomUUID(); 
	private String nomePizza;
	private String descrizione;
	private int prezzoUnitario;
	
	public DescrizionePizza(String nomePizza, String descrizione, int prezzoUnitario){
		this.nomePizza  = nomePizza;
		this.descrizione = descrizione
		this.prezzoUnitario = prezzoUnitario
	}

}
```