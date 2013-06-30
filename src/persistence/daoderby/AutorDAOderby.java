package persistence.daoderby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import persistence.base.ConnectionFactory;
import persistence.dto.AutorDTO;
import exceptions.ConnectionException;
import exceptions.PersistenceException;

public class AutorDAOderby {

	public List<AutorDTO> buscarTodos() throws PersistenceException, ConnectionException {
		List<AutorDTO> autores = new ArrayList<AutorDTO>();
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = ConnectionFactory.getInstanceDerby();
			connection.setAutoCommit(true);
			statement = connection.createStatement();
			
			String query = "select * from Autores";
			
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				autores.add(parseAutorDTO(result));
			}
		} catch (Exception e) {
			throw new PersistenceException("Erro ao executar busca: " + e.getMessage(), e);
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new ConnectionException("Erro ao encerrar conexão com a base de dados.", e);
			}
		}
		
		return autores;
	}
	
	public List<AutorDTO> buscarPorNome(String nome) throws PersistenceException, ConnectionException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		List<AutorDTO> autores = new ArrayList<>();
		try {
			connection = ConnectionFactory.getInstanceDerby();
			connection.setAutoCommit(true);
			
			String query = "select * from Autores where PrimeiroNome like ? or UltimoNome like ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, nome);
			statement.setString(2, nome);
			
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				autores.add(parseAutorDTO(result));
			}
		} catch (Exception e) {
			throw new PersistenceException("Erro ao executar busca: " + e.getMessage(), e);
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new ConnectionException("Erro ao encerrar conexão com a base de dados.", e);
			}
		}

		return autores;
	}
	
	public AutorDTO buscarPorCodigo(int codigo) throws PersistenceException, ConnectionException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		AutorDTO autor = null;
		try {
			connection = ConnectionFactory.getInstanceDerby();
			connection.setAutoCommit(true);
			
			String query = "select * from Autores where Codigo = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, codigo);
			
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				autor = parseAutorDTO(result);
			}
		} catch (Exception e) {
			throw new PersistenceException("Erro ao executar busca: " + e.getMessage(), e);
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new ConnectionException("Erro ao encerrar conexão com a base de dados.", e);
			}
		}
		
		return autor;
	}
	
	public AutorDTO buscarUmPorNome(String nome) throws PersistenceException, ConnectionException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		AutorDTO autor = null;
		try {
			connection = ConnectionFactory.getInstanceDerby();
			connection.setAutoCommit(true);
			
			String query = "select * from Autores where PrimeiroNome || ' ' || UltimoNome like ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, "%" + nome + "%");
			
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				autor = parseAutorDTO(result);
			}
		} catch (Exception e) {
			throw new PersistenceException("Erro ao executar busca: " + e.getMessage(), e);
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new ConnectionException("Erro ao encerrar conexão com a base de dados.", e);
			}
		}
		
		return autor;
	}
	
	public void inserir(AutorDTO autor) throws PersistenceException, ConnectionException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		int result = 0;
		try {
			connection = ConnectionFactory.getInstanceDerby();
			
			String query = "insert into Autores (PrimeiroNome, UltimoNome) values (?, ?)";
			statement = connection.prepareStatement(query);
			statement.setString(1, autor.getPrimeiroNome());
			statement.setString(2, autor.getUltimoNome());
			result = statement.executeUpdate();
			
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				throw new ConnectionException("Erro ao encerrar conexão com a base de dados.", e);
			}
			throw new PersistenceException("Erro ao executar inserção: " + e.getMessage(), e);
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new ConnectionException("Erro ao encerrar conexão com a base de dados.", e);
			}
		}
		
		if (result == 0)
			throw new PersistenceException("Erro ao executar inserção.");
	}
	
	public void alterar(AutorDTO autor) throws PersistenceException, ConnectionException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		int result = 0;		
		try {
			connection = ConnectionFactory.getInstanceDerby();
			
			String query = "update Autores set PrimeiroNome = ?, UltimoNome = ? where Codigo = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, autor.getPrimeiroNome());
			statement.setString(2, autor.getUltimoNome());
			statement.setInt(3, autor.getCodigo());
			result = statement.executeUpdate();
			
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				throw new ConnectionException("Erro ao encerrar conexão com a base de dados.", e);
			}
			throw new PersistenceException("Erro ao executar a atualização: " + e.getMessage() , e);
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new ConnectionException("Erro ao encerrar conexão com a base de dados.", e);
			}
		}
		
		if (result == 0)
			throw new PersistenceException("Erro ao executar a atualização.");
	}
	
	private AutorDTO parseAutorDTO(ResultSet o) throws SQLException {
		AutorDTO autor = new AutorDTO();
		autor.setCodigo(o.getInt("Codigo"));
		autor.setPrimeiroNome(o.getString("PrimeiroNome"));
		autor.setUltimoNome(o.getString("UltimoNome"));
		return autor;
	}
}