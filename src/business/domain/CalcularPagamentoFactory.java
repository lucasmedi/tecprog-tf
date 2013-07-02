package business.domain;

import java.util.List;

import business.bo.Autor;
import business.bo.Editora;
import exceptions.BusinessException;
import exceptions.ConnectionException;
import framework.IConnection;

public class CalcularPagamentoFactory {
	public static ICalcularPagamento getInstance(Editora editora, TipoPolitica tipo, IConnection connection) throws BusinessException, ConnectionException {
		AutorRepository autorRepo = new AutorRepository(connection);
		List<Autor> autores = autorRepo.buscarPorEditora(editora);
		
		switch (tipo) {
			case TipoUm:
				return new CalcularPorVendas(connection, autores);
			case TipoDois:
				return new CalcularPorLivro(connection, autores);
			default:
				break;
		}
		
		return null;
	}
}