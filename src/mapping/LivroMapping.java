package mapping;

import java.util.List;

import business.bo.Livro;
import business.daobase.LivroDAO;
import exceptions.PersistenceException;

public class LivroMapping implements LivroDAO {

	@Override
	public List<Livro> buscarTodos() throws PersistenceException {
		return null;
	}

	@Override
	public Livro buscarPorCodigo(int codigo) throws PersistenceException {
		return null;
	}

	@Override
	public List<Livro> buscarPorEditora(int codigo) throws PersistenceException {
		return null;
	}

	@Override
	public void inserir(Livro livro) throws PersistenceException {
		
	}

	@Override
	public void alterar(Livro livro) throws PersistenceException {
		
	}
}