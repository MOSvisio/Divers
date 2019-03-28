package modele;


import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ProduitDAO;
import dao.TvaDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Tva {
	private static TvaDAO dao;
	private double taux;
	private String libelle;
	private int id;
	
	
	public Tva(double taux, String libelle) {
		dao = TvaDAO.getInstance();
		this.taux = taux;
		this.libelle = libelle;
	}


	public double getTaux() {return taux;}
	public void setTaux(double taux) {this.taux = taux;}
	public String getLibelle() {return libelle;}
	public void setLibelle(String libelle) {this.libelle = libelle;}
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public static ObservableList<Tva> getList(){
		dao = TvaDAO.getInstance();
		ObservableList<Tva> list = FXCollections.observableArrayList(); 
		List<Tva> temp = null;
		try {
			temp = dao.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list.addAll(temp);
		return list;
	}
	
	public void creerDansBdd() {
		
		dao.create(this);
	}
	
	public void supprimerDansBdd(){
		dao.delete(this);
	}
	
	public static Tva getTvaById(int i) {
		dao = TvaDAO.getInstance();
		return dao.getById(i);
	}
	
	@Override
    public String toString()  {
        return "Tva " + this.getLibelle() + " taux à " + this.taux;
    }
}
