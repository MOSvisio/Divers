package controller;

import dao.TvaDAO;
import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
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
		
		int n = JOptionPane.showConfirmDialog(null, "Voulez-vous créer : " + libelle + ' ' + taux + " ?", "Confirmation", JOptionPane.YES_NO_OPTION);
		if (n == 0) {	
			Tva test = new Tva(taux, libelle);
			dao.create(test);
		}
	}
}
