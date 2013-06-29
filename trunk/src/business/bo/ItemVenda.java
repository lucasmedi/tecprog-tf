package business.bo;

public class ItemVenda {
	private Venda venda;
	private Livro livro;
	private int Quantidade;
	
	public Venda getVenda() {
		return venda;
	}
	
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public int getQuantidade() {
		return Quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}
}