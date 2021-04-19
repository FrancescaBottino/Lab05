package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;


public class ConnectDB {
	
	static private final String jdbcUrl = "jdbc:mysql://localhost/dizionario?user=root&password=nasor819";

	static private HikariDataSource ds = null;
	
	public static Connection getConnection() {
		
		if(ds==null) //prima volta
			{
			 ds=new HikariDataSource();
			
		
		//se lo facessi direttamete qua lo farebbe ogni volta
		
		   ds.setJdbcUrl(jdbcUrl);
			}
		
	//	ds.setUsername("root"); //inutile rifarlo se già fatto sopra
	//	ds.setPassword("nasor819"); //se lo metto anche prevale qui: l'ultimo
		
		
		//non ho bisogno di ds.close()

		try {
				Connection connection = ds.getConnection(); //anzichè DriverManager.getConnection(jdbcUrl)
				return connection;

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException("Cannot get a connection " + jdbcUrl, e);
		}
	}

}
