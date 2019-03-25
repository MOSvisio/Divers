package modele;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Achat {
	static final Scanner input = new Scanner(System.in);
	private String DateHeure;
	private float Tarif;
	
	private HashMap<Produit, Integer> ProduiQuant;
	
	
	public Achat(){
		this.Tarif = 0;
		this.ProduiQuant = new HashMap<>();
	}
	
	public void AjoutAchat(Produit p, int q){
		if(this.ProduiQuant.get(p)==null){
			this.Tarif += (p.getTarif() * q) + (p.getTarif() * q * Tva.getTvaById(p.getId()).getTaux());
			this.ProduiQuant.put(p, q);
		}
	}
	
	public void RetirerAchat(Produit p){
		if(this.ProduiQuant.get(p)!=null){
			this.ProduiQuant.remove(p);
		}
	}
	
	public void Afficher(){
		System.out.println(this.ProduiQuant.toString());
	}
}
