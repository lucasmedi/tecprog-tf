package business.bo;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

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