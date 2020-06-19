package application.controller;

import com.teamdev.jxmaps.javafx.MapView;

import application.model.GestoreTerremoti;
import application.model.Product;
import application.model.Terremoto;
import application.view.Maps;
import application.view.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

public class Controller {
	
	private WebView web;
	
    @FXML
    private AnchorPane topAnchorPane;

    @FXML
    private VBox vbox;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnDownload;

    @FXML
    private Button btnSearch;
    
    @FXML
    private TextField txtSearch;
    
    @FXML
    private SplitPane splitPane;

    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnCharts;

    @FXML
    private AnchorPane bottomAnchorPane;

    @FXML
    private Button btnProfilo;
    
    @FXML
    private AnchorPane anchorPane;

    private AnchorPane charts;
    
    @FXML
    void dashboardAction(ActionEvent event) {
    	
    	
    	charts.setVisible(false);
    	
    	splitPane.setVisible(true);
    	topAnchorPane.setVisible(true);
    	bottomAnchorPane.setVisible(true);
    	//anchorPane.getChildren().remove(charts);
    	anchorPane.setBottomAnchor(bottomAnchorPane, 0.0);
    	anchorPane.setRightAnchor(bottomAnchorPane, 0.0);
    }
    			
    @FXML
    void chartsAction(ActionEvent event) {
    	
    	  topAnchorPane.setVisible(false);
    	  bottomAnchorPane.setVisible(false);
    	  splitPane.setVisible(false);
    	 
    	  HBox root = new HBox();

          //Scene scene = new Scene(root, 450, 330);

          NumberAxis xAxis = new NumberAxis();
          xAxis.setLabel("Age");

          NumberAxis yAxis = new NumberAxis();
          yAxis.setLabel("Salary (€)");

        //  LineChart lineChart = new LineChart<Terremoto,String>(xAxis, yAxis);
         // lineChart.setTitle("Average salary per age");

          Series<Number, Number> data = new XYChart.Series<Number, Number>();
          data.setName("2016");

         /* data.getData().add(new XYChart.Data<Terre>(18, 567));
          data.getData().add(new XYChart.Data<>(20, 612));
          data.getData().add(new XYChart.Data<>(25, 800));
          data.getData().add(new XYChart.Data<>(30, 980));
          data.getData().add(new XYChart.Data<>(40, 1410));
          data.getData().add(new XYChart.Data<>(50, 2350));

          lineChart.getData().add(data);
          
          charts = new AnchorPane();
          charts.setLayoutX(250);     
          charts.getChildren().add(lineChart);       
          anchorPane.getChildren().add(charts);
         */ 
    }

    @FXML
    void search(ActionEvent event) {
    	
    }
    
    @FXML
    void profiloAction(ActionEvent event) {

    }

    @FXML
    void downloadAction(ActionEvent event) {
    	
    }

    @FXML
    void loginAction(ActionEvent event) {

    }
    
    public void creaMappa() {
    	 
    
    	web = new WebView();
        web.getEngine().setUserAgent("Mozilla/5.0 (iPad; CPU OS 12_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148");
    	web.getEngine().load("https://www.google.com/maps/");
    		
    	topAnchorPane.getChildren().add(web);
    	
    	topAnchorPane.setTopAnchor(web, 0.0);
    	topAnchorPane.setBottomAnchor(web, 0.0);
    	topAnchorPane.setRightAnchor(web, 0.0);
    	topAnchorPane.setLeftAnchor(web, 0.0);
    	
    	
    }
    	
    public void creaTabella() {

        TableView<Terremoto> table=Table.creaTabella();
        
        addList(table);

        bottomAnchorPane.getChildren().add(table);
        
		  
    }
    
    public void addList(TableView<Terremoto> table) 
    {
        table.setOnMouseClicked(( MouseEvent event)-> 
        {
            if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2)
            {
                Terremoto t = table.getSelectionModel().getSelectedItem();
                Double lat = Double.valueOf(t.getLatitudine());
                Double lon = Double.valueOf(t.getLongitudine());
                
              Maps.update(web,"https://www.google.com/maps/place/"+lat+","+lon);
             }
        });
    }

    
   
}
