package business.bo;

import java.util.List;

import mapping.LivroDAOMapping;
import exceptions.BusinessException;
import exceptions.MappingException;

public class Editora {
	private int codigo;
	private String nome;
	
	private List<Livro> livros;
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Livro> getLivros() throws BusinessException {
		if (livros == null)
			try {
				livros = (new LivroDAOMapping()).buscarPorEditora(this.codigo);
			} catch (MappingException e) {
				throw new BusinessException(e);
			}
		return livros;
	}
}