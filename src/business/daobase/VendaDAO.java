package business.daobase;

import java.util.List;

import business.bo.Venda;
import exceptions.PersistenceException;

public interface VendaDAO {
    List<Venda> buscarTodos() throws PersistenceException;
    Venda buscarPorCodigo(int codigo) throws PersistenceException;
    void inserir(Venda venda) throws PersistenceException;
    void alterar(Venda venda) throws PersistenceException;
}