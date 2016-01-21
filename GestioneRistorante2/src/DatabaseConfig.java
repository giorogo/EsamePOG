import java.sql.*;
public class DatabaseConfig {
	private static DatabaseConfig istanza;
	protected String jdbc_driver;
	protected String db_url;
	protected String user;
	protected String pass;

	//costruttore della classe
	public DatabaseConfig(){
		jdbc_driver = "com.mysql.jdbc.Driver";
		db_url = "jdbc:mysql://localhost/dbristorante";
		user = "username";
		pass = "password";
		istanza = this;
	}
	
	//metodi della classe
	public static DatabaseConfig getIstanza(){
		if (istanza == null){
			new DatabaseConfig();
		}
		return istanza;
	}
	
	public String getUser(){
		return user;
	}
	
	public String getPass(){
		return pass;
	}
	
	public String getUrl(){
		return db_url;
	}
}
	