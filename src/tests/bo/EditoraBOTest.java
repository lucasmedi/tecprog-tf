package tests.bo;

import java.util.ArrayList;
import java.util.List;

import mapping.EditoraDAOMapping;

import org.junit.Assert;
import org.junit.Test;

import business.bo.Editora;
import business.daobase.EditoraDAO;
import exceptions.ConnectionException;
import exceptions.MappingException;
import framework.ConnectionFactory;
import framework.DbType;
import framework.IConnection;

public class EditoraBOTest {
	
	@Test
	public void buscarTodosTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		
		EditoraDAO dao = new EditoraDAOMapping(connection);
		
		List<Editora> list = new ArrayList<>(0);
		try {
			list = dao.buscarTodos();
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		connection.close();
		
		Assert.assertTrue(!list.isEmpty());
	}
	
	@Test
	public void buscarPorNomeTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		
		EditoraDAO dao = new EditoraDAOMapping(connection);
		
		List<Editora> list = new ArrayList<>();
		try {
			list = dao.buscarPorNome("Rocco");
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		connection.close();
		
		Assert.assertTrue(!list.isEmpty());
	}
	
	@Test
	public void buscarPorCodigoTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		
		EditoraDAO dao = new EditoraDAOMapping(connection);
		
		Editora editora = null;
		try {
			editora = dao.buscarPorCodigo(1);
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		connection.close();
		
		Assert.assertTrue(editora != null);
	}
	
	@Test
	public void buscarUmPorNomeTest() throws ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		
		EditoraDAO dao = new EditoraDAOMapping(connection);
		
		Editora editora = null;
		try {
			editora = dao.buscarUmPorNome("tante");
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		connection.close();
		
		Assert.assertTrue(editora != null);
	}
}