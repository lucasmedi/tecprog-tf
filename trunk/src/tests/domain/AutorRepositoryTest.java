package tests.domain;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import business.bo.Autor;
import business.domain.AutorRepository;
import exceptions.BusinessException;
import exceptions.ConnectionException;

public class AutorRepositoryTest {
	
	@Test
	public void buscarTodosTest() throws BusinessException, ConnectionException {
		AutorRepository repo = new AutorRepository();
		List<Autor> autores = repo.buscarTodos(); 
		
		Assert.assertTrue(!autores.isEmpty());
	}
	
	@Test
	public void buscarPorNomeTest() throws BusinessException, ConnectionException {
		AutorRepository repo = new AutorRepository();
		List<Autor> autores = repo.buscarPorNome("Frank");
		
		Assert.assertTrue(!autores.isEmpty());
	}
}