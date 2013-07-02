package business.domain;

import java.util.List;

import business.bo.Autor;
import business.bo.Editora;
import exceptions.BusinessException;
import exceptions.ConnectionException;

public class CalcularPagamentoFactory {
	public static ICalcularPagamento getInstance(Editora editora, TipoPolitica tipo) throws BusinessException, ConnectionException {
		AutorRepository autorRepo = new AutorRepository();
		List<Autor> autores = autorRepo.buscarPorEditora(editora);
		
		switch (tipo) {
			case TipoUm:
				return new CalcularPorVendas(autores);
			case TipoDois:
				return new CalcularPorLivro(autores);
			default:
				break;
		}
		
		return null;
	}
}