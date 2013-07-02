package tests.bo;

import java.util.ArrayList;
import java.util.List;

import mapping.LivroDAOMapping;

import org.junit.Assert;
import org.junit.Test;

import business.bo.Livro;
import business.daobase.LivroDAO;
import exceptions.ConnectionException;
import exceptions.MappingException;
import framework.ConnectionFactory;
import framework.DbType;
import framework.IConnection;

public class LivroBOTest {
	
	@Test
	public void buscarTodosTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		
		LivroDAO dao = new LivroDAOMapping(connection);
		
		List<Livro> list = new ArrayList<>();
		try {
			list = dao.buscarTodos();
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(!list.isEmpty());
	}
	
	@Test
	public void buscarPorEditoraTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		
		LivroDAO dao = new LivroDAOMapping(connection);
		
		List<Livro> livros = null;
		try {
			livros = dao.buscarPorEditora(1);
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(!livros.isEmpty());
	}
	
	@Test
	public void buscarPorAutorTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		
		LivroDAO dao = new LivroDAOMapping(connection);
		
		List<Livro> livros = null;
		try {
			livros = dao.buscarPorAutor(1);
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(!livros.isEmpty());
	}
	
	@Test
	public void buscarPorTituloTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		
		LivroDAO dao = new LivroDAOMapping(connection);
		
		List<Livro> livros = null;
		try {
			livros = dao.buscarPorTitulo("Duna");
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(!livros.isEmpty());
	}
	
	@Test
	public void buscarPorCodigoTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		
		LivroDAO dao = new LivroDAOMapping(connection);
		
		Livro livro = null;
		try {
			livro = dao.buscarPorCodigo(1);
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(livro != null);
	}
}