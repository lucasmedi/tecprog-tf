package view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;

import business.bo.Autor;

@ManagedBean(name="autorView")
@SessionScoped
public class AutorView {

	private Autor autor;
	private DataModel<Autor> autorDataModel;
	
	@PostConstruct
	public void init(){
		autor = new Autor();
	}
	 
	public String cadastrarAutor(){
		return "autor";
	}
	public String pesquisarAutor(){
		return "autor";
	}
	public DataModel<Autor> getListarAutor(){
		return getAutorDataModel();
	}
	public String preparaAlterarAutor(){
		return "autor";
	}
	public String excluirAutor(){
		return "autor";
	}
	
	public Autor getAutor() {
		return autor;
	}
	
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	public DataModel<Autor> getAutorDataModel() {
		return autorDataModel;
	}
	
	public void setAutorDataModel(DataModel<Autor> autorDataModel) {
		this.autorDataModel = autorDataModel;
	}
	
	
}
