package tests.bo;

import java.util.ArrayList;
import java.util.List;

import mapping.VendaDAOMapping;

import org.junit.Assert;
import org.junit.Test;

import business.bo.Venda;
import exceptions.ConnectionException;
import exceptions.MappingException;
import framework.ConnectionFactory;
import framework.DbType;
import framework.IConnection;

public class VendaBOTest {
	
	@Test
	public void buscarTodosTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
			
		VendaDAOMapping dao = new VendaDAOMapping(connection);
			
		List<Venda> list = new ArrayList<>(0);
		try {
			list = dao.buscarTodos();
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(list.size() > 0);
	}
	
	@Test
	public void buscarPorCodigoTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
			
		VendaDAOMapping dao = new VendaDAOMapping(connection);
			
		Venda venda = null;
		try {
			venda = dao.buscarPorCodigo(1);
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(venda != null);
	}
}