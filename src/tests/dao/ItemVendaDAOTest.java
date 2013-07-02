package tests.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import persistence.daoderby.ItemVendaDAOderby;
import persistence.dto.ItemVendaDTO;
import exceptions.ConnectionException;
import exceptions.PersistenceException;
import framework.ConnectionFactory;
import framework.DbType;
import framework.IConnection;

public class ItemVendaDAOTest {
	
	@Test
	public void buscarPorCodigoLivroTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
			
		ItemVendaDAOderby dao = new ItemVendaDAOderby(connection);
			
		List<ItemVendaDTO> list = new ArrayList<>(0);
		try {
			list = dao.buscarPorCodigoLivro(1);
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(list.size() > 0);
	}
	
	@Test
	public void buscarPorCodigoVendaTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
			
		ItemVendaDAOderby dao = new ItemVendaDAOderby(connection);
		
		List<ItemVendaDTO> list = new ArrayList<>(0);
		try {
			list = dao.buscarPorCodigoVenda(1);
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}

		Assert.assertTrue(list.size() > 0);
	}
}