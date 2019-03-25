package controller;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
	private ComboBox<Tva> listTva; // à changer pour une liste déroulante de choix appel la listTva
	
	public void afficherModele() {
		String nom = this.txtNom.getText();
		double tarif =Double.parseDouble(this.txtTarif.getText());
		int stock = Integer.parseInt(this.txtQuantite.getText());
		Tva recup = this.listTva.getSelectionModel().getSelectedItem();
		System.out.println(recup.getLibelle());
		
		int n = JOptionPane.showConfirmDialog(null, "Voulez-vous créer : " + nom + ' ' + tarif + "€, stock : " + stock + " tva : " + recup.getId() + "?", "confirmation", JOptionPane.YES_NO_OPTION);
		if (n == 0) {	
			new Produit(nom, tarif, stock, recup.getId());
		}
	}
	
	public void genereList() {
		this.listTva.setItems(Tva.getList());
		this.listTva.getSelectionModel().select(0);
	}
	
	
}
