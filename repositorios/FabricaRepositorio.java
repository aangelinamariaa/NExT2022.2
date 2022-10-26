package srcContaCorrentista.repositorios;

public class FabricaRepositorio {
    private static final RepositorioConta repositorioConta = new RepositorioConta();
    public static RepositorioConta getRepositorioConta(){
        return repositorioConta;
    }
    
    private static final RepositorioCorrentista repositorioCorrentista = new RepositorioCorrentista();
    public static RepositorioCorrentista getRepositorioCorrentista(){
        return repositorioCorrentista;
    }
}
