package application.view;

import application.model.GestoreTerremoti;
import application.model.Terremoto;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public class Table {
	

	public static TableView creaTabella() {
	
		
		TableView<Terremoto> table;
		
		GestoreTerremoti g = new GestoreTerremoti();
		//g.letturaDati();
		
   	 //Name column
       TableColumn<Terremoto, String> idColumn = new TableColumn<Terremoto, String>("Id");
       idColumn.setMinWidth(100);
       idColumn.setCellValueFactory(new PropertyValueFactory<Terremoto, String>("id"));

       //Price column
       TableColumn<Terremoto, String> dataColumn = new TableColumn<Terremoto, String>("Data");
       dataColumn.setMinWidth(200);
       dataColumn.setCellValueFactory(new PropertyValueFactory<Terremoto, String>("data"));
       	
       //Quantity column
       TableColumn<Terremoto, String> langColumn = new TableColumn<Terremoto, String>("Latitudine");
       langColumn.setMinWidth(100);
       langColumn.setCellValueFactory(new PropertyValueFactory<Terremoto, String>("latitudine"));

       TableColumn<Terremoto, String> longColumn = new TableColumn<Terremoto, String>("Longitudine");
       longColumn.setMinWidth(100);
       longColumn.setCellValueFactory(new PropertyValueFactory<Terremoto, String>("longitudine"));
      
       TableColumn<Terremoto, String> profColumn = new TableColumn<Terremoto, String>("Profondita");
       profColumn.setMinWidth(50);
       profColumn.setCellValueFactory(new PropertyValueFactory<Terremoto, String>("profondita"));
      
       TableColumn<Terremoto, String> tipoMagnitudoColumn = new TableColumn<Terremoto, String>("Tipo magnitudo");
       tipoMagnitudoColumn.setMinWidth(50);
       tipoMagnitudoColumn.setCellValueFactory(new PropertyValueFactory<Terremoto, String>("tipoMagnitudo"));
      
       TableColumn<Terremoto, String> magnitudoColumn = new TableColumn<Terremoto, String>("Magnitudo");
       magnitudoColumn.setMinWidth(100);
       magnitudoColumn.setCellValueFactory(new PropertyValueFactory<Terremoto, String>("magnitudo"));
       
       TableColumn<Terremoto, String> zonaColumn = new TableColumn<Terremoto, String>("Zona");
       zonaColumn.setMinWidth(300);
       zonaColumn.setCellValueFactory(new PropertyValueFactory<Terremoto, String>("zona"));
       
       
       table = new TableView<Terremoto>();
       table.setItems(g.getTerremoti());
   
       table.getColumns().addAll(idColumn, dataColumn, langColumn, longColumn, profColumn, tipoMagnitudoColumn,
       						  magnitudoColumn, zonaColumn);
       
       AnchorPane.setBottomAnchor(table, 0.0);
       AnchorPane.setRightAnchor(table, 0.0);
       AnchorPane.setLeftAnchor(table, 0.0);
       AnchorPane.setTopAnchor(table, 50.0);
     
       return table;
	}
	
	
}
