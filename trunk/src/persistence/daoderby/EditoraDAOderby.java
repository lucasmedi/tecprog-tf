package persistence.daoderby;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import persistence.dto.EditoraDTO;
import exceptions.ConnectionException;
import exceptions.PersistenceException;
import framework.IConnection;

public class EditoraDAOderby {
	
	private IConnection connection;
	
	public EditoraDAOderby(IConnection connection) {
		this.connection = connection;
	}
	
	public List<EditoraDTO> buscarTodos() throws PersistenceException, ConnectionException {
		List<EditoraDTO> editoras = new ArrayList<EditoraDTO>(0);
		Statement statement = null;
		
		try {
			statement = connection.getConnection().createStatement();
			
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
			} catch (SQLException e) {
				throw new ConnectionException("Erro ao encerrar conexão com a base de dados.", e);
			}
		}
		
		return editoras;
	}
	
	public List<EditoraDTO> buscarPorNome(String nome) throws PersistenceException, ConnectionException {
		List<EditoraDTO> editoras = new ArrayList<EditoraDTO>(0);
		PreparedStatement statement = null;
		
		try {
			String query = "select * from Editoras where Nome like ?";
			statement = connection.getConnection().prepareStatement(query);
			statement.setString(1, "%" + nome + "%");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				editoras.add(parseEditoraDTO(result));
			}
		} catch (Exception e) {
			throw new PersistenceException("Erro ao executar busca: " + e.getMessage(), e);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new ConnectionException("Erro ao encerrar conexão com a base de dados.", e);
			}
		}
		
		return editoras;
	}

	public EditoraDTO buscarPorCodigo(int codigo) throws PersistenceException, ConnectionException {
		PreparedStatement statement = null;
	
		EditoraDTO editora = null;
		try {
			String query = "select * from Editoras where Codigo = ?";
			statement = connection.getConnection().prepareStatement(query);
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
			} catch (SQLException e) {
				throw new ConnectionException("Erro ao encerrar conexão com a base de dados.", e);
			}
		}
		
		return editora;
	}
	
	public EditoraDTO buscarUmPorNome(String nome) throws PersistenceException, ConnectionException {
		PreparedStatement statement = null;
	
		EditoraDTO editora = null;
		try {
			String query = "select * from Editoras where Nome like ?";
			statement = connection.getConnection().prepareStatement(query);
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
			} catch (SQLException e) {
				throw new ConnectionException("Erro ao encerrar conexão com a base de dados.", e);
			}
		}
		
		return editora;
	}

	public int inserir(EditoraDTO ed) throws PersistenceException, ConnectionException {
		PreparedStatement statement = null;
		ResultSet generatedKeys = null;
		int id = 0;
		
		int result = 0;
		try {
			String query = "insert into Editoras (Nome) values (?)";
			statement = connection.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, ed.getNome());
			result = statement.executeUpdate();
			
			generatedKeys = statement.getGeneratedKeys();
	        if (generatedKeys.next())
	            id = generatedKeys.getInt(1);
		} catch (Exception e) {
			throw new PersistenceException("Erro ao executar inserção: " + e.getMessage(), e);
		} finally {
			try {
				generatedKeys.close();
				statement.close();
			} catch (SQLException e) {
				throw new ConnectionException("Erro ao encerrar conexão com a base de dados.", e);
			}
		}
		
		if (result == 0)
			throw new PersistenceException("Erro ao executar inserção.");
		
		return id;
	}
	
	public void alterar(EditoraDTO ed) throws PersistenceException, ConnectionException {
		PreparedStatement statement = null;
		
		int result = 0;		
		try {
			String query = "update Editoras set Nome = ? where Codigo = ?";
			statement = connection.getConnection().prepareStatement(query);
			statement.setString(1, ed.getNome());
			statement.setInt(2, ed.getCodigo());
			result = statement.executeUpdate();
		} catch (Exception e) {
			throw new PersistenceException("Erro ao executar a atualização: " + e.getMessage(), e);
		} finally {
			try {
				statement.close();
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