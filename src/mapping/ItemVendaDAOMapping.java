package mapping;

import java.util.ArrayList;
import java.util.List;

import persistence.daoderby.ItemVendaDAOderby;
import persistence.dto.ItemVendaDTO;
import business.bo.ItemVenda;
import business.daobase.ItemVendaDAO;
import exceptions.MappingException;

public class ItemVendaDAOMapping implements ItemVendaDAO, IMapping<ItemVenda, ItemVendaDTO> {

	@Override
	public List<ItemVenda> buscarPorCodigoVenda(int codigo) throws MappingException {
		List<ItemVenda> res = new ArrayList<ItemVenda>();
		
		try {
			ItemVendaDAOderby dao = new ItemVendaDAOderby();
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
		List<ItemVenda> res = new ArrayList<ItemVenda>();
		
		try {
			ItemVendaDAOderby dao = new ItemVendaDAOderby();
			for (ItemVendaDTO dto : dao.buscarPorCodigoLivro(codigo)) {
				res.add(parseBO(dto));
			}
		} catch (Exception ex) {
			throw new MappingException(ex);
		}
		
		return res;
	}
	
	@Override
	public ItemVenda parseBO(ItemVendaDTO dto) throws MappingException {
		VendaDAOMapping vendaDAO = new VendaDAOMapping();
		LivroDAOMapping livroDAO = new LivroDAOMapping();
		
		ItemVenda bo = new ItemVenda();
		bo.setVenda(vendaDAO.buscarPorCodigo(dto.getCodigoVenda()));
		bo.setLivro(livroDAO.buscarPorCodigo(dto.getCodigoLivro()));
		bo.setQuantidade(dto.getQuantidade());
		return bo;
	}

	@Override
	public ItemVendaDTO parseDTO(ItemVenda bo) {
		ItemVendaDTO dto = new ItemVendaDTO();
		dto.setCodigoVenda(bo.getVenda().getCodigo());
		dto.setCodigoLivro(bo.getLivro().getCodigo());
		dto.setQuantidade(bo.getQuantidade());
		return dto;
	}
}