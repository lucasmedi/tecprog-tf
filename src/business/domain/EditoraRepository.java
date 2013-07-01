package business.domain;

import java.util.ArrayList;
import java.util.List;

import mapping.EditoraDAOMapping;
import business.bo.Editora;
import exceptions.BusinessException;

public class EditoraRepository {
	public List<Editora> buscarTodos() throws BusinessException {
		List<Editora> editoras = new ArrayList<>();
		
		try {
			EditoraDAOMapping editoraDAO = new EditoraDAOMapping();
			editoras = editoraDAO.buscarTodos();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		
		return editoras;
	}
	
	public List<Editora> buscarPorNome(String nome) throws BusinessException {
		List<Editora> editoras = new ArrayList<>();
		
		if (nome == null || nome.isEmpty())
			throw new BusinessException("Nome não informado.");
		
		try {
			EditoraDAOMapping editoraDAO = new EditoraDAOMapping();
			editoras = editoraDAO.buscarPorNome(nome);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		
		return editoras;
	}
}