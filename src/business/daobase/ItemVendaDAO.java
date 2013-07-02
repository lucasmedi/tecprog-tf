package business.daobase;

import java.util.List;

import business.bo.ItemVenda;
import exceptions.MappingException;

public interface ItemVendaDAO {
	List<ItemVenda> buscarPorCodigoVenda(int codigo) throws MappingException;
	List<ItemVenda> buscarPorCodigoLivro(int codigo) throws MappingException;
	int inserir(ItemVenda itemVenda) throws MappingException;
}