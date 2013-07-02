package view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import business.bo.Autor;
import business.domain.AutorRepository;
import exceptions.BusinessException;
import exceptions.ConnectionException;

@ManagedBean(name="autorView")
@SessionScoped
public class AutorView extends View {

	private Autor autor;
	private DataModel<Autor> autores;
	private AutorRepository autorRepository;

	public AutorView() throws ConnectionException {
		super();
	}
	
	@PostConstruct
	public void init() {
		autor = new Autor();
	    try {
	    	autorRepository = new AutorRepository(connection);
		} catch (BusinessException e) {
			// Mostrar mensagem de erro.
		}
	}
	 
	public String cadastrarAutor(){
		return "autor";
	}
	
	public void pesquisarAutor() {
		try {
			autores = new ListDataModel<>(autorRepository.buscarTodos());
			//editoraDataModel = new ListDataModel<>(list);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}
	
	public String preparaAlterarAutor(){
		return "autor";
	}
	
	public String excluirAutor(){
		return "autor";
	}
	
	
	//GETs and SETs
	public Autor getAutor() {
		return autor;
	}
	
	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public DataModel<Autor> getAutores() {
		return autores;
	}

	public void setAutores(DataModel<Autor> autores) {
		this.autores = autores;
	}

	
	
	
	
	
}
