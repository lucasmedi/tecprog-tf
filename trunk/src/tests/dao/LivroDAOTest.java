package tests.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import persistence.daoderby.LivroDAOderby;
import persistence.dto.LivroDTO;
import exceptions.ConnectionException;
import exceptions.PersistenceException;

public class LivroDAOTest {
	
	@Test
	public void buscarTodosTest() {
		LivroDAOderby dao = new LivroDAOderby();
		
		List<LivroDTO> list = new ArrayList<>();
		try {
			list = dao.buscarTodos();
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(list.size() > 0);
	}
	
	@Test
	public void buscarPorEditoraTest() {
		LivroDAOderby dao = new LivroDAOderby();
		
		List<LivroDTO> livros = null;
		try {
			livros = dao.buscarPorEditora(1);
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(livros != null);
	}
	
	@Test
	public void buscarPorAutorTest() {
		LivroDAOderby dao = new LivroDAOderby();
		
		List<LivroDTO> livros = null;
		try {
			livros = dao.buscarPorAutor(1);
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(livros != null);
	}
	
	@Test
	public void buscarPorTituloTest() {
		LivroDAOderby dao = new LivroDAOderby();
		
		List<LivroDTO> livros = null;
		try {
			livros = dao.buscarPorTitulo("Harry Potter");
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(livros != null);
	}
	
	@Test
	public void buscarPorCodigoTest() {
		LivroDAOderby dao = new LivroDAOderby();
		
		LivroDTO livro = null;
		try {
			livro = dao.buscarPorCodigo(1);
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(livro != null);
	}
}