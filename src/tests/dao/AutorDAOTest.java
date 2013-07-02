package tests.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import persistence.daoderby.AutorDAOderby;
import persistence.dto.AutorDTO;
import persistence.dto.EditoraDTO;
import exceptions.ConnectionException;
import exceptions.PersistenceException;
import framework.ConnectionFactory;
import framework.DbType;
import framework.IConnection;

public class AutorDAOTest {
	
	@Test
	public void buscarTodosTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
			
		AutorDAOderby dao = new AutorDAOderby(connection);
			
		List<AutorDTO> list = new ArrayList<>(0);
		try {
			list = dao.buscarTodos();
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		connection.close();
		
		Assert.assertTrue(list.size() > 0);
	}
	
	@Test
	public void buscarPorNomeTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
	
		AutorDAOderby dao = new AutorDAOderby(connection);
		
		List<AutorDTO> list = new ArrayList<>(0);
		try {
			list = dao.buscarPorNome("Philip");
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		connection.close();
		
		Assert.assertTrue(list.size() > 0);
	}
	
	@Test
	public void buscarPorEditoraTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
	
		AutorDAOderby dao = new AutorDAOderby(connection);
		
		List<AutorDTO> list = new ArrayList<>(0);
		try {
			EditoraDTO dto = new EditoraDTO();
			dto.setCodigo(1);
			list = dao.buscarPorEditora(dto);
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		connection.close();
		
		Assert.assertTrue(list.size() > 0);
	}
	
	@Test
	public void buscarPorCodigoTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		
		AutorDAOderby dao = new AutorDAOderby(connection);
		
		AutorDTO autor = null;
		try {
			autor = dao.buscarPorCodigo(1);
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		connection.close();
		
		Assert.assertTrue(autor != null);
	}
	
	@Test
	public void buscarUmPorNomeTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		
		AutorDAOderby dao = new AutorDAOderby(connection);
		
		AutorDTO autor = null;
		try {
			autor = dao.buscarUmPorNome("n Tol");
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		connection.close();
		
		Assert.assertTrue(autor != null);
	}
}