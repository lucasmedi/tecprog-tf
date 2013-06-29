package mapping;

import java.util.List;

import persistence.dto.LivroDTO;
import business.bo.Livro;
import business.daobase.LivroDAO;
import exceptions.PersistenceException;

public class LivroDAOMapping implements LivroDAO, IMapping<Livro, LivroDTO> {

	@Override
	public List<Livro> buscarTodos() throws PersistenceException {
		return null;
	}

	@Override
	public List<Livro> buscarPorEditora(int codigo) throws PersistenceException {
		return null;
	}

	@Override
	public List<Livro> buscarPorAutor(int codigo) throws PersistenceException {
		return null;
	}
	
	@Override
	public Livro buscarPorCodigo(int codigo) throws PersistenceException {
		return null;
	}
	
	@Override
	public void inserir(Livro livro) throws PersistenceException {
		
	}

	@Override
	public void alterar(Livro livro) throws PersistenceException {
		
	}
	
	@Override
	public Livro parseBO(LivroDTO dto) {
		Livro bo = new Livro();
		bo.setCodigo(dto.getCodigo());
		bo.setTitulo(dto.getTitulo());
		bo.setAno(dto.getAno());
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