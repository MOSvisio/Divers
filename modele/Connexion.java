package modele;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class Connexion {
	
	private static Connexion instance;
	
	public static Connexion getInstance(){
		if(instance == null){
			instance = new Connexion();
		}
		return instance;
	}
	
	public Connection creeConnexion(){
		Properties accessBdd = new Properties();
		File fBdd = new File("src/config/properties.txt");
		try{
			FileInputStream source = new FileInputStream(fBdd);
			accessBdd.loadFromXML(source);
		}catch (IOException ioe){
			ioe.printStackTrace();
		}
		
		String url = accessBdd.getProperty("adresse_ip");
		String login = accessBdd.getProperty("login");
		String pwd = accessBdd.getProperty("pass");
		Connection maConnexion = null;	
		try {
			maConnexion = DriverManager.getConnection(url, login, pwd);
		} catch (SQLException sqle){
			System.out.println("Erreur connexion" + sqle.getMessage());
		}
		return maConnexion;
	}
	
	
	
	public void ajoutTvaSql(double taux, String libelle, int id){
		
		try{
			Connection laConnexion = creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("insert into Tva(taux, libelle, id) values(?,?,?)");  
			requete.setDouble(1, taux);
			requete.setString(2, libelle);
			requete.setInt(3, id);
			requete.executeUpdate();		
			if(requete != null)
				requete.close();
			if(laConnexion != null)
				laConnexion.close();	
		} catch (SQLException sqle){
			System.out.println("Pb insert tva " + sqle.getMessage());
		}
		
	}
	

	
	public int countIdTva(){
		try{
			Connection laConnexion = creeConnexion();
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
	
	public int obtenirStock(int id){
		try{
			Connection laConnexion = creeConnexion();
			Statement requete = laConnexion.createStatement();
			ResultSet res = requete.executeQuery("SELECT stock FROM Produit WHERE id = " + id);
			while(res.next()){
				int stock = res.getInt("stock");
				return stock;
			}
			if(res != null)
				res.close();
			if(requete != null)
				requete.close();
			if(laConnexion != null)
				laConnexion.close();		
		} catch (SQLException sqle){
			System.out.println("pb recup�ration des stocks " + sqle.getMessage());
		}
		return 0;
	}
	
	
	public void lireTva(){
		try {
			Connection laConnexion = creeConnexion();
			Statement requete;
			requete = laConnexion.createStatement();
			ResultSet res = requete.executeQuery("SELECT * FROM Tva ORDER BY id ");
			while(res.next()){
				System.out.println("id : " + res.getInt("id") + " libelle : " + res.getString("libelle") + " taux : " + res.getDouble("taux"));
			}	
			if(res != null)
				res.close();
			if(requete != null)
				requete.close();
			if(laConnexion != null)
				laConnexion.close();
		} catch (SQLException sqle) {
			// TODO Auto-generated catch block
			System.out.println("Pb lecture Tva " + sqle.getMessage());
		}
	}
	
	
}
	

