package tests.domain;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import business.bo.Editora;
import business.domain.EditoraRepository;
import exceptions.BusinessException;
import exceptions.ConnectionException;
import framework.ConnectionFactory;
import framework.DbType;
import framework.IConnection;

public class EditoraRepositoryTest {
	
	@Test
	public void buscarTodosTest() throws BusinessException, ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		EditoraRepository repo = new EditoraRepository(connection);
		List<Editora> editoras = repo.buscarTodos();
		
		Assert.assertTrue(!editoras.isEmpty());
		
		connection.close();
	}
	
	@Test
	public void buscarPorNomeTest() throws BusinessException, ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		EditoraRepository repo = new EditoraRepository(connection);
		List<Editora> editoras = repo.buscarPorNome("Sext");
		
		Assert.assertTrue(!editoras.isEmpty());
		
		connection.close();
	}
}