package application;

import java.io.File;

import com.teamdev.jxmaps.javafx.MapView;

import application.controller.Controller;
import application.jdbc.DbManager;
import application.model.DownloadDati;
import application.model.GestoreTerremoti;
import application.view.Maps;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {
		
	public static void main(String[] args) {
		launch(args);
	}
	
	//aaa bbb
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		 
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("view"+File.separator+"layout.fxml"));
		 AnchorPane root = (AnchorPane) loader.load();	
		 
		 Scene scene = new Scene(root,1100,650);

		 primaryStage.setMinWidth(1100);
		 primaryStage.setMinHeight(650);
		 
		 //ciao
		 Controller controller= (Controller) loader.getController();
		 	
		 controller.creaMappa();
		
		 DownloadDati.downloadFile();
		 
		 DbManager.createConnection();
		 DbManager.importFromDb();
		 
		 
		 controller.creaTabella();
		 
		 primaryStage.setScene(scene);
		 primaryStage.setTitle("Analizzatore terremoti");
		 primaryStage.show();
		 

		 
	}

}
