package persistence.dto;

public class LivroDTO {
	private int codigo;
	private String titulo;
	private int ano;
	private int codigoEditora;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getCodigoEditora() {
		return codigoEditora;
	}

	public void setCodigoEditora(int codigoEditora) {
		this.codigoEditora = codigoEditora;
	}
}