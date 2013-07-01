package business.domain;

import java.util.ArrayList;
import java.util.List;

import mapping.AutorDAOMapping;
import mapping.EditoraDAOMapping;
import mapping.LivroDAOMapping;
import business.bo.Autor;
import business.bo.Editora;
import business.bo.Livro;
import exceptions.BusinessException;

public class LivroRepository {
	public List<Livro> buscarLivrosPorAutor(String nome) throws BusinessException {
		List<Livro> livros = new ArrayList<>();
		
		AutorDAOMapping autorDAO = new AutorDAOMapping();
		try {
			Autor autor = autorDAO.buscarUmPorNome(nome);
			if (autor == null)
				throw new BusinessException("Autor não encontrado");
			
			LivroDAOMapping livroDAO = new LivroDAOMapping();
			livros = livroDAO.buscarPorAutor(autor.getCodigo());
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		
		return livros;
	}
	
	public List<Livro> buscarLivrosPorEditora(String nome) throws BusinessException {
		List<Livro> livros = new ArrayList<>();
		
		EditoraDAOMapping editoraDAO = new EditoraDAOMapping();
		try {
			Editora editora = editoraDAO.buscarUmPorNome(nome);
			if (editora == null)
				throw new BusinessException("Editora não encontradas");
			
			LivroDAOMapping livroDAO = new LivroDAOMapping();
			livros = livroDAO.buscarPorEditora(editora.getCodigo());
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		
		return livros;
	}
	
	public List<Livro> buscarLivrosPorTitulo(String titulo) throws BusinessException {
		List<Livro> livros = new ArrayList<>();
		
		try {
			LivroDAOMapping livroDAO = new LivroDAOMapping();
			livros = livroDAO.buscarPorTitulo(titulo);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		
		return livros;
	}
}