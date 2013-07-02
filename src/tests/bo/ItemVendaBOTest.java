package tests.bo;

import java.util.ArrayList;
import java.util.List;

import mapping.ItemVendaDAOMapping;

import org.junit.Assert;
import org.junit.Test;

import business.bo.ItemVenda;
import exceptions.ConnectionException;
import exceptions.MappingException;
import framework.ConnectionFactory;
import framework.DbType;
import framework.IConnection;

public class ItemVendaBOTest {
	
	@Test
	public void buscarPorCodigoLivroTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
			
		ItemVendaDAOMapping dao = new ItemVendaDAOMapping(connection);
			
		List<ItemVenda> list = new ArrayList<>(0);
		try {
			list = dao.buscarPorCodigoLivro(1);
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(list.size() > 0);
	}
	
	@Test
	public void buscarPorCodigoVendaTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
			
		ItemVendaDAOMapping dao = new ItemVendaDAOMapping(connection);
		
		List<ItemVenda> list = new ArrayList<>();
		try {
			list = dao.buscarPorCodigoVenda(1);
		} catch (MappingException e) {
			e.printStackTrace();
		}

		Assert.assertTrue(list.size() > 0);
	}
}
