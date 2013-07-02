package business.domain;

import mapping.EditoraDAOMapping;
import business.bo.Editora;
import business.daobase.EditoraDAO;
import exceptions.BusinessException;
import exceptions.MappingException;
import framework.IConnection;

public class EditoraContext {

	private IConnection connection;
	
	public EditoraContext(IConnection connection) {
		this.connection = connection;
	}
	
	public void cadastrarEditora(Editora editora) throws BusinessException {
		if (editora.getNome() == null || editora.getNome().isEmpty())
			throw new BusinessException("Nome n�o informado.");
		
		Editora res = null;
		try {
			res = new EditoraDAOMapping(connection).buscarUmPorNome(editora.getNome());
		} catch (MappingException e) {
			throw new BusinessException("Erro ao buscar editora.", e);
		}
		
		if (res != null)
			throw new BusinessException("Editora j� cadastrada.");
		
		EditoraDAO dao = new EditoraDAOMapping(connection);
		try {
			dao.inserir(editora);
		} catch (MappingException e) {
			throw new BusinessException("Erro ao cadastrar editora.", e);
		}
	}
	
	public void alterarEditora(Editora editora) throws BusinessException {
		if (editora.getCodigo() <= 0)
			throw new BusinessException("Editora n�o informada.");
		
		if (editora.getNome() == null || editora.getNome().isEmpty())
			throw new BusinessException("Nome n�o informado.");
		
		EditoraDAO dao = new EditoraDAOMapping(connection);
		try {
			dao.alterar(editora);
		} catch (MappingException e) {
			throw new BusinessException("Erro ao alterar editora.", e);
		}
	}
}