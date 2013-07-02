package business.domain;

import java.util.ArrayList;
import java.util.List;

import mapping.ItemVendaDAOMapping;
import mapping.VendaDAOMapping;
import business.bo.ItemVenda;
import business.bo.Livro;
import business.bo.Venda;
import exceptions.BusinessException;
import exceptions.MappingException;
import framework.IConnection;

public class VendaRepository {
	private IConnection connection;
	
	public VendaRepository(IConnection connection) throws BusinessException {
		if (connection == null)
			throw new BusinessException("Conexão não informada.");
		this.connection = connection;
	}
	
	public List<Venda> buscarTodos() throws BusinessException {
		VendaDAOMapping venda = new VendaDAOMapping(connection);
		List<Venda> vendas = new ArrayList<>(0);
		try {
			vendas = venda.buscarTodos();
		} catch (MappingException e) {
			throw new BusinessException(e);
		}

		return vendas;
	}
	
	public int buscarQuantidadeVendidaPorLivro(Livro livro) throws BusinessException {
		if (livro == null || livro.getCodigo() <= 0)
			throw new BusinessException("Livro não informado.");
		
		ItemVendaDAOMapping itemVenda = new ItemVendaDAOMapping(connection);
		List<ItemVenda> itens = new ArrayList<>(0);
		try {
			itens = itemVenda.buscarPorCodigoLivro(livro.getCodigo());
		} catch (MappingException e) {
			throw new BusinessException(e);
		}
		
		int quantidade = 0;
		if (itens == null || itens.isEmpty())
			return quantidade;
		
		for (ItemVenda item : itens) {
			quantidade += item.getQuantidade();
		}
		
		return quantidade;
	}
}