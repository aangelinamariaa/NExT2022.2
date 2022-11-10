package next.projetoreferencia.repositorios;

import next.projetoreferencia.entidades.Produto;

public class RepositorioProduto {
	private Produto[] listaProdutos;
	private int tamanhoAtual = -1;
	RepositorioProduto() {
		listaProdutos = new Produto[100];
	}
	public void incluir(Produto produto) {
		tamanhoAtual++;
		listaProdutos[tamanhoAtual] = produto;
	}
	public Produto buscarPorCodigo(long codigoEAN) {
		for (Produto produto : listaProdutos) {
			if (produto != null && produto.getCodigoEAN() == codigoEAN) {
				return produto;
			}
		}
		return null;
	}
	public Produto[] consultarTodos() {
		Produto[] listaRetorno = new Produto[tamanhoAtual + 1];		
		for (int i=0; i<listaRetorno.length; i++) {
			listaRetorno[i] = listaProdutos[i];
		}
		return listaRetorno;
	}
}
