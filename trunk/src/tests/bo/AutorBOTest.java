package tests.bo;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import mapping.AutorDAOMapping;

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
		
		Assert.assertTrue(list.size() > 0);
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
		
		Assert.assertTrue(list != null && list.size() > 0);
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
}