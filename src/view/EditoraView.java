package view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;

import business.bo.Editora;

@ManagedBean
@SessionScoped
public class EditoraView {

	private Editora editora;
	private DataModel<Editora> editoras;
	
	public String inserirEditora(){
		editora = new Editora();
		System.out.println("-----" + editora.getNome());
		return "Sucesso";
	}
	public String alterarEditora(){
		return "Sucesso";
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
