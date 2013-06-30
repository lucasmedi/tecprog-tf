package tests.domain;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import business.bo.Livro;
import domain.LivroRepository;
import exceptions.BusinessException;

public class LivroRepositoryTest {
	
	@Test
	public void buscarLivrosPorAutorTest() throws BusinessException {
		LivroRepository repo = new LivroRepository();
		List<Livro> livros = repo.buscarLivrosPorAutor("John Tolkien");
		
		Assert.assertTrue(!livros.isEmpty());
	}
	
	@Test
	public void buscarLivrosPorEditoraTest() throws BusinessException {
		LivroRepository repo = new LivroRepository();
		List<Livro> livros = repo.buscarLivrosPorEditora("Leitura");
		
		Assert.assertTrue(!livros.isEmpty());
	}
	
	@Test
	public void buscarLivrosPorTituloTest() throws BusinessException {
		LivroRepository repo = new LivroRepository();
		List<Livro> livros = repo.buscarLivrosPorTitulo("O Senhor");
		
		Assert.assertTrue(!livros.isEmpty());
	}
}