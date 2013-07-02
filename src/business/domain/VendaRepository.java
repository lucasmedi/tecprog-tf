package business.domain;

import java.util.ArrayList;
import java.util.List;

import mapping.ItemVendaDAOMapping;
import business.bo.ItemVenda;
import business.bo.Livro;
import exceptions.BusinessException;
import exceptions.ConnectionException;
import exceptions.MappingException;
import framework.ConnectionFactory;
import framework.DbType;
import framework.IConnection;

public class VendaRepository {
	private IConnection connection;
	
	public VendaRepository() throws BusinessException, ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		this.connection = connection;
	}
	
	public VendaRepository(IConnection connection) throws BusinessException {
		if (connection == null)
			throw new BusinessException("Conexão não informada.");
		this.connection = connection;
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