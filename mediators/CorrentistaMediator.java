package srcContaCorrentista.mediators;

import srcContaCorrentista.entidades.Correntista;
import srcContaCorrentista.repositorios.FabricaRepositorio;
import srcContaCorrentista.repositorios.RepositorioCorrentista;

public class CorrentistaMediator {
    public static final int SUCESSO = 0;
    public static final int CPF_INVALIDO = 1;
    public static final int CORRENTISTA_JA_CADASTRADO = 2;
    private RepositorioCorrentista repositorioCorrentista;

    public CorrentistaMediator(){
        repositorioCorrentista = FabricaRepositorio.getRepositorioCorrentista();
    }

    public int incluirCorrentista(long cpf, String nome){
        if (cpf < 0){
            return CPF_INVALIDO;
        } else  {
            if (repositorioCorrentista.buscarPorCpf(cpf) == null){
                repositorioCorrentista.incluirCorrentista(cpf, nome);
            } else {   
                return CORRENTISTA_JA_CADASTRADO;
            }
        }
        return SUCESSO;
    }

    public Correntista[] consultarOrdenadoPorNome(){
        Correntista listaCorre[] = repositorioCorrentista.consultarTodos();
        for (int i = 0; i < listaCorre.length; i++) {
			for (int k = i; k < listaCorre.length; k++) {
				String nome1 = listaCorre[i].getNome();
				String nome2 = listaCorre[k].getNome();
				if (nome1.compareTo(nome2) > 0) {
					Correntista aux = listaCorre[i];
					listaCorre[i] = listaCorre[k];
					listaCorre[k] = aux;
				}
			}
		}
        return listaCorre;
    }
}
