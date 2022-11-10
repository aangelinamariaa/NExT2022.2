package next.projetoreferencia.mediators;

import next.projetoreferencia.entidades.Produto;
import next.projetoreferencia.entidades.TipoProduto;
import next.projetoreferencia.repositorios.FabricaRepositorios;
import next.projetoreferencia.repositorios.RepositorioProduto;
import next.projetoreferencia.repositorios.RepositorioTipoProduto;
//import next.projetoreferencia.utilidades.Ordenador;

public class ProdutoMediator {
	public static final int SUCESSO = 0;
	public static final int CODIGO_INVALIDO = 1;
	public static final int DESCRICAO_INVALIDA = 2;
	public static final int TIPO_PRODUTO_INEXISTENTE = 3;
	public static final int VALOR_INVALIDO = 4;
	public static final int PRODUTO_INEXISTENTE = 5;
	public static final int PRECO_MENOR_QUE_VALOR = 6;
	private RepositorioProduto repositorioProduto;
	private RepositorioTipoProduto repositorioTipoProduto;
	public ProdutoMediator() {
		repositorioProduto = FabricaRepositorios.getRepositorioProduto();
		repositorioTipoProduto = FabricaRepositorios.getRepositorioTipoProduto();
	}
	public int incluir(Produto produto, int codigoTipoProduto) {
		if (produto.getCodigoEAN() <= 0) {
			return CODIGO_INVALIDO;
		} else if (produto.getDescricao() == null 
				|| produto.getDescricao().trim().equals("")) {
			return DESCRICAO_INVALIDA;
		} else {
			TipoProduto tipo = repositorioTipoProduto.buscarPorCodigo(codigoTipoProduto);
			if (tipo == null) {
				return TIPO_PRODUTO_INEXISTENTE; 
			} else {
				produto.setTipo(tipo);
			}
		}
		repositorioProduto.incluir(produto);
		return SUCESSO;
	}
	public int aumentarPreco(long codigoEAN, double valor) {
		if (valor < 0) {
			return VALOR_INVALIDO;
		} else {
			Produto produto = repositorioProduto.buscarPorCodigo(codigoEAN);
			if (produto == null) {
				return PRODUTO_INEXISTENTE;
			} else {
				produto.aumentarPreco(valor);
				return SUCESSO;
			}
		}
	}
	public int baixarPreco(long codigoEAN, double valor) {
		if (valor < 0 ) {
			return VALOR_INVALIDO;
		} else {
			Produto produto = repositorioProduto.buscarPorCodigo(codigoEAN);
			if (produto == null) {
				return PRODUTO_INEXISTENTE;
			} else if (produto.getPreco() < valor) {
				return PRECO_MENOR_QUE_VALOR;
			} else {				
				produto.baixarPreco(valor);
				return SUCESSO;
			}
		}
	}	
	public Produto[] consultarOrdenadoPorPreco() {
		// C�digo duplicado, com interface, usamos o c�digo �nico do Ordenador
		Produto[] produtos = repositorioProduto.consultarTodos();
		Produto aux = null;
		for (int i=0; i<produtos.length; i++) {
			for (int k=i; k<produtos.length; k++) {
				double preco1 = produtos[i].getPreco();
				double preco2 = produtos[k].getPreco();
				if (preco1 > preco2) {
					aux = produtos[i];
					produtos[i] = produtos[k];
					produtos[k] = aux;
				}
			}
		}
		return produtos;
		// CODIGO OTIMIZADO COM INTERFACE
//		Produto[] produtos = repositorioProduto.consultarTodos();
//		Ordenador.ordenar(produtos);
//		return produtos;
	}
}
