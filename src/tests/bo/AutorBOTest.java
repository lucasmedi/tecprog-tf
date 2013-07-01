package tests.bo;

import java.util.ArrayList;
import java.util.List;

import mapping.AutorDAOMapping;

import org.junit.Assert;
import org.junit.Test;

import business.bo.Autor;
import business.daobase.AutorDAO;
import exceptions.MappingException;

public class AutorBOTest {
	
	@Test
	public void buscarTodosTest() {
		AutorDAO dao = new AutorDAOMapping();
		
		List<Autor> list = new ArrayList<>();
		try {
			list = dao.buscarTodos();
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		
		Assert.assertTrue(!list.isEmpty());
	}
	
	@Test
	public void buscarPorNomeTest() {
		AutorDAO dao = new AutorDAOMapping();
		
		List<Autor> list = new ArrayList<>();
		try {
			list = dao.buscarPorNome("Philip");
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(!list.isEmpty());
	}
	
	@Test
	public void buscarPorCodigoTest() {
		AutorDAO dao = new AutorDAOMapping();
		
		Autor autor = null;
		try {
			autor = dao.buscarPorCodigo(1);
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(autor != null);
	}
	
	@Test
	public void buscarUmPorNomeTest() {
		AutorDAO dao = new AutorDAOMapping();
		
		Autor autor = null;
		try {
			autor = dao.buscarUmPorNome("Joanne Row");
		} catch (MappingException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(autor != null);
	}
}