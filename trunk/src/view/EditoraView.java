package view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
			editoraRepository = new EditoraRepository(this.connection);
		} catch (BusinessException e) {
			// Mostrar mensagem de erro.
		}
	}
 
	public String cadastrarEditora() {
		try {
			if(editora.getCodigo() == 0)
				editoraContext.cadastrarEditora(editora);
			else
				editoraContext.alterarEditora(editora);
			pesquisarEditora();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return "editora";
	}

	public void pesquisarEditora() {
		try {
			editoras= new ListDataModel<>(editoraRepository.buscarTodos());
			//editoraDataModel = new ListDataModel<>(list);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

	public String preparaAlterarEditora() {
		editora = editoras.getRowData();
		return "editora";
	}

	public String excluirEditora() {
		return "editora";
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