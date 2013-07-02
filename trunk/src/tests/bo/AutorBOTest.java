package tests.bo;

import java.util.ArrayList;
import java.util.List;

import mapping.AutorDAOMapping;

import org.junit.Assert;
import org.junit.Test;

import business.bo.Autor;
import business.bo.Editora;
import business.daobase.AutorDAO;
import exceptions.ConnectionException;
import exceptions.MappingException;
import framework.ConnectionFactory;
import framework.DbType;
import framework.IConnection;

public class AutorBOTest {
	
	@Test
	public void buscarTodosTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		
		AutorDAO dao = new AutorDAOMapping(connection);
		
		List<Autor> list = new ArrayList<>(0);
		try {
			list = dao.buscarTodos();
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		
		Assert.assertTrue(!list.isEmpty());
	}
	
	@Test
	public void buscarPorNomeTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		
		AutorDAO dao = new AutorDAOMapping(connection);
		
		List<Autor> list = new ArrayList<>();
		try {
			list = dao.buscarPorNome("Philip");
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(!list.isEmpty());
	}
	
	@Test
	public void buscarPorEditoraTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		
		AutorDAO dao = new AutorDAOMapping(connection);
		
		List<Autor> list = new ArrayList<>();
		try {
			Editora editora = new Editora();
			editora.setCodigo(1);
			list = dao.buscarPorEditora(editora);
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(!list.isEmpty());
	}
	
	@Test
	public void buscarPorCodigoTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		
		AutorDAO dao = new AutorDAOMapping(connection);
		
		Autor autor = null;
		try {
			autor = dao.buscarPorCodigo(1);
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(autor != null);
	}
	
	@Test
	public void buscarUmPorNomeTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		
		AutorDAO dao = new AutorDAOMapping(connection);
		
		Autor autor = null;
		try {
			autor = dao.buscarUmPorNome("Joanne Row");
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(autor != null);
	}
}