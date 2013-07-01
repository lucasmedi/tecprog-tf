package view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import business.bo.*;

@ManagedBean(name="editoraView")
@SessionScoped
public class EditoraView {

	private Editora editora;
	private DataModel<Editora> editoras;
	
	@PostConstruct
	public void init() {
	    editora = new Editora();
	}
	
	public String inserirEditora(){
		System.out.println("-----" + editora.getNome());
		editora.setCodigo(0);
		List<Editora> list = new ArrayList<Editora>();
		list.add(editora);
		editoras = new ListDataModel<>(list);
		return "editora";
	}
	
	
	public void alterarEditora(){
		//return "editora";
	}
	
	public void preparaAlterarEditora(){
		editora.setCodigo(1);
		editora.setNome("Giovanni");
		//return "editora";
	}
	
	public String excluirEditora(){
		return "editora";
	}
	public DataModel<Editora> getListarEditora(){
		return editoras;
	}
	
	public Editora getEditora() {
		return editora;
	}
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	public DataModel<Editora> getEditoras() {
		return editoras;
	}
	public void setEditoras(DataModel<Editora> editoras) {
		this.editoras = editoras;
	}
	
}
