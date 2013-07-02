package view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import exceptions.BusinessException;
import exceptions.ConnectionException;
import business.bo.Autor;
import business.bo.Editora;
import business.domain.AutorRepository;
import business.domain.EditoraRepository;

@ManagedBean(name="autorView")
@SessionScoped
public class AutorView {

	private Autor autor;
	private DataModel<Autor> autores;
	private AutorRepository autorRepository;
	
	@PostConstruct
	public void init() {
		autor = new Autor();
	    try {
	    	autorRepository = new AutorRepository();
		} catch (BusinessException | ConnectionException e) {
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
