package tests.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import business.bo.ItemVenda;
import business.bo.Venda;
import business.domain.LivroRepository;
import business.domain.VendaContext;
import exceptions.BusinessException;
import exceptions.ConnectionException;
import framework.ConnectionFactory;
import framework.DbType;
import framework.IConnection;

public class VendaContextTest {
	
	//@Test
	public void criarVendaTest() throws BusinessException, ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		VendaContext vendaCtx = new VendaContext(connection);
		
		Venda venda = new Venda();
		venda.setNomeCliente("Lucas Cunha");
		venda.setCpfCliente("02873827897");
		
		List<ItemVenda> itens = new ArrayList<>(0);
		ItemVenda item = null;
		
		LivroRepository livroRepo = new LivroRepository(connection);
		item = new ItemVenda();
		item.setVenda(venda);
		item.setLivro(livroRepo.buscarLivroPorTitulo("Sutil"));
		item.setQuantidade(10);
		itens.add(item);
		
		item = new ItemVenda();
		item.setVenda(venda);
		item.setLivro(livroRepo.buscarLivroPorTitulo("Torres"));
		item.setQuantidade(20);
		itens.add(item);
		
		item = new ItemVenda();
		item.setVenda(venda);
		item.setLivro(livroRepo.buscarLivroPorTitulo("Rei"));
		item.setQuantidade(15);
		itens.add(item);
		
		vendaCtx.criarVenda(venda, itens);
		
		connection.close();
	}
}