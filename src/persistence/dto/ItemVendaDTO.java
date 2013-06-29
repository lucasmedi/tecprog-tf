package persistence.dto;

public class ItemVendaDTO {
	private int codigoVenda;
	private int codigoLivro;
	private int quantidade;
	
	public int getCodigoVenda() {
		return codigoVenda;
	}
	
	public void setCodigoVenda(int codigoVenda) {
		this.codigoVenda = codigoVenda;
	}
	
	public int getCodigoLivro() {
		return codigoLivro;
	}
	
	public void setCodigoLivro(int codigoLivro) {
		this.codigoLivro = codigoLivro;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}