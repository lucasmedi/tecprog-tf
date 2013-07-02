package mapping;

import java.util.ArrayList;
import java.util.List;

import persistence.daoderby.LivroDAOderby;
import persistence.dto.LivroDTO;
import business.bo.Livro;
import business.daobase.LivroDAO;
import exceptions.ConnectionException;
import exceptions.MappingException;
import exceptions.PersistenceException;
import framework.IConnection;

public class LivroDAOMapping implements LivroDAO, IMapping<Livro, LivroDTO> {

	private IConnection connection;
	
	public LivroDAOMapping(IConnection connection) {
		this.connection = connection;
	}
	
	@Override
	public List<Livro> buscarTodos() throws MappingException {
		List<Livro> res = new ArrayList<Livro>(0);
		
		try {
			LivroDAOderby dao = new LivroDAOderby(connection);
			for (LivroDTO dto : dao.buscarTodos()) {
				res.add(parseBO(dto));
			}
		} catch (Exception ex) {
			throw new MappingException(ex);
		}
		
		return res;
	}

	@Override
	public List<Livro> buscarPorEditora(int codigo) throws MappingException {
		List<Livro> res = new ArrayList<Livro>(0);
		
		try {
			LivroDAOderby dao = new LivroDAOderby(connection);
			for (LivroDTO dto : dao.buscarPorEditora(codigo)) {
				res.add(parseBO(dto));
			}
		} catch (Exception ex) {
			throw new MappingException(ex);
		}
		
		return res;
	}

	@Override
	public List<Livro> buscarPorAutor(int codigo) throws MappingException {
		List<Livro> res = new ArrayList<Livro>(0);
		
		try {
			LivroDAOderby dao = new LivroDAOderby(connection);
			for (LivroDTO dto : dao.buscarPorAutor(codigo)) {
				res.add(parseBO(dto));
			}
		} catch (Exception ex) {
			throw new MappingException(ex);
		}
		
		return res;
	}
	
	public List<Livro> buscarPorTitulo(String titulo) throws MappingException {
		List<Livro> res = new ArrayList<>(0);
		
		try {
			LivroDAOderby dao = new LivroDAOderby(connection);
			for (LivroDTO dto : dao.buscarPorTitulo(titulo)) {
				res.add(parseBO(dto));
			}
		} catch (Exception ex) {
			throw new MappingException(ex);
		}
		
		return res;
	}
	
	@Override
	public Livro buscarPorCodigo(int codigo) throws MappingException {
		Livro livro = null;
		
		try {
			LivroDAOderby dao = new LivroDAOderby(connection);
			livro = parseBO(dao.buscarPorCodigo(codigo));
		} catch (Exception ex) {
			throw new MappingException(ex);
		}
		
		return livro;
	}
	
	@Override
	public Livro buscarLivroPorTitulo(String titulo) throws MappingException {
		Livro livro = null;
		
		try {
			LivroDAOderby dao = new LivroDAOderby(connection);
			livro = parseBO(dao.buscarLivroPorTitulo(titulo));
		} catch (Exception ex) {
			throw new MappingException(ex);
		}
		
		return livro;
	}
	
	@Override
	public int inserir(Livro livro) throws MappingException {
		LivroDTO livroDTO = parseDTO(livro);
		LivroDAOderby livroDAO = new LivroDAOderby(connection);
		try {
			int codigo = livroDAO.inserir(livroDTO);
			livroDTO.setCodigo(codigo);
		} catch (PersistenceException | ConnectionException e) {
			throw new MappingException(e);
		}
		
		return livroDTO.getCodigo();
	}

	@Override
	public void alterar(Livro livro) throws MappingException {
		LivroDTO livroDTO = parseDTO(livro);
		LivroDAOderby livroDAO = new LivroDAOderby(connection);
		try {
			livroDAO.alterar(livroDTO);
		} catch (PersistenceException | ConnectionException e) {
			throw new MappingException(e);
		}
	}
	
	@Override
	public Livro parseBO(LivroDTO dto) throws MappingException {
		if (dto == null)
			return null;
		
		EditoraDAOMapping dao = new EditoraDAOMapping(connection);
		
		Livro bo = new Livro();
		bo.setCodigo(dto.getCodigo());
		bo.setTitulo(dto.getTitulo());
		bo.setAno(dto.getAno());
		bo.setEditora(dao.buscarPorCodigo(dto.getCodigoEditora()));
		return bo;
	}
	
	@Override
	public LivroDTO parseDTO(Livro bo) {
		if (bo == null)
			return null;
		
		LivroDTO dto = new LivroDTO();
		dto.setCodigo(bo.getCodigo());
		dto.setTitulo(bo.getTitulo());
		dto.setAno(bo.getAno());
		dto.setCodigoEditora(bo.getEditora().getCodigo());
		return dto;
	}
}