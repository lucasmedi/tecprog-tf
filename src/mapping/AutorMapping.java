package mapping;

import java.util.List;

import business.bo.Autor;
import business.daobase.AutorDAO;
import exceptions.PersistenceException;

public class AutorMapping implements AutorDAO {

	@Override
	public List<Autor> buscarTodos() throws PersistenceException {
		return null;
	}

	@Override
	public Autor buscarPorCodigo(int codigo) throws PersistenceException {
		return null;
	}

	@Override
	public List<Autor> buscarPorNome(String nome) throws PersistenceException {
		return null;
	}

	@Override
	public void inserir(Autor autor) throws PersistenceException {
		
	}

	@Override
	public void alterar(Autor autor) throws PersistenceException {
		
	}	
}