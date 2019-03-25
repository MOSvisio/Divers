package controller;

import dao.TvaDAO;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modele.Tva;

public class ctrTva {
	
	private TvaDAO dao;
	@FXML
	private TextField txtNom;
	@FXML
	private TextField txtTaux;
	

	public void afficherModele() {
		dao = TvaDAO.getInstance();
		String libelle = this.txtNom.getText();
		double taux = Double.parseDouble(this.txtTaux.getText());
		
		int n = JOptionPane.showConfirmDialog(null, "Voulez-vous cr�er : " + libelle + ' ' + taux + " ?", "Confirmation", JOptionPane.YES_NO_OPTION);
		if (n == 0) {	
			Tva test = new Tva(taux, libelle);
			dao.create(test);
		}
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
