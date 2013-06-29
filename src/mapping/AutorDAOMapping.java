package mapping;

import java.util.List;

import persistence.dto.AutorDTO;
import business.bo.Autor;
import business.daobase.AutorDAO;
import exceptions.PersistenceException;

public class AutorDAOMapping implements AutorDAO, IMapping<Autor, AutorDTO> {

	@Override
	public List<Autor> buscarTodos() throws PersistenceException {
		return null;
	}

	@Override
	public Autor buscarPorCodigo(int codigo) throws PersistenceException {
		return null;
	}

	@Override
	public List<Autor> buscarPorNome(String nome) throws PersistenceException {
		return null;
	}

	@Override
	public void inserir(Autor autor) throws PersistenceException {
		
	}

	@Override
	public void alterar(Autor autor) throws PersistenceException {
		
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