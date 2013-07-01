package tests.bo;

import java.util.ArrayList;
import java.util.List;

import mapping.EditoraDAOMapping;

import org.junit.Assert;
import org.junit.Test;

import business.bo.Editora;
import business.daobase.EditoraDAO;
import exceptions.MappingException;

public class EditoraBOTest {
	
	@Test
	public void buscarTodosTest() {
		EditoraDAO dao = new EditoraDAOMapping();
		
		List<Editora> list = new ArrayList<>();
		try {
			list = dao.buscarTodos();
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(!list.isEmpty());
	}
	
	@Test
	public void buscarPorCodigoTest() {
		EditoraDAO dao = new EditoraDAOMapping();
		
		Editora editora = null;
		try {
			editora = dao.buscarPorCodigo(1);
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(editora != null);
	}
	
	@Test
	public void buscarUmPorNomeTest() {
		EditoraDAO dao = new EditoraDAOMapping();
		
		Editora editora = null;
		try {
			editora = dao.buscarUmPorNome("tante");
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(editora != null);
	}
}