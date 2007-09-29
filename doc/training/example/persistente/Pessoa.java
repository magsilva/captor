package exemplo.persistente;

import java.sql.*;

public class Pessoa  {

	private int id;
	private String nome;
	private int idade;
	private boolean sexo;
	
	private Connection con;
	
	public Pessoa(Connection con)  {
		nome = new String();
		idade = 0;
		id = 0;
		sexo = true;	
		this.con = con;
	}	
	
	//getters and setters
	public int getId()  {
		return id;
	}
	public void setId(int id)  {
		this.id = id;	
	}

	public String getNome()  {
		return nome;
	}
	public void setNome(String nome)  {
		this.nome = nome;	
	}
	
	public int getIdade()  {
		return idade;
	}
	public void setIdade(int idade)  {
		this.idade = idade;	
	}
	
	public boolean getSexo()  {
		return sexo;
	}
	public void setSexo(boolean sexo)  {
		this.sexo = sexo;	
	}

	//persistent methods
	public boolean save()  {
		Statement stmt = null;
		
		String query = " INSERT INTO PESSOA (ID, NOME, IDADE, SEXO) VALUES (ID_, 'NOME_', IDADE_,'SEXO_')";
		query = query.replaceFirst("ID_", new Integer(id).toString());
		query = query.replaceFirst("NOME_", nome);
		query = query.replaceFirst("IDADE_", new Integer(idade).toString());
		query = query.replaceFirst("SEXO_", new Boolean(sexo).toString().substring(0,1));
		
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(query);
			
			try {
				stmt.close();
				return true;
			} catch (SQLException ex) { 
				System.out.println(ex);
				return false;
			}
		}catch(Exception ex)  {
			System.out.println(ex);
			return false;
		}

	}
	
	public boolean getById(int id)  {
		Statement stmt = null;
		ResultSet rs = null;
		
		String query = "SELECT * FROM PESSOA WHERE ID = ID_";
		query = query.replaceFirst("ID_", new Integer(id).toString());
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			
			while (rs.next() )  {
				// Use the getInt method to obtain emp. id
				this.id = rs.getInt("ID");
				nome = rs.getString("NOME");
				idade = rs.getInt("IDADE");
				String sx = rs.getString("SEXO");
				if ( sx.equals("t") )
					sexo = true;
				else
					sexo = false;
			}			
			
			try {
				stmt.close();
				return true;
			} catch (SQLException ex) { 
				System.out.println(ex);
				return false;
			}
		}catch(Exception ex)  {
			System.out.println(ex);
			return false;
		}
		
	}
	
	public boolean delete()  {
		Statement stmt = null;
		
		String query = "DELETE FROM PESSOA WHERE ID = ID_";
		query = query.replaceFirst("ID_", new Integer(id).toString());
		
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(query);
			
			try {
				stmt.close();
				return true;
			} catch (SQLException ex) { 
				System.out.println(ex);
				return false;
			}
		}catch(Exception ex)  {
			System.out.println(ex);
			return false;
		}
			
	}
	
}