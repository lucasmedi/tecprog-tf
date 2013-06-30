package mapping;

import java.util.ArrayList;
import java.util.List;

import persistence.daoderby.LivroDAOderby;
import persistence.dto.LivroDTO;
import business.bo.Livro;
import business.daobase.LivroDAO;
import exceptions.MappingException;

public class LivroDAOMapping implements LivroDAO, IMapping<Livro, LivroDTO> {

	@Override
	public List<Livro> buscarTodos() throws MappingException {
		List<Livro> res = new ArrayList<Livro>();
		
		try {
			LivroDAOderby dao = new LivroDAOderby();
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
		List<Livro> res = new ArrayList<Livro>();
		
		try {
			LivroDAOderby dao = new LivroDAOderby();
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
		List<Livro> res = new ArrayList<Livro>();
		
		try {
			LivroDAOderby dao = new LivroDAOderby();
			for (LivroDTO dto : dao.buscarPorAutor(codigo)) {
				res.add(parseBO(dto));
			}
		} catch (Exception ex) {
			throw new MappingException(ex);
		}
		
		return res;
	}
	
	public List<Livro> buscarPorTitulo(String titulo) throws MappingException {
		List<Livro> res = new ArrayList<>();
		
		try {
			LivroDAOderby dao = new LivroDAOderby();
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
			LivroDAOderby dao = new LivroDAOderby();
			livro = parseBO(dao.buscarPorCodigo(codigo));
		} catch (Exception ex) {
			throw new MappingException(ex);
		}
		
		return livro;
	}
	
	@Override
	public void inserir(Livro livro) {
		
	}

	@Override
	public void alterar(Livro livro) {
		
	}
	
	@Override
	public Livro parseBO(LivroDTO dto) throws MappingException {
		EditoraDAOMapping dao = new EditoraDAOMapping();
		
		Livro bo = new Livro();
		bo.setCodigo(dto.getCodigo());
		bo.setTitulo(dto.getTitulo());
		bo.setAno(dto.getAno());
		bo.setEditora(dao.buscarPorCodigo(dto.getCodigoEditora()));
		return bo;
	}
	
	@Override
	public LivroDTO parseDTO(Livro bo) {
		LivroDTO dto = new LivroDTO();
		dto.setCodigo(bo.getCodigo());
		dto.setTitulo(bo.getTitulo());
		dto.setAno(bo.getAno());
		dto.setCodigoEditora(bo.getEditora().getCodigo());
		return dto;
	}
}