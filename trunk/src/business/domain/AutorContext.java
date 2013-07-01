package business.domain;

import mapping.AutorDAOMapping;
import business.bo.Autor;
import exceptions.BusinessException;
import exceptions.MappingException;

public class AutorContext {
	public void cadastrarAutor(Autor autor) throws BusinessException {
		if (autor == null)
			throw new BusinessException("Autor não informado.");
		
		if (autor.getPrimeiroNome() == null || autor.getPrimeiroNome().isEmpty())
			throw new BusinessException("Primeiro nome não informado.");
		
		if (autor.getUltimoNome() == null || autor.getUltimoNome().isEmpty())
			throw new BusinessException("Último nome não informado.");
		
		AutorDAOMapping dao = new AutorDAOMapping();
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
		
		AutorDAOMapping dao = new AutorDAOMapping();
		try {
			dao.alterar(autor);
		} catch (MappingException e) {
			throw new BusinessException("Erro ao alterar Autor.");
		}
	}
}