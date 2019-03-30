package modele;

import dao.ProduitDAO;
import dao.TvaDAO;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
	}
	
	public int getTva() {return tva;}
	public void setTva(int tva) {this.tva = tva;}

	public String toString(){
		daotva = TvaDAO.getInstance();
		return "nom : " + this.nom + " prix : " + this.tarif + " taux de TVA : " + this.tva; 
	}
	
	public void reapprovisionner(int rea){
		if(rea > 0)
			setStock(getStock() + rea);
	}
	
	public void modifierProduit(String nom, double tarif, int stock, int tva){
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
			setStock(this.stock-v);
			return v;
		} else{
			System.out.println("Stock indisponible");
			return 0;
		}
		
	}
	
	
	public int venteTest(int v){
		if(this.stock >= v && v>0){
			return v;
		} else if (this.stock < v && v > 0){
			v = v - (v-this.stock);
			Alert dialogE = new Alert(AlertType.ERROR);
			dialogE.setTitle("Quantité achetée trop importante");
			dialogE.setHeaderText("Stock insuffisant");
			dialogE.setContentText("Il ne restait que " + this.stock + " produits disponibles");
			dialogE.showAndWait();			return v;
		} else{
			System.out.println("Stock indisponible");
			return 0;
		}
		
	}
	
	public void creerDansBdd() {
		dao.create(this);
	}

	public void supprimerDansBdd(){
		dao.delete(this);
	}
	
	public void updaterDansBdd(){
		dao.update(this);
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
