package mapping;

import java.util.ArrayList;
import java.util.List;

import persistence.daoderby.EditoraDAOderby;
import persistence.dto.EditoraDTO;
import business.bo.Editora;
import business.daobase.EditoraDAO;
import exceptions.ConnectionException;
import exceptions.MappingException;
import exceptions.PersistenceException;

public class EditoraDAOMapping implements EditoraDAO, IMapping<Editora, EditoraDTO> {
	
	@Override
	public List<Editora> buscarTodos() throws MappingException {
		List<Editora> res = new ArrayList<Editora>();
		
		try {
			EditoraDAOderby dao = new EditoraDAOderby();
			for (EditoraDTO dto : dao.buscarTodos()) {
				res.add(parseBO(dto));
			}
		} catch (Exception ex) {
			throw new MappingException(ex);
		}
		
		return res;
	}

	@Override
	public List<Editora> buscarPorNome(String nome) throws MappingException {
		List<Editora> res = new ArrayList<Editora>();
		
		try {
			EditoraDAOderby dao = new EditoraDAOderby();
			for (EditoraDTO dto : dao.buscarPorNome(nome)) {
				res.add(parseBO(dto));
			}
		} catch (Exception ex) {
			throw new MappingException(ex);
		}
		
		return res;
	}
	
	@Override
	public Editora buscarPorCodigo(int codigo) throws MappingException {
		Editora editora = null;
		
		try {
			EditoraDAOderby dao = new EditoraDAOderby();
			editora = parseBO(dao.buscarPorCodigo(codigo));
		} catch (Exception ex) {
			throw new MappingException(ex);
		}
		
		return editora;
	}
	
	@Override
	public Editora buscarUmPorNome(String nome) throws MappingException {
		Editora editora = null;
		
		try {
			EditoraDAOderby dao = new EditoraDAOderby();
			editora = parseBO(dao.buscarUmPorNome(nome));
		} catch (Exception ex) {
			throw new MappingException(ex);
		}
		
		return editora;
	}

	@Override
	public int inserir(Editora editora) throws MappingException {
		EditoraDAOderby dao = new EditoraDAOderby();
		int id = 0;
		try {
			id = dao.inserir(parseDTO(editora));
		} catch (PersistenceException | ConnectionException e) {
			throw new MappingException("Erro ao inserir editora.", e);
		}
		
		return id;
	}

	@Override
	public void alterar(Editora editora) throws MappingException {
		EditoraDAOderby dao = new EditoraDAOderby();
		
		try {
			dao.alterar(parseDTO(editora));
		} catch (PersistenceException | ConnectionException e) {
			throw new MappingException("Erro ao atualizar editora.", e);
		}
	}

	@Override
	public Editora parseBO(EditoraDTO dto) {
		Editora bo = new Editora();
		bo.setCodigo(dto.getCodigo());
		bo.setNome(dto.getNome());
		return bo;
	}

	@Override
	public EditoraDTO parseDTO(Editora bo) {
		EditoraDTO dto = new EditoraDTO();
		dto.setCodigo(bo.getCodigo());
		dto.setNome(bo.getNome());
		return dto;
	}
}