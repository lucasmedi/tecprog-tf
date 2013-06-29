package mapping;

import java.util.List;

import persistence.dto.EditoraDTO;
import business.bo.Editora;
import business.daobase.EditoraDAO;
import exceptions.PersistenceException;

public class EditoraDAOMapping implements EditoraDAO, IMapping<Editora, EditoraDTO> {

	@Override
	public List<Editora> buscarTodos() throws PersistenceException {
		return null;
	}

	@Override
	public Editora buscarPorCodigo(int codigo) throws PersistenceException {
		return null;
	}

	@Override
	public void inserir(Editora editora) throws PersistenceException {
		
	}

	@Override
	public void alterar(Editora editora) throws PersistenceException {
		
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