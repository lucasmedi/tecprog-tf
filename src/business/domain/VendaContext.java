package business.domain;

import java.util.List;

import mapping.ItemVendaDAOMapping;
import mapping.VendaDAOMapping;
import business.bo.ItemVenda;
import business.bo.Venda;
import business.daobase.ItemVendaDAO;
import business.daobase.VendaDAO;
import exceptions.BusinessException;
import exceptions.ConnectionException;
import exceptions.MappingException;
import framework.IConnection;

public class VendaContext {
	
	private IConnection connection;
	
	public VendaContext(IConnection connection) throws BusinessException {
		if (connection == null)
			throw new BusinessException("Conexão não informada.");
		this.connection = connection;
	}
	
	public void criarVenda(Venda venda, List<ItemVenda> itens) throws BusinessException {
		if (venda.getNomeCliente() == null || venda.getNomeCliente().isEmpty())
			throw new BusinessException("Nome do cliente não informado.");
		
		if (venda.getCpfCliente() == null && venda.getCnpjCliente() == null)
			throw new BusinessException("Favor informa CPF ou CNPJ.");
		
		if (venda.getCpfCliente() != null && venda.getCpfCliente().length() != 11)
			throw new BusinessException("CPF inválido.");
		
		if (venda.getCnpjCliente() != null && venda.getCnpjCliente().length() != 14)
			throw new BusinessException("CPF inválido.");
		
		for(ItemVenda item : itens) {
			if (item.getLivro() == null || item.getLivro().getCodigo() <= 0)
				throw new BusinessException("Livro inválido.");
			if (item.getQuantidade() <= 0)
				throw new BusinessException("Quantidade inválida para o livro: " + item.getLivro().getTitulo() + ".");	
		}
		
		VendaDAO vendaDAO = new VendaDAOMapping(connection);
		ItemVendaDAO itemDAO = new ItemVendaDAOMapping(connection);
		try {
			connection.openTransaction();
			int codVenda = vendaDAO.inserir(venda);
			venda.setCodigo(codVenda);
			for(ItemVenda item : itens) {
				item.setVenda(venda);
				itemDAO.inserir(item);
			}
			connection.commit();
		} catch (ConnectionException | MappingException e) {
			try {
				connection.rollback();
			} catch (ConnectionException e1) {
				throw new BusinessException("Erro ao cancelar operação.", e1);
			}
			throw new BusinessException("Erro ao realizar inclusão da venda.", e);
		} finally {
			try {
				connection.closeTransaction();
			} catch (ConnectionException e) {
				throw new BusinessException("Erro ao encerrar transação.", e);
			}
		}
	}
}