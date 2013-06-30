package tests.dao;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import persistence.daoderby.AutorDAOderby;
import persistence.dto.AutorDTO;
import exceptions.ConnectionException;
import exceptions.PersistenceException;

public class AutorDAOTest {
	
	@Test
	public void buscarTodosTest() {
		AutorDAOderby dao = new AutorDAOderby();
		
		List<AutorDTO> list = new ArrayList<>();
		try {
			list = dao.buscarTodos();
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(list.size() > 0);
	}
	
	@Test
	public void buscarPorNomeTest() {
		AutorDAOderby dao = new AutorDAOderby();
		
		List<AutorDTO> list = new ArrayList<>();
		try {
			list = dao.buscarPorNome("Philip");
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(list.size() > 0);
	}
	
	@Test
	public void buscarPorCodigoTest() {
		AutorDAOderby dao = new AutorDAOderby();
		
		AutorDTO autor = null;
		try {
			autor = dao.buscarPorCodigo(1);
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(autor != null);
	}
	
	@Test
	public void buscarUmPorNomeTest() {
		AutorDAOderby dao = new AutorDAOderby();
		
		AutorDTO autor = null;
		try {
			autor = dao.buscarUmPorNome("n Tol");
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(autor != null);
	}
}