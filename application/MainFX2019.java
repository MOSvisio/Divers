package application;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainFX2019 extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			final URL fxmlURL = getClass().getResource("/vue/Scene_ajout_produit.fxml");
			final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			final BorderPane node = (BorderPane) fxmlLoader.load();
			Scene scene = new Scene(node);
			primaryStage.setX(400);
			primaryStage.setY(400);
			
			primaryStage.setTitle("Ma première fenetre");
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
