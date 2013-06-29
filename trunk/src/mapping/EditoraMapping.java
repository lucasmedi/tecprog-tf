package mapping;

import java.util.List;

import business.bo.Editora;
import business.daobase.EditoraDAO;
import exceptions.PersistenceException;

public class EditoraMapping implements EditoraDAO {

	@Override
	public List<Editora> buscarTodos() throws PersistenceException {
		return null;
	}

	@Override
	public Editora buscarPorCodigo(int codigo) throws PersistenceException {
		return null;
	}

	@Override
	public void inserir(Editora editora) throws PersistenceException {
		
	}

	@Override
	public void alterar(Editora editora) throws PersistenceException {
		
	}
}