package controller;


import java.io.IOException;
import java.util.Optional;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modele.Produit;
import modele.Tva;

public class ctrTva {
	
	@FXML
	private TextField txtNom;
	@FXML
	private TextField txtTaux;
	

	public void afficherModele(ActionEvent event) throws IOException {
		String libelle = this.txtNom.getText();
		double taux = Double.parseDouble(this.txtTaux.getText());
		
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Confirmation");
		alert.setHeaderText(null);
		alert.setContentText("Voulez-vous créer : " + libelle + ' ' + taux + " ?");
		Optional<ButtonType> answer = alert.showAndWait();
		
		if(answer.get() == ButtonType.OK){
			Tva test = new Tva(taux, libelle);
			test.creerDansBdd();
			
			Parent tableViewParent = FXMLLoader.load(getClass().getResource("/vue/Scene_Accueil.fxml"));
			Scene tableViewScene = new Scene(tableViewParent);
			
			//la ligne suivante sers à récupérer l'évenement sous forme de fenêtre, sinon impossible de l'utiliser
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(tableViewScene);
			window.show();
		}
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
