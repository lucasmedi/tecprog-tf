package tests.domain;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import business.bo.Autor;
import business.bo.Editora;
import business.domain.AutorRepository;
import exceptions.BusinessException;
import exceptions.ConnectionException;
import framework.ConnectionFactory;
import framework.DbType;
import framework.IConnection;

public class AutorRepositoryTest {
	
	@Test
	public void buscarTodosTest() throws BusinessException, ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		AutorRepository repo = new AutorRepository(connection);
		List<Autor> autores = repo.buscarTodos(); 
		
		Assert.assertTrue(!autores.isEmpty());
		
		connection.close();
	}
	
	@Test
	public void buscarPorNomeTest() throws BusinessException, ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		AutorRepository repo = new AutorRepository(connection);
		List<Autor> autores = repo.buscarPorNome("Frank");
		
		Assert.assertTrue(!autores.isEmpty());
		
		connection.close();
	}
	
	@Test
	public void buscarPorEditoraTest() throws BusinessException, ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		AutorRepository repo = new AutorRepository(connection);
		Editora editora = new Editora();
		editora.setCodigo(1);
		
		List<Autor> autores = repo.buscarPorEditora(editora);
		
		Assert.assertTrue(!autores.isEmpty());
		
		connection.close();
	}
}