package tests.domain;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import business.bo.AutorPagamento;
import business.bo.Editora;
import business.domain.EditoraContext;
import business.domain.EditoraRepository;
import business.domain.TipoPolitica;
import exceptions.BusinessException;
import exceptions.ConnectionException;
import framework.ConnectionFactory;
import framework.DbType;
import framework.IConnection;

public class EditoraContextTest {
	
	@Test
	public void calcularPagamentoPoliticaUmTest() throws BusinessException, ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		EditoraRepository editoraRepo = new EditoraRepository(connection);
		Editora editora = editoraRepo.buscarUmPorNome("Martins");
		
		EditoraContext editoraContext = new EditoraContext(connection);
		List<AutorPagamento> pagamentos = editoraContext.calcularPagamento(editora, TipoPolitica.TipoUm, 3.0, 5, 10);
		
		Assert.assertTrue(!pagamentos.isEmpty());
		
		connection.close();
	}
	
	@Test
	public void calcularPagamentoPoliticaDoisTest() throws BusinessException, ConnectionException {
		IConnection connection = ConnectionFactory.getInstance(DbType.Derby);
		EditoraRepository editoraRepo = new EditoraRepository(connection);
		Editora editora = editoraRepo.buscarUmPorNome("Martins");
		
		EditoraContext editoraContext = new EditoraContext(connection);
		List<AutorPagamento> pagamentos = editoraContext.calcularPagamento(editora, TipoPolitica.TipoDois, 0.0, 0, 0);
		
		Assert.assertTrue(!pagamentos.isEmpty());
		
		connection.close();
	}
}