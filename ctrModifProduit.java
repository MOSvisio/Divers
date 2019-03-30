package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import modele.Produit;
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
	
	private Produit selectedProduct;
	
	//initialise un produit à partir du produit sélectionné sur la page d'accueil
	public void initData(Produit produit){
		selectedProduct = produit;
		int indexTva = selectedProduct.getTva();
		System.out.println(indexTva);
		txtNom.setText(selectedProduct.getNom());
		txtTarif.setText(Double.toString(selectedProduct.getTarif()));
		this.listTva.setValue(Tva.getTvaById(indexTva));
	}
	
	//Pour update la BDD
	public void modifierProduit(ActionEvent event) throws IOException {
		
		try {
		    double val = Double.parseDouble(txtTarif.getText());
		    String txt = txtNom.getText();
		    if(txt.matches("[0-9]+") || txt.trim().length() == 0){
		    	throw new IllegalArgumentException();
		    }
		    if(val < 0){
		    	throw new IllegalArgumentException();
		    }
		    selectedProduct.modifierProduit(txtNom.getText(), Double.parseDouble(txtTarif.getText()), selectedProduct.getStock(), this.listTva.getSelectionModel().getSelectedIndex()+1);
			showAccueil(event);
			
		} catch(Exception e) {
			Alert dialogE = new Alert(AlertType.ERROR);
			dialogE.setTitle("Erreur dans la modification de Produit");
			dialogE.setHeaderText("Modification non enregistrée");
			dialogE.setContentText("Erreur : Modification non valide");
			dialogE.showAndWait();
		}
	}
	
	//Combo box
	public void genereList() {
		this.listTva.setItems(Tva.getList());
	}
	
	//Bouton retour
	public void showAccueil(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/vue/Scene_Accueil.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		
		//la ligne suivante sers à récupérer l'évenement sous forme de fenêtre, sinon impossible de l'utiliser
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}

}
