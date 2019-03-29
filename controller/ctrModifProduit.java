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
		selectedProduct.modifierProduit(txtNom.getText(), Double.parseDouble(txtTarif.getText()), selectedProduct.getStock(), this.listTva.getSelectionModel().getSelectedIndex()+1);
		showAccueil(event);
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
