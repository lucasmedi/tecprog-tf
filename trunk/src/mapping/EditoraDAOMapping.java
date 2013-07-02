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
import framework.IConnection;

public class EditoraDAOMapping implements EditoraDAO, IMapping<Editora, EditoraDTO> {
	
	private IConnection connection;
	
	public EditoraDAOMapping(IConnection connection) {
		this.connection = connection;
	}
	
	@Override
	public List<Editora> buscarTodos() throws MappingException {
		List<Editora> res = new ArrayList<Editora>(0);
		
		try {
			EditoraDAOderby dao = new EditoraDAOderby(connection);
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
		List<Editora> res = new ArrayList<Editora>(0);
		
		try {
			EditoraDAOderby dao = new EditoraDAOderby(connection);
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
			EditoraDAOderby dao = new EditoraDAOderby(connection);
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
			EditoraDAOderby dao = new EditoraDAOderby(connection);
			editora = parseBO(dao.buscarUmPorNome(nome));
		} catch (Exception ex) {
			throw new MappingException(ex);
		}
		
		return editora;
	}

	@Override
	public int inserir(Editora editora) throws MappingException {
		EditoraDAOderby dao = new EditoraDAOderby(connection);
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
		EditoraDAOderby dao = new EditoraDAOderby(connection);
		
		try {
			dao.alterar(parseDTO(editora));
		} catch (PersistenceException | ConnectionException e) {
			throw new MappingException("Erro ao atualizar editora.", e);
		}
	}

	@Override
	public Editora parseBO(EditoraDTO dto) {
		if(dto == null){
			return null;
			
		Editora bo = new Editora();
		bo.setCodigo(dto.getCodigo());
		bo.setNome(dto.getNome());
		return bo;
	}

	@Override
	public EditoraDTO parseDTO(Editora bo) {
		if(bo == null){
			return null;
			
		EditoraDTO dto = new EditoraDTO();
		dto.setCodigo(bo.getCodigo());
		dto.setNome(bo.getNome());
		return dto;
	}
}