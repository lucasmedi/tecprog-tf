package persistence.daoderby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import persistence.base.ConnectionFactory;
import persistence.dto.VendaDTO;
import exceptions.ConnectionException;
import exceptions.PersistenceException;

public class VendaDAOderby {

	public List<VendaDTO> buscarTodos() throws PersistenceException, ConnectionException {
		List<VendaDTO> vendas = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = ConnectionFactory.getInstanceDerby();
			statement = connection.createStatement();
			
			String query = "select * from Vendas";
			
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				vendas.add(parseVendaDTO(result));
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
		
		return vendas;
	}
	
	public VendaDTO buscarPorCodigo(int codigo) throws PersistenceException, ConnectionException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		VendaDTO venda = null;
		try {
			connection = ConnectionFactory.getInstanceDerby();
			
			String query = "select * from Vendas where Codigo = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, codigo);
			
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				venda = parseVendaDTO(result);
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
		
		return venda;
	}
	
	public void inserir(VendaDTO venda) throws PersistenceException, ConnectionException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		int result = 0;
		try {
			connection = ConnectionFactory.getInstanceDerby();
			
			String query = "insert into Vendas (Codigo, NomeCliente, CpfCliente, CnpjCliente, Data) values (?, ?, ?, ?, SYSDATE)";
			statement = connection.prepareStatement(query);
			statement.setInt(1, venda.getCodigo());
			statement.setString(2, venda.getNomeCliente());
			statement.setString(3, venda.getCpfCliente());
			statement.setString(4, venda.getCnpjCliente());
			result = statement.executeUpdate();
		} catch (Exception e) {
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
	
	public void alterar(VendaDTO venda) throws PersistenceException, ConnectionException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		int result = 0;		
		try {
			connection = ConnectionFactory.getInstanceDerby();
			
			String query = "update Vendas set NomeCliente = ?, CpfCliente = ?, CnpjCliente = ? where Codigo = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, venda.getNomeCliente());
			statement.setString(2, venda.getCpfCliente());
			statement.setString(3, venda.getCnpjCliente());
			statement.setInt(4, venda.getCodigo());
			result = statement.executeUpdate();
		} catch (Exception e) {
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
	
	private VendaDTO parseVendaDTO(ResultSet o) throws SQLException {
		VendaDTO venda = new VendaDTO();
		venda.setCodigo(o.getInt("Codigo"));
		venda.setNomeCliente(o.getString("NomeCliente"));
		venda.setCpfCliente(o.getString("CpfCliente"));
		venda.setCnpjCliente(o.getString("CnpjCliente"));
		venda.setData(o.getDate("Data"));
		return venda;
	}
}