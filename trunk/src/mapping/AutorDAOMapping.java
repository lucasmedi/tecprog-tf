package mapping;

import java.util.ArrayList;
import java.util.List;

import persistence.daoderby.AutorDAOderby;
import persistence.dto.AutorDTO;
import business.bo.Autor;
import business.bo.Editora;
import business.daobase.AutorDAO;
import exceptions.MappingException;
import framework.IConnection;

public class AutorDAOMapping implements AutorDAO, IMapping<Autor, AutorDTO> {
	
	private IConnection connection;
	
	public AutorDAOMapping(IConnection connection) {
		this.connection = connection;
	}
	
	@Override
	public List<Autor> buscarTodos() throws MappingException {
		List<Autor> res = new ArrayList<Autor>(0);
		
		try {
			AutorDAOderby dao = new AutorDAOderby(connection);
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
		List<Autor> res = new ArrayList<Autor>(0);
		
		try {
			AutorDAOderby dao = new AutorDAOderby(connection);
			for (AutorDTO dto : dao.buscarPorNome(nome)) {
				res.add(parseBO(dto));
			}
		} catch (Exception ex) {
			throw new MappingException(ex);
		}
		
		return res;
	}
	
	@Override
	public List<Autor> buscarPorEditora(Editora editora) throws MappingException {
		List<Autor> res = new ArrayList<Autor>(0);
		
		EditoraDAOMapping editoraDAO = new EditoraDAOMapping(connection);
		
		try {
			AutorDAOderby dao = new AutorDAOderby(connection);
			for (AutorDTO dto : dao.buscarPorEditora(editoraDAO.parseDTO(editora))) {
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
			AutorDAOderby dao = new AutorDAOderby(connection);
			autor = parseBO(dao.buscarPorCodigo(codigo));
		} catch (Exception ex) {
			throw new MappingException(ex);
		}
		
		return autor;
	}

	@Override
	public Autor buscarUmPorNome(String nome) throws MappingException {
		Autor autor = null;
		
		try {
			AutorDAOderby dao = new AutorDAOderby(connection);
			autor = parseBO(dao.buscarUmPorNome(nome));
		} catch (Exception ex) {
			throw new MappingException(ex);
		}
		
		return autor;
	}
	
	@Override
	public int inserir(Autor autor) throws MappingException {
		return 0;
	}

	@Override
	public void alterar(Autor autor) throws MappingException {
		
	}
	
	@Override
	public Autor parseBO(AutorDTO dto) {
		if (dto == null)
			return null;
		
		Autor bo = new Autor();
		bo.setCodigo(dto.getCodigo());
		bo.setPrimeiroNome(dto.getPrimeiroNome());
		bo.setUltimoNome(dto.getUltimoNome());
		return bo;
	}
	
	@Override
	public AutorDTO parseDTO(Autor bo) {
		if (bo == null)
			return null;
		
		AutorDTO dto = new AutorDTO();
		dto.setCodigo(bo.getCodigo());
		dto.setPrimeiroNome(bo.getPrimeiroNome());
		dto.setUltimoNome(bo.getUltimoNome());
		return dto;
	}
}