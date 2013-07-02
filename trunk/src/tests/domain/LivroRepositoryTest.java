package tests.domain;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import business.bo.Livro;
import business.domain.LivroRepository;
import exceptions.BusinessException;
import exceptions.ConnectionException;
import framework.ConnectionFactory;
import framework.DbType;
import framework.IConnection;

public class LivroRepositoryTest {
	
	@Test
	public void buscarTodos() throws BusinessException, ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		LivroRepository repo = new LivroRepository(connection);
		List<Livro> livros = repo.buscarTodos();
		
		Assert.assertTrue(!livros.isEmpty());
	}
	
	@Test
	public void buscarLivrosPorAutorTest() throws BusinessException, ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		LivroRepository repo = new LivroRepository(connection);
		List<Livro> livros = repo.buscarLivrosPorAutor("John Tolkien");
		
		Assert.assertTrue(!livros.isEmpty());
	}
	
	@Test
	public void buscarLivrosPorEditoraTest() throws BusinessException, ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		LivroRepository repo = new LivroRepository(connection);
		List<Livro> livros = repo.buscarLivrosPorEditora("Leitura");
		
		Assert.assertTrue(!livros.isEmpty());
	}
	
	@Test
	public void buscarLivrosPorTituloTest() throws BusinessException, ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		LivroRepository repo = new LivroRepository(connection);
		List<Livro> livros = repo.buscarLivrosPorTitulo("O Senhor");
		
		Assert.assertTrue(!livros.isEmpty());
	}
}