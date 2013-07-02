package view;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import business.bo.Editora;
import business.domain.EditoraContext;
import business.domain.EditoraRepository;
import exceptions.BusinessException;
import exceptions.ConnectionException;

@ManagedBean(name="editoraView")
@SessionScoped
public class EditoraView extends View {

	private Editora editora;
	private EditoraRepository editoraRepository;
	private EditoraContext editoraContext;
	private DataModel<Editora> editoras;

	public EditoraView() throws ConnectionException {
		super();
	}
	
	@PostConstruct
	public void init() {
		editora = new Editora();
		try {
			editoraRepository = new EditoraRepository(connection);
			editoraContext = new EditoraContext(connection);
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage() , null));
		}
	}
 
	public void cadastrarEditora() {
		try {
			if(editora.getCodigo() == 0)
				editoraContext.cadastrarEditora(editora);
			else
				editoraContext.alterarEditora(editora);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro feito com sucesso!", null));
			
			pesquisarEditora();
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage() , null));
		}
		//return "editora";
	}

	public void pesquisarEditora() {
		try {
			if(editora.getNome() !=null && !editora.getNome().isEmpty())
				editoras= new ListDataModel<>(editoraRepository.buscarPorNome(editora.getNome()));
			else
				editoras= new ListDataModel<>(editoraRepository.buscarTodos());
				
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage() , null));
		}
	}


	//GETs and SETs 
	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	public EditoraRepository getEditoraRepository() {
		return editoraRepository;
	}

	public void setEditoraRepository(EditoraRepository editoraRepository) {
		this.editoraRepository = editoraRepository;
	}

	public DataModel<Editora> getEditoras() {
		return editoras;
	}

	public void setEditoras(DataModel<Editora> editoras) {
		this.editoras = editoras;
	}


}