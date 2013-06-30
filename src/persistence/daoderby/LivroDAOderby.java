package persistence.daoderby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import persistence.base.ConnectionFactory;
import persistence.dto.LivroDTO;
import exceptions.ConnectionException;
import exceptions.PersistenceException;

public class LivroDAOderby {

	public List<LivroDTO> buscarTodos() throws PersistenceException, ConnectionException {
		List<LivroDTO> livros = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = ConnectionFactory.getInstanceDerby();
			connection.setAutoCommit(true);
			statement = connection.createStatement();
			
			String query = "select * from Livros";
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				livros.add(parseLivroDTO(result));
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
		
		return livros;
	}
	
	public List<LivroDTO> buscarPorEditora(int codigo) throws PersistenceException, ConnectionException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		List<LivroDTO> livros = new ArrayList<>();
		try {
			connection = ConnectionFactory.getInstanceDerby();
			connection.setAutoCommit(true);
			
			String query = "select * from Livros where CodEditora = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, codigo);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				livros.add(parseLivroDTO(result));
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
		
		return livros;
	}
	
	public List<LivroDTO> buscarPorAutor(int codigo) throws PersistenceException, ConnectionException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		List<LivroDTO> livros = new ArrayList<>();
		try {
			connection = ConnectionFactory.getInstanceDerby();
			connection.setAutoCommit(true);
			
			String query = "select liv.* " +
				"from Livros liv " +
				"inner join LivrosAutores lau on liv.Codigo = lau.CodLivro " +
				"where lau.CodAutor = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, codigo);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				livros.add(parseLivroDTO(result));
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
		
		return livros;
	}
	
	public LivroDTO buscarPorCodigo(int codigo) throws PersistenceException, ConnectionException {
		Connection connection = null;
		PreparedStatement statement = null;
	
		LivroDTO livro = null;
		try {
			connection = ConnectionFactory.getInstanceDerby();
			connection.setAutoCommit(true);
			
			String query = "select * from Livros where Codigo = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1,codigo);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				livro = parseLivroDTO(result);
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
		
		return livro;
	}
	
	public void inserir(LivroDTO livro) throws PersistenceException, ConnectionException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		int result = 0;
		try {
			connection = ConnectionFactory.getInstanceDerby();
			
			String query = "insert into Livros (Titulo, Ano, CodEditora) values (?, ?, ?)";
			statement = connection.prepareStatement(query);
			statement.setString(1, livro.getTitulo());
			statement.setInt(2, livro.getAno());
			statement.setInt(3, livro.getCodigoEditora());
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
	
	public void alterar(LivroDTO livro) throws PersistenceException, ConnectionException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		int result = 0;		
		try {
			connection = ConnectionFactory.getInstanceDerby();
			
			String query = "update Livros set Titulo = ?, Ano = ?, CodEditora = ? where Codigo = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, livro.getTitulo());
			statement.setInt(2, livro.getAno());
			statement.setInt(3, livro.getCodigoEditora());
			statement.setInt(4, livro.getCodigo());
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
	
	private LivroDTO parseLivroDTO(ResultSet o) throws SQLException {
		LivroDTO livro = new LivroDTO();
		livro.setCodigo(o.getInt("Codigo"));
		livro.setTitulo(o.getString("Titulo"));
		livro.setAno(o.getInt("Ano"));
		livro.setCodigoEditora(o.getInt("CodEditora"));
		return livro;
	}
}