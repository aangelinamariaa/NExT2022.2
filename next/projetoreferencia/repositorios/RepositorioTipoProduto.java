package next.projetoreferencia.repositorios;

import next.projetoreferencia.entidades.TipoProduto;

public class RepositorioTipoProduto {
	private TipoProduto[] listaTiposProdutos;
	private int tamanhoAtual = -1;
	RepositorioTipoProduto() {
		listaTiposProdutos = new TipoProduto[100];
	}
	public void incluir(TipoProduto tipoProduto) {
		tamanhoAtual++;
		listaTiposProdutos[tamanhoAtual] = tipoProduto;		
	}
	public TipoProduto buscarPorCodigo(int codigo) {
		for (TipoProduto tipoProduto : listaTiposProdutos) {
			if (tipoProduto != null && tipoProduto.getCodigo() == codigo) {
				return tipoProduto;
			}
		}
		return null;
	}
	public TipoProduto[] consultarTodos() {
		TipoProduto[] listaRetorno = new TipoProduto[tamanhoAtual + 1];
		for (int i=0; i< listaRetorno.length; i++) {
			listaRetorno[i] = listaTiposProdutos[i];
		}
		return listaRetorno;
	}
}
