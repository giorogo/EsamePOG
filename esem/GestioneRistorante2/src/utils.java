import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.swing.JOptionPane;

//import videoteca.db.DatabaseConfig;

public class utils {
	private DatabaseConfig connessione;
	
	public utils(){
		connessione = new DatabaseConfig();
	}
//PRENDIAMO DATI DEL " PERSONALE " DAL DB
	public String getNome(int id){
		  String nome = "";
		  try {
			  connessione = DatabaseConfig.getIstanza();
	  	      Connection con = DriverManager.getConnection(connessione.getUrl(), connessione.getUser(), connessione.getPass());
	  	      Statement cmd = con.createStatement();
	  	    	  String query = "SELECT nome_cameriere FROM cameriere WHERE id_cameriere = '"+id+"'";
	  	    	  ResultSet rs = cmd.executeQuery(query);
	  	    	  while(rs.next())
	  	    		nome = rs.getString("nome_cameriere");
	  	      cmd.close();
	  	      con.close();
	  	    }
		  catch (SQLException e){
	  	      e.printStackTrace();
	  	    }
		  return nome;
	  }

	public String getCognome(int id){
		  String cognome = "";
		  try {
			  connessione = DatabaseConfig.getIstanza();
	  	      Connection con = DriverManager.getConnection(connessione.getUrl(), connessione.getUser(), connessione.getPass());
	  	      Statement cmd = con.createStatement();
	  	    	  String query = "SELECT cognome_cameriere FROM cameriere WHERE id_cameriere = '"+id+"'";
	  	    	  ResultSet rs = cmd.executeQuery(query);
	  	    	  while(rs.next())
	  	    		cognome = rs.getString("cognome_cameriere");
	  	      cmd.close();
	  	      con.close();
	  	    }
		  catch (SQLException e){
	  	      e.printStackTrace();
	  	    }
		  return cognome;
	  }
	public String getDescrizione(int id){
		  String descrizione = "";
		  try {
			  connessione = DatabaseConfig.getIstanza();
	  	      Connection con = DriverManager.getConnection(connessione.getUrl(), connessione.getUser(), connessione.getPass());
	  	      Statement cmd = con.createStatement();
	  	    	  String query = "SELECT desc_cameriere FROM cameriere WHERE id_cameriere = '"+id+"'";
	  	    	  ResultSet rs = cmd.executeQuery(query);
	  	    	  while(rs.next())
	  	    		descrizione = rs.getString("desc_cameriere");
	  	      cmd.close();
	  	      con.close();
	  	    }
		  catch (SQLException e){
	  	      e.printStackTrace();
	  	    }
		  return descrizione;
	  }


			public int getIdAdmin(String n, String c){
			      int id = 0;
			      try {
			        connessione = DatabaseConfig.getIstanza();
			            Connection con = DriverManager.getConnection(connessione.getUrl(), connessione.getUser(), connessione.getPass());
			            Statement cmd = con.createStatement();
			            String query = "SELECT id_cameriere FROM cameriere WHERE nome_cameriere = '"+n+"' AND cognome_cameriere = '"+c+"'";
			            ResultSet rs = cmd.executeQuery(query);
			            if(rs.next()){
			              id =rs.getInt("id_cameriere");
			            }  
			            cmd.close();
			            con.close();
			          }
			      catch (SQLException e){
			            e.printStackTrace();
			          }
			      return id;
			    }

			//metodo per la lista dei camerieri
public ArrayList<Personale> getListacam(){
				ArrayList<Personale> listaCamerieri = new ArrayList<Personale>();
             	  try {
					  connessione = DatabaseConfig.getIstanza();
				      Connection con = DriverManager.getConnection(connessione.getUrl(), connessione.getUser(), connessione.getPass());
				      Statement cmd = con.createStatement();
				    	  String query = "SELECT * FROM cameriere ";
				    	  ResultSet rs = cmd.executeQuery(query);
				    	  rs.last();
				    	  System.out.println(rs.getRow());
				    	  rs.beforeFirst();
				    	  while(rs.next()){
				    		int id= rs.getInt("id_cameriere");
				    		String nome = rs.getString("nome_cameriere");
				    		String cognome = rs.getString("cognome_cameriere");
				    		String descrizione = rs.getString("desc_cameriere");
				    		Personale cameriere = new Personale(id, nome, cognome, descrizione);
				    	  
				    		listaCamerieri.add(cameriere);
				    	   // System.out.print(" ID: " + id);
				    	   // System.out.print(" NOME: " + nome);
				    	   // System.out.print(" COGNOME: " + cognome);
				    	   // System.out.println(" DESC: " + descrizione);
				    	   
				    	  }
				    	  System.out.println("");
				    	  System.out.println("Adesso stampo arraylist!");
				    	  for (int i = 0; i < listaCamerieri.size(); i++) {
				  			System.out.println(listaCamerieri.get(i).getNome());
				  		}
				    	  
				      cmd.close();
				      con.close();
				    }
				  catch (SQLException e){
				      e.printStackTrace();
				    }

return(listaCamerieri);

			}













}
