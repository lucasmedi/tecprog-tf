package tests.bo;

import java.util.ArrayList;
import java.util.List;

import mapping.LivroDAOMapping;

import org.junit.Assert;
import org.junit.Test;

import business.bo.Livro;
import business.daobase.LivroDAO;
import exceptions.MappingException;

public class LivroBOTest {
	
	@Test
	public void buscarTodosTest() {
		LivroDAO dao = new LivroDAOMapping();
		
		List<Livro> list = new ArrayList<>();
		try {
			list = dao.buscarTodos();
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(!list.isEmpty());
	}
	
	@Test
	public void buscarPorEditoraTest() {
		LivroDAO dao = new LivroDAOMapping();
		
		List<Livro> livros = null;
		try {
			livros = dao.buscarPorEditora(1);
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(!livros.isEmpty());
	}
	
	@Test
	public void buscarPorAutorTest() {
		LivroDAO dao = new LivroDAOMapping();
		
		List<Livro> livros = null;
		try {
			livros = dao.buscarPorAutor(1);
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(!livros.isEmpty());
	}
	
	@Test
	public void buscarPorTituloTest() {
		LivroDAO dao = new LivroDAOMapping();
		
		List<Livro> livros = null;
		try {
			livros = dao.buscarPorTitulo("Duna");
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(!livros.isEmpty());
	}
	
	@Test
	public void buscarPorCodigoTest() {
		LivroDAO dao = new LivroDAOMapping();
		
		Livro livro = null;
		try {
			livro = dao.buscarPorCodigo(1);
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(livro != null);
	}
}