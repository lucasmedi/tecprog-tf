package business.domain;

import mapping.LivroDAOMapping;
import business.bo.Editora;
import business.bo.Livro;
import exceptions.BusinessException;
import exceptions.MappingException;

public class LivroContext {
	public void cadastrarLivro(Livro livro) throws BusinessException {
		if (livro == null)
			throw new BusinessException("Livro n�o informado.");
		
		if (livro.getTitulo() == null || livro.getTitulo().isEmpty())
			throw new BusinessException("Titulo n�o informado.");
		
		if (livro.getAno() <= 0)
			throw new BusinessException("Ano n�o informado.");
		
		Editora editora = livro.getEditora();
		if (editora == null)
			throw new BusinessException("Editora n�o informada.");
		
		LivroDAOMapping dao = new LivroDAOMapping();
		try {
			dao.inserir(livro);
		} catch (MappingException e) {
			throw new BusinessException("Erro ao cadastrar Livro.");
		}
	}
	
	public void alterarLivro(Livro livro) throws BusinessException {
		if (livro == null || livro.getCodigo() <= 0)
			throw new BusinessException("Livro n�o informado.");
		
		if (livro.getTitulo() == null || livro.getTitulo().isEmpty())
			throw new BusinessException("Titulo n�o informado.");
		
		if (livro.getAno() <= 0)
			throw new BusinessException("Ano n�o informado.");
		
		Editora editora = livro.getEditora();
		if (editora == null)
			throw new BusinessException("Editora n�o informada.");
		
		LivroDAOMapping dao = new LivroDAOMapping();
		try {
			dao.alterar(livro);
		} catch (MappingException e) {
			throw new BusinessException("Erro ao alterar Livro.");
		}
	}
}