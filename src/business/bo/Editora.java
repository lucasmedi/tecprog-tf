package business.bo;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import exceptions.BusinessException;

@ManagedBean
@SessionScoped
public class Editora {
	private int codigo;
	private String nome;
	
	private List<Livro> livros;
	
	//jsf elements
	
	private DataModel<Livro>  listaLivros;
	
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
	
	public List<Livro> getLivros() {
		return livros;
	}

	public DataModel<Livro> getListaLivros() throws BusinessException {
		return new ListDataModel<>(this.getLivros());
	}

	public void setListaLivros(DataModel<Livro> listaLivros) {
		this.listaLivros = listaLivros;
	}
}