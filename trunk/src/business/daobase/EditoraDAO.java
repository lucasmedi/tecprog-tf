package business.daobase;

import java.util.List;

import business.bo.Editora;
import exceptions.MappingException;

public interface EditoraDAO {
	List<Editora> buscarTodos() throws MappingException;
	Editora buscarPorCodigo(int codigo) throws MappingException;
	Editora buscarUmPorNome(String nome) throws MappingException;
	int inserir(Editora editora) throws MappingException;
	void alterar(Editora editora) throws MappingException;
}