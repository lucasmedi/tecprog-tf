package tests.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import persistence.daoderby.VendaDAOderby;
import persistence.dto.VendaDTO;
import exceptions.ConnectionException;
import exceptions.PersistenceException;
import framework.ConnectionFactory;
import framework.DbType;
import framework.IConnection;

public class VendaDAOTest {
	
	@Test
	public void buscarTodosTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
			
		VendaDAOderby dao = new VendaDAOderby(connection);
			
		List<VendaDTO> list = new ArrayList<>(0);
		try {
			list = dao.buscarTodos();
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		connection.close();
		
		Assert.assertTrue(list.size() > 0);
	}
	
	@Test
	public void buscarPorCodigoTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
			
		VendaDAOderby dao = new VendaDAOderby(connection);
			
		VendaDTO venda = null;
		try {
			venda = dao.buscarPorCodigo(1);
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		connection.close();
		
		Assert.assertTrue(venda != null);
	}
}