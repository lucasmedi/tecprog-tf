package business.domain;

import mapping.AutorDAOMapping;
import business.bo.Autor;
import exceptions.BusinessException;
import exceptions.ConnectionException;
import exceptions.MappingException;
import framework.IConnection;

public class AutorContext {
	private IConnection connection;
	
	public AutorContext(IConnection connection) throws BusinessException {
		if (connection == null)
			throw new BusinessException("Conexão não informada.");
		this.connection = connection;
	}
	
	public void cadastrarAutor(Autor autor) throws BusinessException, ConnectionException {
		if (autor == null)
			throw new BusinessException("Autor não informado.");
		
		if (autor.getPrimeiroNome() == null || autor.getPrimeiroNome().isEmpty())
			throw new BusinessException("Primeiro nome não informado.");
		
		if (autor.getUltimoNome() == null || autor.getUltimoNome().isEmpty())
			throw new BusinessException("Último nome não informado.");
		
		AutorDAOMapping dao = new AutorDAOMapping(connection);
		try {
			dao.inserir(autor);
		} catch (MappingException e) {
			throw new BusinessException("Erro ao cadastrar Autor.");
		}
	}
	
	public void alterarAutor(Autor autor) throws BusinessException {
		if (autor == null || autor.getCodigo() <= 0)
			throw new BusinessException("Autor não informado.");
		
		if (autor.getPrimeiroNome() == null || autor.getPrimeiroNome().isEmpty())
			throw new BusinessException("Primeiro nome não informado.");
		
		if (autor.getUltimoNome() == null || autor.getUltimoNome().isEmpty())
			throw new BusinessException("Último nome não informado.");
		
		AutorDAOMapping dao = new AutorDAOMapping(connection);
		try {
			dao.alterar(autor);
		} catch (MappingException e) {
			throw new BusinessException("Erro ao alterar Autor.");
		}
	}
}