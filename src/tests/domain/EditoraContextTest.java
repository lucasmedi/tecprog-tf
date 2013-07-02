package tests.domain;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import exceptions.BusinessException;
import exceptions.ConnectionException;
import business.bo.AutorPagamento;
import business.bo.Editora;
import business.domain.EditoraContext;
import business.domain.EditoraRepository;
import business.domain.TipoPolitica;

public class EditoraContextTest {
	
	@Test
	public void calcularPagamentoPoliticaUmTest() throws BusinessException, ConnectionException {
		EditoraRepository editoraRepo = new EditoraRepository();
		Editora editora = editoraRepo.buscarUmPorNome("Martins");
		
		EditoraContext editoraContext = new EditoraContext();
		List<AutorPagamento> pagamentos = editoraContext.calcularPagamento(editora, TipoPolitica.TipoUm, 3.0, 5, 10);
		
		Assert.assertTrue(!pagamentos.isEmpty());
	}
	
	@Test
	public void calcularPagamentoPoliticaDoisTest() throws BusinessException, ConnectionException {
		EditoraRepository editoraRepo = new EditoraRepository();
		Editora editora = editoraRepo.buscarUmPorNome("Martins");
		
		EditoraContext editoraContext = new EditoraContext();
		List<AutorPagamento> pagamentos = editoraContext.calcularPagamento(editora, TipoPolitica.TipoDois, 0.0, 0, 0);
		
		Assert.assertTrue(!pagamentos.isEmpty());
	}
}