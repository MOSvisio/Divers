package controller;

import dao.ProduitDAO;
import dao.TvaDAO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modele.Produit;
import modele.Tva;


public class ctrAccueil implements Initializable, ChangeListener<Produit> {
	
	public ObservableList<Produit> data = FXCollections.observableArrayList();
	public ObservableList<Tva> data2 = FXCollections.observableArrayList();
	public ObservableList<Produit> data3 = FXCollections.observableArrayList();

	@FXML private Button btnAddProd;
	@FXML private Button btnModProd;
	@FXML private Button btnDelProd;
	@FXML private Button btnReaProd;
	

	@FXML private Button btnAddTva;
	@FXML private Button btnModTva;
	@FXML private Button btnDelTva;
		
	@FXML private TableView<Tva> tblTva;
	@FXML private TableColumn<Tva, Integer> colIdTva = new TableColumn<>("id");
	@FXML private TableColumn<Tva, String> colLibTva = new TableColumn<>("Libellé");
	@FXML private TableColumn<Tva, Double> colTauxTva = new TableColumn<>("Taux");
	
	@FXML private TableView<Produit> tblProduitVente;
	@FXML private TableColumn<Produit, String> colLibPV = new TableColumn<>("Libellé");
	@FXML private TableColumn<Produit, Double> colTarifPV = new TableColumn<>("Tarif");
	@FXML private TableColumn<Produit, Integer> colStockPV = new TableColumn<>("Stock");
	@FXML private TableColumn<Produit, Integer> colTvaPV = new TableColumn<>("Tva");
	
	@FXML private TableView<Produit> tblAchatVente;
	@FXML private TableColumn<Produit, String> colLibVente = new TableColumn<>("Libellé");
	@FXML private TableColumn<Produit, Double> colTarifVente = new TableColumn<>("Tarif");
	@FXML private TableColumn<Produit, Integer> colQuantiteVente = new TableColumn<>("Quantité");
	@FXML private TableColumn<Produit, Integer> colTvaVente = new TableColumn<>("Tva");
	@FXML private TableColumn<Produit, Double> colPrixVente = new TableColumn<>("Sous total");
	
	
	@FXML private TableView<Produit> tblProduit;
	@FXML private TableColumn<Produit, Integer> colIdProduit = new TableColumn<>("ID");
	@FXML private TableColumn<Produit, String> colLibProduit = new TableColumn<>("Libellé");
	@FXML private TableColumn<Produit, Double> colTarifProduit = new TableColumn<>("Tarif");
	@FXML private TableColumn<Produit, Integer> colTvaProduit = new TableColumn<>("Tva");
	@FXML private TableColumn<Produit, Integer> colStockProduit = new TableColumn<>("Stock");

	
	
	public void showAddProd(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/vue/Scene_ajout_produit.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}
	
	public void showModTva(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/vue/Scene_modif_tva.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}
	
	public void showAddTva(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/vue/Scene_ajout_tva.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}
	
	public void showModProd(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/vue/Scene_modif_produit.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}
	
	public void showReaProd(ActionEvent event) throws IOException {
		boolean isValid = false;
		
		while(!isValid){
			TextInputDialog inDialog = new TextInputDialog("0");

			inDialog.setTitle("Réapprovisionnement");
			inDialog.setHeaderText("Quantité à réapprovisionner");
			inDialog.setContentText("Quantité :");
			
			Optional<String> textIn = inDialog.showAndWait();
			
			
			try { 
				int res = Integer.parseInt(textIn.get());
				if(res > 0){
					isValid = true;
				}
			}
			catch(NumberFormatException nfe) {
				isValid = false;
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Erreur de saisie");
			}

			if(textIn.isPresent() && isValid){
				Produit selectedItem = this.tblProduit.getSelectionModel().getSelectedItem();
				selectedItem.reapprovisionner(Integer.parseInt(textIn.get()));
				tblProduit.refresh();
			}
		}
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		this.btnDelProd.setDisable(true);
		this.btnModProd.setDisable(true);
		this.btnReaProd.setDisable(true);
		this.btnDelTva.setDisable(true);
		this.btnModTva.setDisable(true);
		
		colIdProduit.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("id"));	
		colLibProduit.setCellValueFactory(new PropertyValueFactory<Produit, String>("nom"));	
		colTarifProduit.setCellValueFactory(new PropertyValueFactory<Produit, Double>("tarif"));	
		colTvaProduit.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("Tva"));
		colStockProduit.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("stock"));

		this.tblProduit.getColumns().setAll(colIdProduit, colLibProduit, colTarifProduit, colTvaProduit, colStockProduit);
		
		this.tblProduit.getSelectionModel().selectedItemProperty().addListener(this);
		this.tblTva.getSelectionModel().selectedItemProperty().addListener((observable,oldvalue,newvalue)->{
			this.btnDelTva.setDisable(false);
			this.btnModTva.setDisable(false);
		});

		ProduitDAO res = ProduitDAO.getInstance();
		List<Produit> requete_all = null;
		try {
			requete_all = res.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		data.addAll(requete_all);
		tblProduit.getItems().addAll(data);

		colLibTva.setCellValueFactory(new PropertyValueFactory<Tva, String>("libelle"));
		colIdTva.setCellValueFactory(new PropertyValueFactory<Tva, Integer>("id"));
		colTauxTva.setCellValueFactory(new PropertyValueFactory<Tva, Double>("taux"));
		this.tblTva.getColumns().setAll(colIdTva, colLibTva, colTauxTva);
		TvaDAO rest = TvaDAO.getInstance();
		List<Tva> requete_allt = null;
		try {
			requete_allt = rest.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		data2.addAll(requete_allt);
		tblTva.getItems().addAll(data2);	
		
		colLibPV.setCellValueFactory(new PropertyValueFactory<Produit, String>("nom"));	
		colTarifPV.setCellValueFactory(new PropertyValueFactory<Produit, Double>("Tarif"));	
		colStockPV.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("Stock"));
		colTvaPV.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("Tva"));

		this.tblProduitVente.getColumns().setAll(colLibPV, colTarifPV, colStockPV, colTvaPV);
		this.tblProduitVente.getSelectionModel().selectedItemProperty().addListener(this);

		requete_all = null;
		try {
			requete_all = res.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		data3.addAll(requete_all);
		tblProduitVente.getItems().addAll(data3);
		
	}

	@Override
	public void changed(ObservableValue<? extends Produit> observable, Produit oldValue, Produit newValue) {
		this.btnDelProd.setDisable(false);
		this.btnModProd.setDisable(false);
		this.btnReaProd.setDisable(false);
	}
	
	/*public void changed(ObservableValue<? extends Tva> observable, Tva oldValue, Tva newValue) {
		this.btnDelProd.setDisable(false);
		this.btnModProd.setDisable(false);
	}*/
	
	public void clickBtnDelProd(ActionEvent event) throws IOException {
		Produit selectedItem = this.tblProduit.getSelectionModel().getSelectedItem();
		selectedItem.supprimerDansBdd();
	    tblProduit.getItems().remove(selectedItem);
		this.btnDelProd.setDisable(true);
		this.btnModProd.setDisable(true);
		this.btnReaProd.setDisable(true);
	}
	
	public void clickBtnDelTva(ActionEvent event) throws IOException {
		Tva selectedItem = this.tblTva.getSelectionModel().getSelectedItem();
		selectedItem.supprimerDansBdd();
	    tblTva.getItems().remove(selectedItem);
		this.btnDelTva.setDisable(true);
		this.btnModTva.setDisable(true);
	}
	
	public void AjoutVente(){
		
	}
	
	public void RetraitVente(){
		
	}
	
	public void ValidationVente(){
		
	}
	public void AnnulationVente(){
		
	}

}
