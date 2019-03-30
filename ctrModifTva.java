package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modele.Produit;
import modele.Tva;

public class ctrModifTva {
	@FXML
	private TextField txtNom;
	@FXML
	private TextField txtTaux;
	
	private Tva selectedTva;

	public void showAccueil(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/vue/Scene_Accueil.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		
		//la ligne suivante sers à récupérer l'évenement sous forme de fenêtre, sinon impossible de l'utiliser
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}
	
	public void initData(Tva tva){
		selectedTva = tva;
		txtNom.setText(selectedTva.getLibelle());
		txtTaux.setText(Double.toString(selectedTva.getTaux()));
	}
	
	//Pour update la BDD
	public void modifierTva(ActionEvent event) throws IOException {
		try {
		    double val = Double.parseDouble(txtTaux.getText());
		    String txt = txtNom.getText();
		    if(txt.matches("[0-9]+") || txt.trim().length() == 0){
		    	throw new IllegalArgumentException();
		    }
		    if(val < 0){
		    	throw new IllegalArgumentException();
		    }
		    selectedTva.modifierTva(txtNom.getText(), Double.parseDouble(txtTaux.getText()));
			showAccueil(event);
			
		} catch(Exception e) {
			Alert dialogE = new Alert(AlertType.ERROR);
			dialogE.setTitle("Erreur dans la modification TVA");
			dialogE.setHeaderText("Modification non enregistrée");
			dialogE.setContentText("Erreur : Modification non valide");
			dialogE.showAndWait();
		}
		

	}

}
