package business.daobase;

import java.util.List;

import business.bo.Autor;
import exceptions.PersistenceException;

public interface AutorDAO {
	List<Autor> buscarTodos() throws PersistenceException;
	Autor buscarPorCodigo(int codigo) throws PersistenceException;
	List<Autor> buscarPorNome(String nome) throws PersistenceException;
	void inserir(Autor autor) throws PersistenceException;
	void alterar(Autor autor) throws PersistenceException;
}