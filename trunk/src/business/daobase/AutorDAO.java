package business.daobase;

import java.util.List;

import business.bo.Autor;
import business.bo.Editora;
import exceptions.MappingException;

public interface AutorDAO {
	List<Autor> buscarTodos() throws MappingException;
	List<Autor> buscarPorNome(String nome) throws MappingException;
	List<Autor> buscarPorEditora(Editora editora) throws MappingException;
	Autor buscarPorCodigo(int codigo) throws MappingException;
	Autor buscarUmPorNome(String nome) throws MappingException;
	int inserir(Autor autor) throws MappingException;
	void alterar(Autor autor) throws MappingException;
}