package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class test {
	static String url;
	static String user;
	static String password;
	
	Connection cnx;
	Statement stm;
	 String sql;
	 
	
		static Properties prop = new Properties();
		static{
			try {
				prop.load(test.class.getResourceAsStream("/config.properties"));
				url=prop.getProperty("url");
				 user=prop.getProperty("user");
				 password=prop.getProperty("pwd");
			 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		 
}
		
public void connecter(){
	
	try {
		cnx =DriverManager.getConnection(url, user, password);
		if (cnx!=null){
			System.out.println("connexion etablie");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void ajouter(){
	try {
		stm =cnx.createStatement();
		sql= "insert into chef (id, nom, prenom) values (111222,'Abir','boudh')" ;
		stm.execute(sql);
				
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public void afficher(){
	try {
		stm =cnx.createStatement();
		sql= "select * from chef";
		ResultSet rs= stm.executeQuery(sql);
		while (rs.next()){
			int id= rs.getInt("id");
			String nom = rs.getString("nom");
			String prenom = rs.getString("prenom");
		
		System.out.println(id +"nom"+ nom+"prenom"+prenom);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
public void supprimer (int id){
	try {
		stm =cnx.createStatement();
		sql="delete from chef where id=" +id;
		stm.execute(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
public void modifier (int id, String nom){
	try {
		stm =cnx.createStatement();
		sql= "update chef set nom='"+nom+"' where id="+id;
		stm.execute(sql);
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static void main(String[] args) {
	test t= new test();
	t.connecter();
    //t.ajouter();
    // t.afficher();
	// t.supprimer(12);
	//t.modifier(1122, "WAEL");
}

}