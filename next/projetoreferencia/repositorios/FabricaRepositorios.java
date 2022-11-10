package next.projetoreferencia.repositorios;

public class FabricaRepositorios {
	private static RepositorioProduto repositorioProduto = 
			new RepositorioProduto();
	private static RepositorioTipoProduto repositorioTipoProduto = 
			new RepositorioTipoProduto();
	public static RepositorioTipoProduto getRepositorioTipoProduto() {
		return repositorioTipoProduto;
	}
	public static RepositorioProduto getRepositorioProduto() {
		return repositorioProduto;
	}	
}
