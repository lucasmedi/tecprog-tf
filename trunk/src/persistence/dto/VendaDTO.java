package persistence.dto;

import java.util.Date;

public class VendaDTO {
	private int codigo;
	private String nomeCliente;
	private String cpfCliente;
	private String cnpjCliente;
	private Date data;
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public String getCpfCliente() {
		return cpfCliente;
	}
	
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	
	public String getCnpjCliente() {
		return cnpjCliente;
	}
	
	public void setCnpjCliente(String cnpjCliente) {
		this.cnpjCliente = cnpjCliente;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
}