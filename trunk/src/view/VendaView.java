package view;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import business.bo.ItemVenda;
import business.bo.Livro;
import business.bo.Venda;
import business.domain.VendaContext;
import business.domain.VendaRepository;
import exceptions.BusinessException;
import exceptions.ConnectionException;

@ManagedBean(name="vendaView")
@SessionScoped
public class VendaView extends View {

	private Venda venda;
	private VendaRepository vendaRepository;
	private VendaContext vendaContext;
	private DataModel<Venda> vendas;
	
	private ItemVenda itemVenda;
	private Livro livro;
	private String nomeLivro;
	private int quantidade;
	

	public VendaView() throws ConnectionException {
		super();
	}
	
	@PostConstruct
	public void init() {
		venda = new Venda();
		try {
			vendaRepository = new VendaRepository(connection);
			vendaContext = new VendaContext(connection);
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage() , null));
		}
	}
 
	public void cadastrarVenda() {
		/*try {
			if(venda.getCodigo() == 0)
				vendaContext.cadastrarVenda(venda);
			else
				vendaContext.alterarVenda(venda);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro feito com sucesso!", null));
			
			pesquisarVenda();
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage() , null));
		}
		//return "venda";*/
	}

	public void pesquisarVenda() {
		try {
			vendas= new ListDataModel<>(vendaRepository.buscarTodos());
				
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage() , null));
		}
	}

	//GETs and SETs 
	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public VendaRepository getVendaRepository() {
		return vendaRepository;
	}

	public void setVendaRepository(VendaRepository vendaRepository) {
		this.vendaRepository = vendaRepository;
	}

	public VendaContext getVendaContext() {
		return vendaContext;
	}

	public void setVendaContext(VendaContext vendaContext) {
		this.vendaContext = vendaContext;
	}

	public DataModel<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(DataModel<Venda> vendas) {
		this.vendas = vendas;
	}

	public ItemVenda getItemVenda() {
		return itemVenda;
	}

	public void setItemVenda(ItemVenda itemVenda) {
		this.itemVenda = itemVenda;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	
	

}