package business.daobase;

import java.util.List;

import business.bo.Editora;
import exceptions.PersistenceException;

public interface EditoraDAO {
	List<Editora> buscarTodos() throws PersistenceException;
	Editora buscarPorCodigo(int codigo) throws PersistenceException;
	void inserir(Editora editora) throws PersistenceException;
	void alterar(Editora editora) throws PersistenceException;
}