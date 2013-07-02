package view;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import business.bo.Autor;
import business.domain.AutorContext;
import business.domain.AutorRepository;
import exceptions.BusinessException;
import exceptions.ConnectionException;

@ManagedBean(name="autorView")
@SessionScoped
public class AutorView extends View {

	private Autor autor;
	private DataModel<Autor> autores;
	private AutorRepository autorRepository;
	private AutorContext autorContext;
	
	public AutorView() throws ConnectionException {
		super();
	}

	@PostConstruct
	public void init() {
		autor = new Autor();
		try {
			autorRepository = new AutorRepository(connection);
			autorContext = new AutorContext(connection);
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage() , null));
		}
	}

	public void cadastrarAutor() throws ConnectionException {
		try {
			if(autor.getCodigo() == 0)
				autorContext.cadastrarAutor(autor);
			else
				autorContext.alterarAutor(autor);

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro feito com sucesso!", null));

			pesquisarAutor();
		} catch (ConnectionException | BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage() , null));
		}
	}


	public void pesquisarAutor() {
		try {
			if((autor.getPrimeiroNome() !=null && !autor.getPrimeiroNome().isEmpty()) && (autor.getUltimoNome() !=null && !autor.getUltimoNome().isEmpty()))
				autores = new ListDataModel<>(autorRepository.buscarPorNome(autor.getPrimeiroNome() + " " + autor.getUltimoNome()));
				else if((autor.getPrimeiroNome() !=null && !autor.getPrimeiroNome().isEmpty()))
					autores = new ListDataModel<>(autorRepository.buscarPorNome(autor.getPrimeiroNome()));
					else if(autor.getUltimoNome() !=null && !autor.getUltimoNome().isEmpty())
						autores = new ListDataModel<>(autorRepository.buscarPorNome(autor.getUltimoNome()));
						else
							autores = new ListDataModel<>(autorRepository.buscarTodos());
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage() , null));
		}
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

	public AutorRepository getAutorRepository() {
		return autorRepository;
	}

	public void setAutorRepository(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}

	public AutorContext getAutorContext() {
		return autorContext;
	}

	public void setAutorContext(AutorContext autorContext) {
		this.autorContext = autorContext;
	}






}
