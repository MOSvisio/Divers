package modele;


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
		for(int i=0; i<10; i++){
			if(dao.getById(i) != null){
				Tva test = dao.getById(i);
				test.setId(i);
				if(test != null) {
					list.add(test);
				}
			}
		}
		return list;
	}
	
	public void creerDansBdd() {
		dao = TvaDAO.getInstance();
		dao.create(this);
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
