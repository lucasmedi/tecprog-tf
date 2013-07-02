package business.domain;

import mapping.LivroDAOMapping;
import business.bo.Editora;
import business.bo.Livro;
import exceptions.BusinessException;
import exceptions.ConnectionException;
import exceptions.MappingException;
import framework.ConnectionFactory;
import framework.DbType;
import framework.IConnection;

public class LivroContext {
	
	private IConnection connection;
	
	public LivroContext() throws BusinessException, ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		this.connection = connection;
	}
	
	public LivroContext(IConnection connection) throws BusinessException {
		if (connection == null)
			throw new BusinessException("Conexão não informada.");
		this.connection = connection;
	}
	
	public void cadastrarLivro(Livro livro) throws BusinessException {
		if (livro == null)
			throw new BusinessException("Livro não informado.");
		
		if (livro.getTitulo() == null || livro.getTitulo().isEmpty())
			throw new BusinessException("Titulo não informado.");
		
		if (livro.getAno() <= 0)
			throw new BusinessException("Ano não informado.");
		
		Editora editora = livro.getEditora();
		if (editora == null)
			throw new BusinessException("Editora não informada.");
		
		LivroDAOMapping dao = new LivroDAOMapping(connection);
		try {
			dao.inserir(livro);
		} catch (MappingException e) {
			throw new BusinessException("Erro ao cadastrar Livro.");
		}
	}
	
	public void alterarLivro(Livro livro) throws BusinessException {
		if (livro == null || livro.getCodigo() <= 0)
			throw new BusinessException("Livro não informado.");
		
		if (livro.getTitulo() == null || livro.getTitulo().isEmpty())
			throw new BusinessException("Titulo não informado.");
		
		if (livro.getAno() <= 0)
			throw new BusinessException("Ano não informado.");
		
		Editora editora = livro.getEditora();
		if (editora == null)
			throw new BusinessException("Editora não informada.");
		
		LivroDAOMapping dao = new LivroDAOMapping(connection);
		try {
			dao.alterar(livro);
		} catch (MappingException e) {
			throw new BusinessException("Erro ao alterar Livro.");
		}
	}
}