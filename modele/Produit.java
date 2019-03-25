package modele;

import dao.ProduitDAO;
import dao.TvaDAO;

public class Produit implements Comparable<Produit>{
	
	private ProduitDAO dao;
	private TvaDAO daotva;
	private int id;
	private String nom;
	private double tarif;
	private int stock;
	private int tva;
	
	public Produit(String nom, double tarif, int stock, int tva) {
		dao = ProduitDAO.getInstance();
		this.nom = nom;
		this.tarif = tarif;
		this.stock = stock;
		this.tva = tva;
		/*dao.create(this);*/
	}

	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	public double getTarif() {return tarif;}
	public void setTarif(double tarif) {this.tarif = tarif;}
	public int getStock() {return stock;}
	
	public void setStock(int stock) {
		this.stock = stock;
		dao.update(this);
	}
	
	public int getTva() {return tva;}
	public void setTva(int tva) {this.tva = tva;}

	public String toString(){
		daotva = TvaDAO.getInstance();
		return "id : "  + this.id + " nom : " + this.nom + " stock disponible : " + this.stock + " prix : " + this.tarif + " taux de TVA : "; 
	}
	
	public void reapprovisionner(int rea){
		if(rea > 0)
			setStock(getStock() + rea);
			dao.update(this);
	}
	
	public void modifierProduit(int id, String nom, double tarif, int stock, int tva){
		setNom(nom);
		setTarif(tarif);
		setStock(stock);
		setTva(tva);
		dao.update(this);
	}

	public int vente(int v){
		if(this.stock >= v && v>0){
			setStock(this.stock-v);
			return v;
		} else if (this.stock < v && v > 0){
			v = v - (v-this.stock);
			System.out.println("il n'y avait que : " + this.stock + " produits disponibles");
			setStock(this.stock-v);
			return v;
		} else{
			System.out.println("Stock indisponible");
			return 0;
		}
	}

	@Override
	public int compareTo(Produit produit) {
        //write code here for compare name
		return this.getNom().compareTo(produit.getNom());
    }

	public boolean equals(Object o){
		if(o instanceof Produit){
			return ((Produit)o).getId() == this.getId();
		}
		return false;
	}
	
	public int hashcode(){
		int resut = this.id;
		return resut;
	}
	
	public void finalize(){
		
	}
	
	
}
