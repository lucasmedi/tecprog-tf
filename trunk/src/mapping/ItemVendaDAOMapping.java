package mapping;

import java.util.ArrayList;
import java.util.List;

import persistence.daoderby.ItemVendaDAOderby;
import persistence.dto.ItemVendaDTO;
import business.bo.ItemVenda;
import business.daobase.ItemVendaDAO;
import exceptions.ConnectionException;
import exceptions.MappingException;
import exceptions.PersistenceException;
import framework.IConnection;

public class ItemVendaDAOMapping implements ItemVendaDAO, IMapping<ItemVenda, ItemVendaDTO> {

	private IConnection connection;
	
	public ItemVendaDAOMapping(IConnection connection) {
		this.connection = connection;
	}
	
	@Override
	public List<ItemVenda> buscarPorCodigoVenda(int codigo) throws MappingException {
		List<ItemVenda> res = new ArrayList<ItemVenda>(0);
		
		try {
			ItemVendaDAOderby dao = new ItemVendaDAOderby(connection);
			for (ItemVendaDTO dto : dao.buscarPorCodigoVenda(codigo)) {
				res.add(parseBO(dto));
			}
		} catch (Exception ex) {
			throw new MappingException(ex);
		}
		
		return res;
	}

	@Override
	public List<ItemVenda> buscarPorCodigoLivro(int codigo) throws MappingException {
		List<ItemVenda> res = new ArrayList<ItemVenda>(0);
		
		try {
			ItemVendaDAOderby dao = new ItemVendaDAOderby(connection);
			for (ItemVendaDTO dto : dao.buscarPorCodigoLivro(codigo)) {
				res.add(parseBO(dto));
			}
		} catch (Exception ex) {
			throw new MappingException(ex);
		}
		
		return res;
	}
	
	@Override
	public int inserir(ItemVenda itemVenda) throws MappingException {
		ItemVendaDAOderby dao = new ItemVendaDAOderby(connection);
		int id = 0;
		try {
			id = dao.inserir(parseDTO(itemVenda));
		} catch (PersistenceException | ConnectionException e) {
			throw new MappingException("Erro ao inserir item de venda.", e);
		}
		
		return id;
	}
	
	@Override
	public ItemVenda parseBO(ItemVendaDTO dto) throws MappingException {
		if (dto == null)
			return null;
		
		VendaDAOMapping vendaDAO = new VendaDAOMapping(connection);
		LivroDAOMapping livroDAO = new LivroDAOMapping(connection);
		
		ItemVenda bo = new ItemVenda();
		bo.setVenda(vendaDAO.buscarPorCodigo(dto.getCodigoVenda()));
		bo.setLivro(livroDAO.buscarPorCodigo(dto.getCodigoLivro()));
		bo.setQuantidade(dto.getQuantidade());
		return bo;
	}

	@Override
	public ItemVendaDTO parseDTO(ItemVenda bo) {
		if (bo == null)
			return null;
		
		ItemVendaDTO dto = new ItemVendaDTO();
		dto.setCodigoVenda(bo.getVenda().getCodigo());
		dto.setCodigoLivro(bo.getLivro().getCodigo());
		dto.setQuantidade(bo.getQuantidade());
		return dto;
	}	
}