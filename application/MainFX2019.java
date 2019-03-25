package application;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainFX2019 extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			/*final URL fxmlURL = getClass().getResource("/vue/Scene_accueil.fxml");
			final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			final BorderPane node = (BorderPane) fxmlLoader.load();*/
			TabPane root = FXMLLoader.load(getClass().getResource("/vue/Scene_accueil.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setX(400);
			primaryStage.setY(200);
			
			primaryStage.setTitle("Gestion de magasin");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
