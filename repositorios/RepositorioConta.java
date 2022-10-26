package srcContaCorrentista.repositorios;

import srcContaCorrentista.entidades.Conta;

public class RepositorioConta {
    private Conta[] listaConta;
    private int tamanhoAtual = 0;

    public void incluirConta(Conta conta){
        listaConta[tamanhoAtual] = conta;
        tamanhoAtual++;
    }

    public Conta buscarConta(int nAgencia, long nConta){
        for (Conta item : listaConta){
            if (item != null && item.getNumeroAgencia() == nAgencia && item.getNumeroConta() == nConta){
                return item;
            }
        }
        return null;
    }

    public Conta[] consultarTodos(){
        Conta[] listaRetorno = new Conta[tamanhoAtual];
        int i = 0;
        for (Conta item : listaConta){
            if (item != null){
                listaRetorno[i] = item;
                i++;
            }
        }
        return listaRetorno;
    }
}
