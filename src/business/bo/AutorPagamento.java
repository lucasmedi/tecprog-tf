package business.bo;

public class AutorPagamento {
	private Autor autor;
	private double valor;
	
	public AutorPagamento(Autor autor, Double valor) {
		this.autor = autor;
		this.valor = valor;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}