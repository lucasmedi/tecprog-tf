package business.daobase;

import java.util.List;

import business.bo.Livro;
import exceptions.MappingException;

public interface LivroDAO {
	List<Livro> buscarTodos() throws MappingException;
	List<Livro> buscarPorEditora(int codigo) throws MappingException;
	List<Livro> buscarPorAutor(int codigo) throws MappingException;
	List<Livro> buscarPorTitulo(String titulo) throws MappingException;
	Livro buscarPorCodigo(int codigo) throws MappingException;
	void inserir(Livro livro) throws MappingException;
	void alterar(Livro livro) throws MappingException;
}