package persistence.daoderby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.base.ConnectionFactory;
import persistence.dto.ItemVendaDTO;
import exceptions.ConnectionException;
import exceptions.PersistenceException;

public class ItemVendaDAOderby {
	
	public List<ItemVendaDTO> buscarPorCodigoVenda(int codigo) throws PersistenceException, ConnectionException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		List<ItemVendaDTO> itensVenda = new ArrayList<>();
		try {
			connection = ConnectionFactory.getInstanceDerby();
			connection.setAutoCommit(true);
			
			String query = "select * from ItensVenda where CodVenda = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, codigo);
			
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				itensVenda.add(parseItemVendaDTO(result));
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
		
		return itensVenda;
	}
	
	public List<ItemVendaDTO> buscarPorCodigoLivro(int codigo) throws PersistenceException, ConnectionException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		List<ItemVendaDTO> itensVenda = new ArrayList<>();
		try {
			connection = ConnectionFactory.getInstanceDerby();
			connection.setAutoCommit(true);
			
			String query = "select * from ItensVenda where CodLivro = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, codigo);
			
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				itensVenda.add(parseItemVendaDTO(result));
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
		
		return itensVenda;
	}
	
	public void inserir(ItemVendaDTO itemVenda) throws PersistenceException, ConnectionException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		int result = 0;
		try {
			connection = ConnectionFactory.getInstanceDerby();
			
			String query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (?, ?, ?)";
			statement = connection.prepareStatement(query);
			statement.setInt(1, itemVenda.getCodigoVenda());
			statement.setInt(2, itemVenda.getCodigoLivro());
			statement.setInt(3, itemVenda.getQuantidade());
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
	
	public void alterar(ItemVendaDTO itemVenda) throws PersistenceException, ConnectionException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		int result = 0;		
		try {
			connection = ConnectionFactory.getInstanceDerby();
			
			String query = "update ItensVenda set Quantidade = ? where CodVenda = ? and CodLivro = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, itemVenda.getQuantidade());
			statement.setInt(2, itemVenda.getCodigoVenda());
			statement.setInt(3, itemVenda.getCodigoLivro());
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
	
	private ItemVendaDTO parseItemVendaDTO(ResultSet o) throws SQLException {
		ItemVendaDTO itemVenda = new ItemVendaDTO();
		itemVenda.setCodigoVenda(o.getInt("CodVenda"));
		itemVenda.setCodigoLivro(o.getInt("CodLivro"));
		itemVenda.setQuantidade(o.getInt("Quantidade"));
		return itemVenda;
	}
}