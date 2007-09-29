package exemplo;

import exemplo.persistente.*;
import java.sql.*;

public class Main  {

	public static void main(String[] args)  {
		System.out.println("\nIniciando o aplicativo!\n");			

		Connection con = getConnection();
		
		//criando uma classe persistente
		Pessoa p = new Pessoa(con);
		
		//Criar uma pessoa
		System.out.println("\nCriar uma pessoa com id igual a '1'.");
		p.setId(1);
		p.setNome("foo");
		p.setIdade(25);
		p.setSexo(true);
		
		//salvando os dados na tabela
		System.out.println("\nSalvando os dados dessa pessoa no banco de dados.");
		p.save();
		
		//criando um novo objeto
		p = new Pessoa(con);
		
		//recuperando os dados da tabela
		System.out.println("\nRecuperando os dados dessa pessoa na base de dados.");
		
		p.getById(1);
		System.out.println("Pessoa");
		System.out.println("    ID: " + p.getId());
		System.out.println("  Nome: " + p.getNome());
		System.out.println(" Idade: " + p.getIdade());
		System.out.println("  Sexo: " + p.getSexo());
		
		System.out.println("\nRemovendo essa pessoa.");
		p.delete();

	}

	private static Connection getConnection()  {
		
    try {
    	Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			System.out.println(ex);
			System.exit(0);
		}		
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/exemplo?user=root&password=root");
			return con;
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			System.exit(0);
		}
		
		return null;	
	}
	
}