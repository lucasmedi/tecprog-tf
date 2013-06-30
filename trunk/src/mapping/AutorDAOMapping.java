package mapping;

import java.util.ArrayList;
import java.util.List;

import persistence.daoderby.AutorDAOderby;
import persistence.dto.AutorDTO;
import business.bo.Autor;
import business.daobase.AutorDAO;
import exceptions.MappingException;

public class AutorDAOMapping implements AutorDAO, IMapping<Autor, AutorDTO> {

	@Override
	public List<Autor> buscarTodos() throws MappingException {
		List<Autor> res = new ArrayList<Autor>();
		
		try {
			AutorDAOderby dao = new AutorDAOderby();
			for (AutorDTO dto : dao.buscarTodos()) {
				res.add(parseBO(dto));
			}
		} catch (Exception ex) {
			throw new MappingException(ex);
		}
		
		return res;
	}

	@Override
	public List<Autor> buscarPorNome(String nome) throws MappingException {
		List<Autor> res = new ArrayList<Autor>();
		
		try {
			AutorDAOderby dao = new AutorDAOderby();
			for (AutorDTO dto : dao.buscarPorNome(nome)) {
				res.add(parseBO(dto));
			}
		} catch (Exception ex) {
			throw new MappingException(ex);
		}
		
		return res;
	}
	
	@Override
	public Autor buscarPorCodigo(int codigo) throws MappingException {
		Autor autor = null;
		
		try {
			AutorDAOderby dao = new AutorDAOderby();
			autor = parseBO(dao.buscarPorCodigo(codigo));
		} catch (Exception ex) {
			throw new MappingException(ex);
		}
		
		return autor;
	}
	
	@Override
	public void inserir(Autor autor) {
		
	}

	@Override
	public void alterar(Autor autor) {
		
	}
	
	@Override
	public Autor parseBO(AutorDTO dto) {
		Autor bo = new Autor();
		bo.setCodigo(dto.getCodigo());
		bo.setPrimeiroNome(dto.getPrimeiroNome());
		bo.setUltimoNome(dto.getUltimoNome());
		return bo;
	}
	
	@Override
	public AutorDTO parseDTO(Autor bo) {
		AutorDTO dto = new AutorDTO();
		dto.setCodigo(bo.getCodigo());
		dto.setPrimeiroNome(bo.getPrimeiroNome());
		dto.setUltimoNome(bo.getUltimoNome());
		return dto;
	}
}