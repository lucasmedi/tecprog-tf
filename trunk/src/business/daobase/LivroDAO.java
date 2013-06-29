package business.daobase;

import java.util.List;

import business.bo.Livro;
import exceptions.PersistenceException;

public interface LivroDAO {
	List<Livro> buscarTodos() throws PersistenceException;
	Livro buscarPorCodigo(int codigo) throws PersistenceException;
	List<Livro> buscarPorEditora(int codigo) throws PersistenceException;
	void inserir(Livro livro) throws PersistenceException;
	void alterar(Livro livro) throws PersistenceException;
}