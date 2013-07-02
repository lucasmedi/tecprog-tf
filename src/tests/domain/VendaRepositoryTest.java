package tests.domain;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import business.bo.Venda;
import business.domain.VendaRepository;
import exceptions.BusinessException;
import exceptions.ConnectionException;
import framework.ConnectionFactory;
import framework.DbType;
import framework.IConnection;

public class VendaRepositoryTest {
	
	@Test
	public void buscarTodosTest() throws ConnectionException, BusinessException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		VendaRepository repo = new VendaRepository(connection);
		List<Venda> vendas = repo.buscarTodos();
		
		Assert.assertTrue(!vendas.isEmpty());
		
		connection.close();
	}
}