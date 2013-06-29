package persistence.daoderby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.base.ConnectionFactory;
import persistence.dto.LivroAutorDTO;
import exceptions.ConnectionException;
import exceptions.PersistenceException;

public class LivroAutorDAOderby {
	
	public List<LivroAutorDTO> buscarPorCodigoAutor(int codigo) throws PersistenceException, ConnectionException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		List<LivroAutorDTO> livroAutor = new ArrayList<>();
		try {
			connection = ConnectionFactory.getInstanceDerby();
			
			String query = "select * from LivrosAutores where CodAutor = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, codigo);
			
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				livroAutor.add(parseLivroAutorDTO(result));
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
		
		return livroAutor;
	}
	
	public List<LivroAutorDTO> buscarPorCodigoLivro(int codigo) throws PersistenceException, ConnectionException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		List<LivroAutorDTO> livroAutor = new ArrayList<>();
		try {
			connection = ConnectionFactory.getInstanceDerby();
			
			String query = "select * from LivrosAutores where CodLivro = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, codigo);
			
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				livroAutor.add(parseLivroAutorDTO(result));
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
		
		return livroAutor;
	}
	
	public void inserir(LivroAutorDTO livroAutor) throws PersistenceException, ConnectionException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		int result = 0;
		try {
			connection = ConnectionFactory.getInstanceDerby();
			
			String query = "insert into LivrosAutores (CodAutor, CodLivro) values (?, ?)";
			statement = connection.prepareStatement(query);
			statement.setInt(1, livroAutor.getCodigoAutor());
			statement.setInt(1, livroAutor.getCodigoLivro());
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
	
	public void deletar(LivroAutorDTO livroAutor) throws PersistenceException, ConnectionException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		int result = 0;		
		try {
			connection = ConnectionFactory.getInstanceDerby();
			
			String query = "delete LivrosAutores where CodAutor = ? and CodLivro = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, livroAutor.getCodigoAutor());
			statement.setInt(2, livroAutor.getCodigoLivro());
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
	
	private LivroAutorDTO parseLivroAutorDTO(ResultSet o) throws SQLException {
		LivroAutorDTO livroAutor = new LivroAutorDTO();
		livroAutor.setCodigoAutor(o.getInt("CodAutor"));
		livroAutor.setCodigoLivro(o.getInt("CodLivro"));
		return livroAutor;
	}
}
