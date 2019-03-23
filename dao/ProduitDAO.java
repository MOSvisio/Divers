package dao;

import java.sql.*;

import modele.Produit;
import modele.Connexion;

public class ProduitDAO implements DAO<Produit>{
	
	private static ProduitDAO instance;
	
	private ProduitDAO() {}
	
	public static ProduitDAO getInstance(){
		if(instance == null){
			instance = new ProduitDAO();
		}
		return instance;
	}

	@Override
	public Produit getById(int id) {
		Produit produit = null;
		try {
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("SELECT * FROM Produit WHERE id="+id);
			ResultSet res = requete.executeQuery();
			while(res.next()) {
				produit = new Produit(res.getString("nom"), res.getDouble("tarif"), res.getInt("stock"), res.getInt("tva"));
			}
			return produit;
		}catch (SQLException sqle){
			System.out.println("pb recupération du produit par id " + sqle.getMessage());
		}
		return null;
	}

	@Override
	public void create(Produit objet) {
		String nom = objet.getNom();
		double tarif = objet.getTarif();
		int stock = objet.getStock();
		int idTva = objet.getTva();
		
		try{
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("insert into Produit(nom, tarif, stock, tva) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);  
			requete.setString(1, nom);
			requete.setDouble(2, tarif);
			requete.setInt(3, stock);
			requete.setInt(4,idTva);		
			requete.executeUpdate();	
			ResultSet res = requete.getGeneratedKeys();
			if(res.next()){
				objet.setId(res.getInt(1));
			}
			if(requete != null)
				requete.close();
			if(laConnexion != null)
				laConnexion.close();	
		} catch (SQLException sqle){
			System.out.println("Pb insert produit " + sqle.getMessage());
		}
		
	}

	@Override
	public void update(Produit objet) {
		int id = objet.getId();
		String nom = objet.getNom();
		double tarif = objet.getTarif();
		int stock = objet.getStock();
		int idTva = objet.getTva();
		
		try{
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			Statement requete = laConnexion.createStatement();
			int nbLignes = requete.executeUpdate("UPDATE Produit SET nom = '"+ nom + "' WHERE id = " + id);
			nbLignes = requete.executeUpdate("UPDATE Produit SET tarif = '"+ tarif + "' WHERE id = " + id);
			nbLignes = requete.executeUpdate("UPDATE Produit SET stock = '"+ stock + "' WHERE id = " + id);
			nbLignes = requete.executeUpdate("UPDATE Produit SET tva = '"+ idTva + "' WHERE id = " + id);
			if(requete != null)
				requete.close();
			if(laConnexion != null)
				laConnexion.close();
		}catch (SQLException sqle){
			System.out.println("pb modification du produit : "+objet.getNom()+' ' + sqle.getMessage());
		}
		
	}

	@Override
	public void delete(Produit objet) {
		try {
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			Statement requete = laConnexion.createStatement();
			int nbLignes = requete.executeUpdate("DELETE FROM Produit WHERE id=" + objet.getId());
			if(requete != null)
				requete.close();
			if(laConnexion != null)
				laConnexion.close();
		}catch (SQLException sqle){
			System.out.println("pb suppression du produit : " + sqle.getMessage());
		}
		
	}

	@Override
	public int count(Produit objet) {
		// TODO Auto-generated method stub
		try{
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			Statement requete = laConnexion.createStatement();
			ResultSet res = requete.executeQuery("SELECT COUNT(*) as "+"Id"+" FROM Produit");
			while(res.next()){
				int id = res.getInt("Id");
				return id;
			}		
			if(res != null)
				res.close();
			if(requete != null)
				requete.close();
			if(laConnexion != null)
				laConnexion.close();
			
		} catch (SQLException sqle){
			System.out.println("Pb count " + sqle.getMessage());
		}
		return 0;
	}

}
