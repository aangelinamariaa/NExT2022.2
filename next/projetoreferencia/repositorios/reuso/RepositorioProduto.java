package next.projetoreferencia.repositorios.reuso;

import next.projetoreferencia.entidades.Produto;

public class RepositorioProduto {
	private RepositorioIdentificavel repositorioInterno;
	public RepositorioProduto() {
		repositorioInterno = new RepositorioIdentificavel();
	}
	public void incluir(Produto produto) {
		repositorioInterno.incluir(produto);
	}
	public Produto buscar(long codigoEAN) {
		return (Produto)repositorioInterno.buscar(codigoEAN);
	}
	public Produto[] consultarTodos() {
		return (Produto[])repositorioInterno.consultarTodos();
	}
}
