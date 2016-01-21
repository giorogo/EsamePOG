


public class Personale {
	
	
private String nome;
private String cognome;
private String descrizione;
private int id;



//costruttore
public Personale(int id, String nome, String cognome, String descrizione){
	this.id = id;
	this.nome=nome;
	this.cognome=cognome;
	this.descrizione=descrizione;

}

//GET DEGLI ATTRIBUTI
public String getNome() { 
    return nome; 
}
public String getCognome() { 
    return cognome; 
}
public String getDescrizione() { 
    return nome; 
}
public int getId() { 
    return id; 
}
//set DEGLI ATTRIBUTI
public void setNome(String n) { 
  nome=n; 
}
public void setCognome(String c) { 
  cognome=c; 
}
public void setDescrizione(String d) { 
 descrizione=d; 
}
public void setId(Integer id) { 
 this.id=id;
}


	  





















}
