package application.model;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import application.jdbc.DbManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GestoreTerremoti {
	
	private ArrayList<Terremoto> terremoti;
	public static ObservableList<Terremoto> listaTerremoti = FXCollections.observableArrayList();
	
	public GestoreTerremoti() {
		terremoti = new ArrayList<Terremoto>();
	}
	
	public void letturaDati() {
		
		try 
        {
            DbManager.createConnection();
        } 
		  catch (SQLException e1) 
        {
            e1.printStackTrace();
        }
		
		try {
			BufferedReader bIn = new BufferedReader(new FileReader("dati.txt"));
			
			while(bIn.ready()) {
				
				String line = bIn.readLine();
				
				if(line.charAt(0) != '#')
				aggiungiTerremoto(line);
				
			}
			
			bIn.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		try 
	        {
	            DbManager.closeConnection();
	        } 
	        catch (SQLException e) 
	        {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		
	}
	
	private void aggiungiTerremoto(String line) {
		
		String id;
		String data;
		String latitudine;
		String longitudine;
		String profondita;
		String tipoMagnitudo; 
		String magnitudo;
		String zona;
		
		
		
		String [] splitString = line.split("\\|");
		
		id = splitString[0];
		data = splitString[1];
		latitudine = splitString[2];
		longitudine = splitString[3];
		profondita = splitString[4];
		tipoMagnitudo = splitString[9];
		magnitudo = splitString[10];
		zona = splitString[12];
        zona=zona.replace("'", "");
        //per evitare l'exeption nel DB

		
		Terremoto temp = new Terremoto(id, data, latitudine, longitudine, profondita, tipoMagnitudo, magnitudo, zona);
		
		try {
			DbManager.insertTerremoti(temp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	void stampaTerremoti() {
		
		for(int i = 0; i < terremoti.size(); i++) {
			System.out.println(terremoti.get(i)+"\n");
		}
	}
	
	public ObservableList<Terremoto> getTerremoti() {
		return listaTerremoti;
	}
	
	
}
