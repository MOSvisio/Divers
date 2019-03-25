package controller;

import java.io.IOException;

import javax.swing.JOptionPane;

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



public class ctrProduit {
	
	@FXML
	private Label labelModele;
	@FXML
	private TextField txtNom;
	@FXML
	private TextField txtQuantite;
	@FXML
	private TextField txtTarif;
	@FXML
	private ComboBox<Tva> listTva; // � changer pour une liste d�roulante de choix appel la listTva
	
	public void afficherModele() {
		String nom = this.txtNom.getText();
		double tarif =Double.parseDouble(this.txtTarif.getText());
		int stock = Integer.parseInt(this.txtQuantite.getText());
		Tva recup = this.listTva.getSelectionModel().getSelectedItem();
		System.out.println(recup.getLibelle());
		
		int n = JOptionPane.showConfirmDialog(null, "Voulez-vous cr�er : " + nom + ' ' + tarif + "�, stock : " + stock + " tva : " + recup.getId() + "?", "confirmation", JOptionPane.YES_NO_OPTION);
		if (n == 0) {	
			new Produit(nom, tarif, stock, recup.getId());
		}
	}
	
	public void genereList() {
		this.listTva.setItems(Tva.getList());
		this.listTva.getSelectionModel().select(0);
	}
	
	public void showAccueil(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/vue/Scene_Accueil.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		
		//la ligne suivante sers � r�cup�rer l'�venement sous forme de fen�tre, sinon impossible de l'utiliser
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}
	
	
}
