package business.domain;

import java.util.ArrayList;
import java.util.List;

import mapping.AutorDAOMapping;
import business.bo.Autor;
import business.bo.Editora;
import exceptions.BusinessException;
import exceptions.ConnectionException;
import framework.ConnectionFactory;
import framework.DbType;
import framework.IConnection;

public class AutorRepository {
	private IConnection connection;
	
	public AutorRepository() throws BusinessException, ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		this.connection = connection;
	}
	
	public AutorRepository(IConnection connection) throws BusinessException {
		if (connection == null)
			throw new BusinessException("Conexão não informada.");
		this.connection = connection;
	}
	
	public List<Autor> buscarTodos() throws BusinessException {
		List<Autor> autores = new ArrayList<>();
		
		try {
			AutorDAOMapping autorDAO = new AutorDAOMapping(connection);
			autores = autorDAO.buscarTodos();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		
		return autores;
	}
	
	public List<Autor> buscarPorNome(String nome) throws BusinessException {
		List<Autor> autores = new ArrayList<>();
		
		if (nome == null || nome.isEmpty())
			throw new BusinessException("Nome não informado.");
		
		try {
			AutorDAOMapping autorDAO = new AutorDAOMapping(connection);
			autores = autorDAO.buscarPorNome(nome);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		
		return autores;
	}
	
	public List<Autor> buscarPorEditora(Editora editora) throws BusinessException {
		List<Autor> autores = new ArrayList<>();
		
		if (editora == null || editora.getCodigo() <= 0)
			throw new BusinessException("Editora não informada.");
		
		try {
			AutorDAOMapping autorDAO = new AutorDAOMapping(connection);
			autores = autorDAO.buscarPorEditora(editora);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		
		return autores;
	}
}