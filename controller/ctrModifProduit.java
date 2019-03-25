package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modele.Tva;

public class ctrModifProduit {
	
	@FXML
	private Label labelModele;
	@FXML
	private TextField txtNom;
	@FXML
	private TextField txtTarif;
	@FXML
	private ComboBox<Tva> listTva;
	
	public void modifierProduit() {
		
	}
	
	public void genereList() {
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
