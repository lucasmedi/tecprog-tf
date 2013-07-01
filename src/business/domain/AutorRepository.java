package business.domain;

import java.util.ArrayList;
import java.util.List;

import mapping.AutorDAOMapping;
import business.bo.Autor;
import exceptions.BusinessException;

public class AutorRepository {
	public List<Autor> buscarTodos() throws BusinessException {
		List<Autor> autores = new ArrayList<>();
		
		try {
			AutorDAOMapping autorDAO = new AutorDAOMapping();
			autores = autorDAO.buscarTodos();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		
		return autores;
	}
	
	public List<Autor> buscarPorNome(String nome) throws BusinessException {
		List<Autor> autores = new ArrayList<>();
		
		if (nome == null || nome.isEmpty())
			throw new BusinessException("Nome não informado.");
		
		try {
			AutorDAOMapping autorDAO = new AutorDAOMapping();
			autores = autorDAO.buscarPorNome(nome);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		
		return autores;
	}
}