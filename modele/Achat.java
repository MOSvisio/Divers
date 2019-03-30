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
		if(this.ProduiQuant.get(p)==null && p.getStock() > 0){
			q = p.venteTest(q);
			this.setTarif(p.getTarif() * (1 + (Tva.getTvaById(p.getTva()).getTaux()/100.0)) * q);
			this.ProduiQuant.put(p, q);
		}
	}
	
	public void RetirerAchat(Produit p){
		if(this.ProduiQuant.get(p)!=null){
			int q = this.ProduiQuant.get(p);
			this.setTarif(-(p.getTarif() * (1 + (Tva.getTvaById(p.getTva()).getTaux()/100.0)) * q));
			this.ProduiQuant.remove(p);
			p.reapprovisionner(q);
		}
	}
	
	public HashMap<Produit, Integer> getMap(){
		return this.ProduiQuant;
	}
	
	public void Afficher(){
		System.out.println("Commande effectuée à : " + this.getDateHeure() + " Prix total : " + this.getTarif());
		System.out.println(this.ProduiQuant.toString());
	}

	public double getTarif() {
		return Tarif;
	}

	public void setTarif(double d) {
		Tarif += d;
		Tarif = (double) Math.round(Tarif * 100) / 100;
	
	}

	public String getDateHeure() {
		return DateHeure;
	}

	public void setDateHeure(String dateHeure) {
		DateHeure = dateHeure;
	}
}
