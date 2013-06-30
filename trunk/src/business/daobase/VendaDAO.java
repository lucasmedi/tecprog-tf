package business.daobase;

import java.util.List;

import business.bo.Venda;
import exceptions.MappingException;

public interface VendaDAO {
    List<Venda> buscarTodos() throws MappingException;
    Venda buscarPorCodigo(int codigo) throws MappingException;
    void inserir(Venda venda) throws MappingException;
    void alterar(Venda venda) throws MappingException;
}