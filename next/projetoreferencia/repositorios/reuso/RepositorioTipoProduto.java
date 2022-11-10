package next.projetoreferencia.repositorios.reuso;

import next.projetoreferencia.entidades.TipoProduto;

public class RepositorioTipoProduto {
	private RepositorioIdentificavel repositorioInterno;
	public RepositorioTipoProduto() {
		repositorioInterno = new RepositorioIdentificavel();
	}
	public void incluir(TipoProduto tipoProduto) {
		repositorioInterno.incluir(tipoProduto);
	}
	public TipoProduto buscar(int codigo) {
		return (TipoProduto)repositorioInterno.buscar(codigo);
	}
	public TipoProduto[] consultarTodos() {
		return (TipoProduto[])repositorioInterno.consultarTodos();
	}
}
