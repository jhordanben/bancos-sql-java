package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import conexaojdbc2.SingleConnection;
import model.Midnights;

public class UserPosDAO {
	
	public Connection connection;
	
	private static final Logger LOGGER = Logger.getLogger(UserPosDAO.class.getName());
	
	public UserPosDAO() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(Midnights midnights) {
		try {
			
			String sql = "insert into midnights (id, nome, email) values (?, ?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setInt(1, midnights.getId());
			insert.setString(2, midnights.getNome());
			insert.setString(3, midnights.getEmail());
			insert.execute();
			connection.commit(); //conecta no banco de dados
			
		} catch (Exception e) {
			try { 
				connection.rollback();
			
			} catch (SQLException e1) {
				e.printStackTrace();
			} 	
			e.printStackTrace();
		
		}
	}		
	
	public List<Midnights> listar () throws Exception {
		List<Midnights> list = new ArrayList<Midnights>();
		
		String sql = "select * from midnights"; //conecta sql
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		
		while (resultado.next()) {
			Midnights midnights = new Midnights();
			midnights.setId(resultado.getInt("id"));
			midnights.setNome(resultado.getString("nome"));
			midnights.setEmail(resultado.getString("email"));
			
			list.add(midnights);
			
		}
		
		return list;
	}
	
	public Midnights buscar (int id) throws Exception {
		Midnights retorno = new Midnights();
		
		String sql = "select * from midnights where nome " + id;
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		
		while (resultado.next()) {
			
			retorno.setId(resultado.getInt(id));
			retorno.setNome(resultado.getString("nome"));
			retorno.setEmail(resultado.getString("email"));
		}
		
		//System.out.println(LOGGER);
		return retorno;
		
	} 
		
	
	public void atualizar (Midnights midnights) {
		try {
			
			String sql = "update midnights set nome = ? where id = " + midnights.getId();
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, midnights.getNome());
			
			statement.execute();
			connection.commit();
			
		} catch (Exception e) {
			 try {
				  connection.rollback();
				  
			 } catch (SQLException e2) {
				e2.printStackTrace();
			}
			 e.printStackTrace();
		}
	}
	
	public void deletar(int id) {
		try {
			
			String sql = "delete from midnights where id =" + id;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			connection.commit();
			
			
		} catch (Exception e) {
			try {
				connection.rollback();
			}catch (SQLException e1) {
				
				e1.printStackTrace();
			}
				e.printStackTrace();
		}
		
		
	}

}
