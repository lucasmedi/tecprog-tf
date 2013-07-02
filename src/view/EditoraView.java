package view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import business.bo.Editora;
import business.domain.EditoraRepository;
import exceptions.BusinessException;
import exceptions.ConnectionException;

@ManagedBean(name="editoraView")
@SessionScoped
public class EditoraView {

	private Editora editora;
	private EditoraRepository editoraRepository;
	private DataModel editoraDataModel;
	
	@PostConstruct
	public void init() {
	    editora = new Editora();
	    try {
			editoraRepository = new EditoraRepository();
		} catch (BusinessException | ConnectionException e) {
			// Mostrar mensagem de erro.
		}
	}
	
	public String cadastrarEditora() {
		editora.setCodigo(0);
		List<Editora> list = new ArrayList<Editora>();
		list.add(editora);
		editoraDataModel = new ListDataModel<>(list);
		return "editora";
	}
	
	public String pesquisarEditora() {
		return "editora";
	}
	
	public void preparaAlterarEditora() {
		editora.setCodigo(1);
		editora.setNome("Giovanni");
		//return "editora";
	}
	
	public String excluirEditora() {
		return "editora";
	}
	
	public Editora getEditora() {
		return editora;
	}
	
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	
	public DataModel getListarEditora() {
		try {
			List<Editora> list = editoraRepository.buscarTodos();
			editoraDataModel = new ListDataModel<>(list);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return getEditoraDataModel();
		
	}
	
	public DataModel getEditoraDataModel() {
		return editoraDataModel;
	}

	public void setEditoraDataModel(DataModel editoraDataModel) {
		this.editoraDataModel = editoraDataModel;
	}	
}