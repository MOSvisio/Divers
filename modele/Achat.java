package modele;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;


public class Achat {
	static final Scanner input = new Scanner(System.in);
	
	private String DateHeure;
	private double Tarif;
	private HashMap<Produit, Integer> ProduiQuant;
	
	
	public Achat(){
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		this.setDateHeure(sdf.format(new Date()));
		this.setTarif(0);
		this.ProduiQuant = new HashMap<>();
	}
	
	public void AjoutAchat(Produit p, int q){
		if(this.ProduiQuant.get(p)==null){
			this.setTarif(this.getTarif() + ((p.getTarif() * q) + (p.getTarif() * q * Tva.getTvaById(p.getId()).getTaux())));
			this.ProduiQuant.put(p, q);
		}
	}
	
	public void RetirerAchat(Produit p){
		if(this.ProduiQuant.get(p)!=null){
			int q = this.ProduiQuant.get(p);
			this.setTarif(this.getTarif() - ((p.getTarif() * q) + (p.getTarif() * q * Tva.getTvaById(p.getId()).getTaux())));
			this.ProduiQuant.remove(p);
		}
	}
	
	public void Afficher(){
		System.out.println("Commande effectu�e � : " + this.getDateHeure() + " Prix total : " + this.getTarif());
		System.out.println(this.ProduiQuant.toString());
	}

	public double getTarif() {
		return Tarif;
	}

	public void setTarif(double d) {
		Tarif = d;
	}

	public String getDateHeure() {
		return DateHeure;
	}

	public void setDateHeure(String dateHeure) {
		DateHeure = dateHeure;
	}
}
