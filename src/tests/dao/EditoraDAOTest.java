package tests.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import persistence.daoderby.EditoraDAOderby;
import persistence.dto.EditoraDTO;
import exceptions.ConnectionException;
import exceptions.PersistenceException;
import framework.ConnectionFactory;
import framework.DbType;
import framework.IConnection;

public class EditoraDAOTest {
	
	@Test
	public void buscarTodosTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		
		EditoraDAOderby dao = new EditoraDAOderby(connection);
		
		List<EditoraDTO> list = new ArrayList<>(0);
		try {
			list = dao.buscarTodos();
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(list.size() > 0);
	}
	
	@Test
	public void buscarPorNomeTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		
		EditoraDAOderby dao = new EditoraDAOderby(connection);
		
		List<EditoraDTO> list = new ArrayList<>();
		try {
			list = dao.buscarPorNome("Ponto");
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(list.size() > 0);
	}
	
	@Test
	public void buscarPorCodigoTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		
		EditoraDAOderby dao = new EditoraDAOderby(connection);
		
		EditoraDTO editora = null;
		try {
			editora = dao.buscarPorCodigo(1);
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(editora != null);
	}
	
	@Test
	public void buscarUmPorNomeTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		
		EditoraDAOderby dao = new EditoraDAOderby(connection);
		
		EditoraDTO editora = null;
		try {
			editora = dao.buscarUmPorNome("Rocco");
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(editora != null);
	}
}
