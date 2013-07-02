package tests.domain;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import business.bo.Editora;
import business.domain.EditoraRepository;
import exceptions.BusinessException;
import exceptions.ConnectionException;

public class EditoraRepositoryTest {
	
	@Test
	public void buscarTodosTest() throws BusinessException, ConnectionException {
		EditoraRepository repo = new EditoraRepository();
		List<Editora> editoras = repo.buscarTodos();
		
		Assert.assertTrue(!editoras.isEmpty());
	}
	
	@Test
	public void buscarPorNomeTest() throws BusinessException, ConnectionException {
		EditoraRepository repo = new EditoraRepository();
		List<Editora> editoras = repo.buscarPorNome("Sext");
		
		Assert.assertTrue(!editoras.isEmpty());
	}
}
