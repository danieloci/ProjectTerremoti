package application.jdbc;

 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.model.GestoreTerremoti;
import application.model.Terremoto;

 

public class DbManager 
{

private static Connection con = null;
    
    public static void createConnection() throws SQLException 
    {        
        String url = "jdbc:sqlite:GestoreTerremoti.db";
        con = DriverManager.getConnection(url);
        if (con != null && !con.isClosed()) 
        {
            System.out.println("Connected!");            
        }
    }
    
    public static void closeConnection() throws SQLException 
    {
        if(con == null)
            return;        
        con.close();
        con = null;
    }
    
    public static void insertUsers() throws SQLException 
    {

 

        if(con == null || con.isClosed())
            return;        
        Statement stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO Utenti VALUES('i', 'mario', 'ross');");
        stmt.executeUpdate("INSERT INTO Utenti VALUES('t', 'mari', 'i');");
        stmt.executeUpdate("INSERT INTO Utenti VALUES('n', 'francesco', 'rossi');");
        stmt.executeUpdate("INSERT INTO Utenti VALUES('f', 'marco', 'l');");
        stmt.close();
        

 

    }
    
    public static void insertTerremoti(Terremoto t) throws SQLException
    {

 

        if(con == null || con.isClosed())
        {
            return;
        }
        
        Statement stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO Terremoti VALUES('"+t.getId()+"', '"+t.getData()+"', '"+Double.valueOf(t.getLatitudine()) +"', '"+t.getLongitudine()+"', '"+t.getProfondita()+"', '"+t.getTipoMagnitudo()+"', '"+t.getMagnitudo()+"', '"+t.getZona()+"');");
        System.out.println("Fine insert terr");
        stmt.close();
    }
    
    public static void importFromDb() throws SQLException 
    {
        if(con == null || con.isClosed())        
            return;
        
        String query = "select * from Terremoti;";
        
        PreparedStatement stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        
        Terremoto t;
        
        while(rs.next()) 
        {
        	GestoreTerremoti.listaTerremoti.add(new Terremoto(rs.getString("id"), rs.getString("data"),
        											rs.getString("latitudine"), rs.getString("longitudine"),
        											rs.getString("profondita"), rs.getString("tipoMagnitudo"),
        											rs.getString("magnitudo"), rs.getString("zona")));
       
        }        
        stmt.close();
        
    }
    
}