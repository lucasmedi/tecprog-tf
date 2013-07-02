package tests.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import persistence.daoderby.LivroDAOderby;
import persistence.dto.LivroDTO;
import exceptions.ConnectionException;
import exceptions.PersistenceException;
import framework.ConnectionFactory;
import framework.DbType;
import framework.IConnection;

public class LivroDAOTest {
	
	@Test
	public void buscarTodosTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		
		LivroDAOderby dao = new LivroDAOderby(connection);
		
		List<LivroDTO> list = new ArrayList<>(0);
		try {
			list = dao.buscarTodos();
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		connection.close();
		
		Assert.assertTrue(list.size() > 0);
	}
	
	@Test
	public void buscarPorEditoraTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		
		LivroDAOderby dao = new LivroDAOderby(connection);
		
		List<LivroDTO> livros = null;
		try {
			livros = dao.buscarPorEditora(1);
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		connection.close();
		
		Assert.assertTrue(livros != null);
	}
	
	@Test
	public void buscarPorAutorTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		
		LivroDAOderby dao = new LivroDAOderby(connection);
		
		List<LivroDTO> livros = null;
		try {
			livros = dao.buscarPorAutor(1);
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		connection.close();
		
		Assert.assertTrue(livros != null);
	}
	
	@Test
	public void buscarPorTituloTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		
		LivroDAOderby dao = new LivroDAOderby(connection);
		
		List<LivroDTO> livros = null;
		try {
			livros = dao.buscarPorTitulo("Harry Potter");
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		connection.close();
		
		Assert.assertTrue(livros != null);
	}
	
	@Test
	public void buscarPorCodigoTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		
		LivroDAOderby dao = new LivroDAOderby(connection);
		
		LivroDTO livro = null;
		try {
			livro = dao.buscarPorCodigo(1);
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		connection.close();
		
		Assert.assertTrue(livro != null);
	}
	
	@Test
	public void buscarLivroPorTituloTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		
		LivroDAOderby dao = new LivroDAOderby(connection);
		
		LivroDTO livro = null;
		try {
			livro = dao.buscarLivroPorTitulo("Antic");
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		connection.close();
		
		Assert.assertTrue(livro != null);
	}
}