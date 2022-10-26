package srcContaCorrentista.mediators;

import srcContaCorrentista.entidades.Correntista;
import srcContaCorrentista.repositorios.RepositorioCorrentista;

public class CorrentistaMediator {
    public static final int SUCESSO = 0;
    public static final int CPF_INVALIDO = 1;
    public static final int CORRENTISTA_JA_CADASTRADO = 2;
    private RepositorioCorrentista repositorioCorrentista;
    
    public CorrentistaMediator(RepositorioCorrentista repositorioCorrentista){
        this.repositorioCorrentista = repositorioCorrentista;
    }

    public int incluirCorrentista(Correntista corre){
        //Correntista correAux = null;
        if (corre.getCpf() < 0){
            return CPF_INVALIDO;
        } else  {
            var xpto = repositorioCorrentista.buscarPorCpf(corre.getCpf());
            if (repositorioCorrentista.buscarPorCpf(corre.getCpf()).equals(null)){
           // if (correAux == null){
                repositorioCorrentista.incluirCorrentista(corre);
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
