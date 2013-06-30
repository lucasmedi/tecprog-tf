package persistence.daoderby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import persistence.base.ConnectionFactory;
import persistence.dto.EditoraDTO;
import exceptions.ConnectionException;
import exceptions.PersistenceException;

public class EditoraDAOderby {

	public List<EditoraDTO> buscarTodos() throws PersistenceException, ConnectionException {
		List<EditoraDTO> editoras = new ArrayList<EditoraDTO>();
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = ConnectionFactory.getInstanceDerby();
			connection.setAutoCommit(true);
			statement = connection.createStatement();
			
			String query = "select * from Editoras";
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				editoras.add(parseEditoraDTO(result));
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
		
		return editoras;
	}

	public EditoraDTO buscarPorCodigo(int codigo) throws PersistenceException, ConnectionException {
		Connection connection = null;
		PreparedStatement statement = null;
	
		EditoraDTO editora = null;
		try {
			connection = ConnectionFactory.getInstanceDerby();
			connection.setAutoCommit(true);
			
			String query = "select * from Editoras where Codigo = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, codigo);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				editora = parseEditoraDTO(result);
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
		
		return editora;
	}
	
	public EditoraDTO buscarUmPorNome(String nome) throws PersistenceException, ConnectionException {
		Connection connection = null;
		PreparedStatement statement = null;
	
		EditoraDTO editora = null;
		try {
			connection = ConnectionFactory.getInstanceDerby();
			connection.setAutoCommit(true);
			
			String query = "select * from Editoras where Nome like ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, "%" + nome + "%");
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				editora = parseEditoraDTO(result);
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
		
		return editora;
	}

	public void inserir(EditoraDTO ed) throws PersistenceException, ConnectionException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		int result = 0;
		try {
			connection = ConnectionFactory.getInstanceDerby();
		
			String query = "insert into Editoras (Nome) values (?)";
			statement = connection.prepareStatement(query);
			statement.setString(1, ed.getNome());
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
	
	public void alterar(EditoraDTO ed) throws PersistenceException, ConnectionException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		int result = 0;		
		try {
			connection = ConnectionFactory.getInstanceDerby();

			String query = "update Editoras set Nome = ? where Codigo = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, ed.getNome());
			statement.setInt(2, ed.getCodigo());
			result = statement.executeUpdate();
			
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				throw new ConnectionException("Erro ao encerrar conexão com a base de dados.", e);
			}
			throw new PersistenceException("Erro ao executar a atualização: " + e.getMessage(), e);
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
	
	private EditoraDTO parseEditoraDTO(ResultSet o) throws SQLException {
		EditoraDTO editora = new EditoraDTO();
		editora.setCodigo(o.getInt("Codigo"));
		editora.setNome(o.getString("Nome"));
		return editora;
	}
}