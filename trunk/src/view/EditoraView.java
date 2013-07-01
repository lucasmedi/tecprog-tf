package view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import exceptions.BusinessException;

import business.bo.*;
import business.domain.EditoraContext;
import business.domain.EditoraRepository;

@ManagedBean(name="editoraView")
@SessionScoped
public class EditoraView {

	private Editora editora;
	private EditoraRepository editoraRepository;
	private DataModel<Editora> editoraDataModel;
	
	@PostConstruct
	public void init() {
	    editora = new Editora();
	    editoraRepository = new EditoraRepository();
	}
	
	public String cadastrarEditora(){
		editora.setCodigo(0);
		List<Editora> list = new ArrayList<Editora>();
		list.add(editora);
		editoraDataModel = new ListDataModel<>(list);
		return "editora";
	}
	
	public String pesquisarEditora(){
		return "editora";
	}
	
	public void preparaAlterarEditora(){
		editora.setCodigo(1);
		editora.setNome("Giovanni");
		//return "editora";
	}
	
	public String excluirEditora(){
		return "editora";
	}
	
	public Editora getEditora() {
		return editora;
	}
	
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	
	public DataModel<Editora> getListarEditora(){
		try {
			setEditoraDataModel(new ListDataModel<>(editoraRepository.buscarTodos()));
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return getEditoraDataModel();
		
	}
	
	
	public DataModel<Editora> getEditoraDataModel() {
		return editoraDataModel;
	}

	public void setEditoraDataModel(DataModel<Editora> editoraDataModel) {
		this.editoraDataModel = editoraDataModel;
	}
	
	
	
}
