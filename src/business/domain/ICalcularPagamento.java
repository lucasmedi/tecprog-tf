package business.domain;

import java.util.List;

import business.bo.AutorPagamento;
import exceptions.BusinessException;

public interface ICalcularPagamento {
	List<AutorPagamento> calcularValor() throws BusinessException;
	void setValorLivro(double valor);
	void setBonusVenda(int bonus);
	void setBonusExclusividade(int bonus);
}