package view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import business.bo.Editora;
import business.bo.Livro;
import business.domain.EditoraRepository;
import business.domain.LivroContext;
import business.domain.LivroRepository;
import exceptions.BusinessException;
import exceptions.ConnectionException;

@ManagedBean(name="livroView")
@SessionScoped
public class LivroView extends View {
	
	private Livro livro;
	private LivroContext livroContext;
	private LivroRepository livroRepository;
	private EditoraRepository editoraRepository;
	private DataModel<Livro> livros;
	private List<SelectItem> editoras;
	private int editoraSelecionada;
		
	public LivroView() throws ConnectionException {
		super();
	}
	
	@PostConstruct
	public void init() {
		livro = new Livro();
		try {
			livroRepository = new LivroRepository(connection);
			livroContext = new LivroContext(connection);
			editoraRepository = new EditoraRepository(connection);
			livro.setEditora(new Editora());
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage() , null));
		}
	}

	public void cadastrarLivro(){
		
	}
	
	public void pesquisarLivro(){
		List<Livro> list = null;
		try{
			if(livro.getTitulo() != null && !livro.getTitulo().isEmpty())
				list = livroRepository.buscarLivrosPorTitulo(livro.getTitulo());
			else
				list = livroRepository.buscarTodos();
			
			livros= new ListDataModel<>(list);
				
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage() , null));
		}
	}
	
	//GETs and SETs
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public LivroContext getLivroContext() {
		return livroContext;
	}

	public void setLivroContext(LivroContext livroContext) {
		this.livroContext = livroContext;
	}

	public LivroRepository getLivroRepository() {
		return livroRepository;
	}

	public void setLivroRepository(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	public DataModel<Livro> getLivros() {
		return livros;
	}

	public void setLivros(DataModel<Livro> livros) {
		this.livros = livros;
	}
	
	public List<SelectItem> getEditoras() {
		try {
			List<Editora> list = editoraRepository.buscarTodos();
			editoras = new ArrayList<SelectItem>();
			for (Editora editora : list) {
				editoras.add(new SelectItem(editora.getCodigo(), editora.getNome()));
			}
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage() , null));
		}
		return editoras;
	}
	
	
	public void setEditoras(List<SelectItem> editoras) {
		this.editoras = editoras;
	}
	
	
	public EditoraRepository getEditoraRepository() {
		return editoraRepository;
	}


	public void setEditoraRepository(EditoraRepository editoraRepository) {
		this.editoraRepository = editoraRepository;
	}

	public int getEditoraSelecionada() {
		return editoraSelecionada;
	}

	public void setEditoraSelecionada(int editoraSelecionada) {
		this.editoraSelecionada = editoraSelecionada;
	}
	
	
	
}
