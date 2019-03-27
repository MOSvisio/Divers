package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modele.Produit;
import modele.Tva;



public class ctrProduit implements Initializable{
	
	@FXML
	private Label labelModele;
	@FXML
	private TextField txtNom;
	@FXML
	private TextField txtQuantite;
	@FXML
	private TextField txtTarif;
	@FXML
	private ComboBox<Tva> listTva; // à changer pour une liste déroulante de choix appel la listTva
	
	public void afficherModele(ActionEvent event) throws IOException {
		String nom = this.txtNom.getText();
		double tarif =Double.parseDouble(this.txtTarif.getText());
		int stock = Integer.parseInt(this.txtQuantite.getText());
		Tva recup = this.listTva.getSelectionModel().getSelectedItem();
		System.out.println(recup.getLibelle());
		
		
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Confirmation");
		alert.setHeaderText(null);
		alert.setContentText("Voulez-vous créer : " + nom + ' ' + tarif + "€, stock : " + stock + " tva : " + recup.getId() + "?");
		Optional<ButtonType> answer = alert.showAndWait();
		
		if(answer.get() == ButtonType.OK){
			Produit ajout = new Produit(nom, tarif, stock, recup.getId());
			ajout.creerDansBdd();
			
			Parent tableViewParent = FXMLLoader.load(getClass().getResource("/vue/Scene_Accueil.fxml"));
			Scene tableViewScene = new Scene(tableViewParent);
			
			//la ligne suivante sers à récupérer l'évenement sous forme de fenêtre, sinon impossible de l'utiliser
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(tableViewScene);
			window.show();
		}
		
	}
	
	public void genereList() {
		
	}
	
	public void initialize(URL url, ResourceBundle rb){
		this.listTva.setItems(Tva.getList());
		this.listTva.getSelectionModel().select(0);
	}
	
	public void showAccueil(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/vue/Scene_Accueil.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		
		//la ligne suivante sers à récupérer l'évenement sous forme de fenêtre, sinon impossible de l'utiliser
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}
	
	
}
