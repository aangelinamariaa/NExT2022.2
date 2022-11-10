package next.projetoreferencia.mediators;

import next.projetoreferencia.entidades.TipoProduto;
import next.projetoreferencia.repositorios.FabricaRepositorios;
import next.projetoreferencia.repositorios.RepositorioTipoProduto;
//import next.projetoreferencia.utilidades.Ordenador;

public class TipoProdutoMediator {
	public static final int SUCESSO = 0;
	public static final int CODIGO_INVALIDO = 1;
	public static final int NOME_INVALIDO = 2;
	private RepositorioTipoProduto repositorioTipoProduto;
	public TipoProdutoMediator() {
		repositorioTipoProduto = FabricaRepositorios.getRepositorioTipoProduto();
	}
	public int incluir(TipoProduto tipoProduto) {
		if (tipoProduto.getCodigo() <= 0) {
			return CODIGO_INVALIDO;
		} else if (tipoProduto.getNome() == null 
				|| tipoProduto.getNome().trim().equals("")) {
			return NOME_INVALIDO;
		}
		repositorioTipoProduto.incluir(tipoProduto);
		return SUCESSO;
	}
	public TipoProduto[] consultarOrdenadoPorNome() {
		// C�digo duplicado, com interface, usamos o c�digo �nico do Ordenador 
		TipoProduto[] tiposProdutos = repositorioTipoProduto.consultarTodos();
		TipoProduto aux = null;
		for (int i=0; i<tiposProdutos.length; i++) {
			for (int k=i; k<tiposProdutos.length; k++) {
				String nome1 = tiposProdutos[i].getNome();
				String nome2 = tiposProdutos[k].getNome();
				if (nome1.compareTo(nome2) > 0) {
					aux = tiposProdutos[i];
					tiposProdutos[i] = tiposProdutos[k];
					tiposProdutos[k] = aux;
				}
			}
		}
		return tiposProdutos;
		// CODIGO OTIMIZADO COM INTERFACE
//		TipoProduto[] tiposProdutos = repositorioTipoProduto.consultarTodos();
//		Ordenador.ordenar(tiposProdutos);
//		return tiposProdutos;
	}
}
