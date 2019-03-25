package dao;

import java.sql.*;
import java.util.*;
import java.io.*;

import modele.Connexion;
import modele.Produit;
import modele.Tva;


public class TvaDAO implements DAO<Tva>{
	
	private static TvaDAO instance;
	
	private TvaDAO(){}
	
	public static TvaDAO getInstance(){
		if(instance==null){
			instance = new TvaDAO();
		}
		return instance;
	}

	@Override
	public Tva getById(int id) {
		Tva tv = null;
		try {
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("SELECT * FROM Tva WHERE id="+id);
			ResultSet res = requete.executeQuery();
			while(res.next()) {
				tv = new Tva(res.getDouble("taux"), res.getString("libelle"));
				return tv;
			}
		}catch (SQLException sqle){
			System.out.println("pb recupération du produit par id " + sqle.getMessage());
		}
		return tv;
	}

	@Override
	public void create(Tva objet) {
		try{
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("insert into Tva(taux, libelle) values(?,?)",Statement.RETURN_GENERATED_KEYS);  
			requete.setDouble(1, objet.getTaux());
			requete.setString(2, objet.getLibelle());
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
			System.out.println("Pb insert tva " + sqle.getMessage());
		}
		
	}

	@Override
	public void update(Tva objet) {
		try{
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			Statement requete = laConnexion.createStatement();
			int nbLignes = requete.executeUpdate("UPDATE Tva SET libelle = '"+ objet.getLibelle() + "' WHERE id = " + objet.getId());
			nbLignes = requete.executeUpdate("UPDATE Tva SET taux = '"+ objet.getTaux() + "' WHERE id = " + objet.getId());
			
			if(requete != null)
				requete.close();
			if(laConnexion != null)
				laConnexion.close();
		}catch (SQLException sqle){
			System.out.println("pb modification Tva " + sqle.getMessage());
		}
		
	}

	@Override
	public void delete(Tva objet) {
		try{
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("DELETE FROM Tva WHERE libelle = " + objet);  
			requete.executeUpdate();		
			if(requete != null)
				requete.close();
			if(laConnexion != null)
				laConnexion.close();	
		} catch (SQLException sqle){
			System.out.println("Pb delete tva " + sqle.getMessage());
		}		
	}


	@Override
	public int count(Tva objet) {
		try{
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			Statement requete = laConnexion.createStatement();
			ResultSet res = requete.executeQuery("SELECT COUNT(*) as "+"Id"+" FROM Tva");
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
