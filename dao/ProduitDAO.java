package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
			System.out.println("pb recupÃ©ration du produit par id " + sqle.getMessage());
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
	
	

	public List<Produit> getAll() throws SQLException {
		
		List<Produit> list = new ArrayList<>();
		TvaDAO daotva = null;
		Connection laConnexion = Connexion.getInstance().creeConnexion(); // la connexion existe dans le singleton et je vais chercher ma Connection avec le getConnection 
		PreparedStatement requete = laConnexion.prepareStatement("select * from Produit ");
		ResultSet res = requete.executeQuery();
		
		try {
			while (res.next()) {  // tant qu'il y a une ligne 
				int idProduit = res.getInt("id"); //je prend mon id que j'enregistre dans ma varible idProduit
				String nom = res.getString("nom"); //je prends dans la colonne libelle ma don
				int stock =res.getInt("stock");
				double tarif = res.getDouble("tarif"); //je prends dans la colonne taux ma donnée 
				int idTva = res.getInt("tva");
				//daotva = DAOTva.getInstance();
				//tva = daotva.getById(idTva);
				
				Produit produit = new Produit(nom, tarif, stock,idTva);
				produit.setId(idProduit);
				list.add(produit);				
			}	
			if (res != null)
				res.close();
			if (requete != null)
				requete.close();
			
		} catch (SQLException sqle) {
			System.out.println("Pb select " + sqle.toString());
		}
		return list; // l'objet tva est crée et il est retourné
	}

}
