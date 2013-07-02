package mapping;

import java.util.ArrayList;
import java.util.List;

import persistence.daoderby.VendaDAOderby;
import persistence.dto.VendaDTO;
import business.bo.Venda;
import business.daobase.VendaDAO;
import exceptions.MappingException;
import framework.IConnection;

public class VendaDAOMapping implements VendaDAO, IMapping<Venda, VendaDTO> {
	
	private IConnection connection;
	
	public VendaDAOMapping(IConnection connection) {
		this.connection = connection;
	}
	
	@Override
	public List<Venda> buscarTodos() throws MappingException {
		List<Venda> res = new ArrayList<Venda>(0);
		
		try {
			VendaDAOderby dao = new VendaDAOderby(connection);
			for (VendaDTO dto : dao.buscarTodos()) {
				res.add(parseBO(dto));
			}
		} catch (Exception ex) {
			throw new MappingException(ex);
		}
		
		return res;
	}

	@Override
	public Venda buscarPorCodigo(int codigo) throws MappingException {
		Venda venda = null;
		
		try {
			VendaDAOderby dao = new VendaDAOderby(connection);
			venda = parseBO(dao.buscarPorCodigo(codigo));
		} catch (Exception ex) {
			throw new MappingException(ex);
		}
		
		return venda;
	}

	@Override
	public int inserir(Venda venda) {
		return 0;
		
	}

	@Override
	public void alterar(Venda venda) {
		
	}

	@Override
	public Venda parseBO(VendaDTO dto) {
		Venda bo = new Venda();
		bo.setCodigo(dto.getCodigo());
		bo.setNomeCliente(dto.getNomeCliente());
		bo.setCpfCliente(dto.getCpfCliente());
		bo.setCnpjCliente(dto.getCnpjCliente());
		bo.setData(dto.getData());
		return bo;
	}

	@Override
	public VendaDTO parseDTO(Venda bo) {
		VendaDTO dto = new VendaDTO();
		dto.setCodigo(bo.getCodigo());
		dto.setNomeCliente(bo.getNomeCliente());
		dto.setCpfCliente(dto.getCpfCliente());
		dto.setCnpjCliente(dto.getCnpjCliente());
		dto.setData(dto.getData());
		return dto;
	}
}