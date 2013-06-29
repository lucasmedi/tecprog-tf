package mapping;

import java.util.List;

import business.bo.Venda;
import business.daobase.VendaDAO;
import exceptions.PersistenceException;

public class VendaMapping implements VendaDAO {

	@Override
	public List<Venda> buscarTodos() throws PersistenceException {
		return null;
	}

	@Override
	public Venda buscarPorCodigo(int codigo) throws PersistenceException {
		return null;
	}

	@Override
	public void inserir(Venda venda) throws PersistenceException {
		
	}

	@Override
	public void alterar(Venda venda) throws PersistenceException {
		
	}
}