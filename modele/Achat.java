package modele;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Achat {
	static final Scanner input = new Scanner(System.in);
	private String DateHeure;
	private ArrayList<Produit> listProduit;
	private int quantite[];
	
	private HashMap<Produit, Integer> ProduiQuant;
	private float traceTarif;
	
	
	Achat(){
		this.ProduiQuant = new HashMap<>();
	}
	
	public void AjoutAchat(Produit p, int q){
		if(this.ProduiQuant.get(p)==null){
			this.ProduiQuant.put(p, q);
		}
	}
	
	public void RetirerAchat(Produit p){
		if(this.ProduiQuant.get(p)!=null){
			this.ProduiQuant.remove(p);
		}
	}
	
	
	
	
	public void Afficher(){

	}
}
