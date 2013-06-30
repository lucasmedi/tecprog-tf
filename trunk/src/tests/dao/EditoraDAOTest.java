package tests.dao;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import persistence.daoderby.EditoraDAOderby;
import persistence.dto.EditoraDTO;
import exceptions.ConnectionException;
import exceptions.PersistenceException;

public class EditoraDAOTest {
	
	@Test
	public void buscarTodosTest() {
		EditoraDAOderby dao = new EditoraDAOderby();
		
		List<EditoraDTO> list = new ArrayList<>();
		try {
			list = dao.buscarTodos();
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(list.size() > 0);
	}
	
	@Test
	public void buscarPorCodigoTest() {
		EditoraDAOderby dao = new EditoraDAOderby();
		
		EditoraDTO editora = null;
		try {
			editora = dao.buscarPorCodigo(1);
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(editora != null);
	}
	
	@Test
	public void buscarUmPorNomeTest() {
		EditoraDAOderby dao = new EditoraDAOderby();
		
		EditoraDTO editora = null;
		try {
			editora = dao.buscarUmPorNome("Rocco");
		} catch (PersistenceException | ConnectionException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(editora != null);
	}
}
