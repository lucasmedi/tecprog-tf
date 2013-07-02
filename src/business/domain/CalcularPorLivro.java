package business.domain;

import java.util.ArrayList;
import java.util.List;

import business.bo.Autor;
import business.bo.AutorPagamento;
import business.bo.Livro;
import exceptions.BusinessException;
import exceptions.ConnectionException;

public class CalcularPorLivro implements ICalcularPagamento {

	private List<Autor> autores;
	
	public CalcularPorLivro(List<Autor> autores) {
		this.autores = autores;
	}
	
	@Override
	public List<AutorPagamento> calcularValor() throws BusinessException {
		VendaRepository vendaRepo;
		LivroRepository livroRepo;
		try {
			vendaRepo = new VendaRepository();
			livroRepo = new LivroRepository();
		} catch (ConnectionException e) {
			throw new BusinessException("Erro ao abrir conexão com a base de dados", e);
		}
		
		List<AutorPagamento> result = new ArrayList<>(0);
		
		List<Livro> livros = new ArrayList<>(0);
		for (Autor autor : autores) {
			livros = livroRepo.buscarLivrosPorAutor(autor);
			
			double qtdTotal = 0;
			for (Livro livro : livros) {
				int quantidade = vendaRepo.buscarQuantidadeVendidaPorLivro(livro);
				if (quantidade > 0 && quantidade <= 10) {
					qtdTotal += quantidade * 2;
				} else if (quantidade > 10 && quantidade <= 20) {
					qtdTotal += quantidade * 3;
				} else if (quantidade > 20) {
					qtdTotal += quantidade * 4;
				}
			}
			
			result.add(new AutorPagamento(autor, qtdTotal));
		}
		
		return result;
	}

	@Override
	public void setValorLivro(double valor) {
		return;
	}

	@Override
	public void setBonusVenda(int bonus) {
		return;
	}

	@Override
	public void setBonusExclusividade(int bonus) {
		return;
	}
}