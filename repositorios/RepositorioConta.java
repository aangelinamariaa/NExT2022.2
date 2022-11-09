package srcContaCorrentista.repositorios;

import srcContaCorrentista.entidades.Conta;
import srcContaCorrentista.entidades.ContaCorrente;
import srcContaCorrentista.entidades.ContaPoupanca;
import srcContaCorrentista.entidades.Correntista;

public class RepositorioConta {
    private Conta[] listaConta;
    private int tamanhoAtual = 0;

    public void incluirConta(Conta conta, int tipoConta, double taxa, Correntista corre){
        if (tipoConta == 1){
            ContaCorrente nova = new ContaCorrente(conta.getNumeroAgencia(), conta.getNumeroConta(), corre);
            nova.setTarifa(taxa);
        } else {
            ContaPoupanca nova = new ContaPoupanca(conta.getNumeroAgencia(), conta.getNumeroConta(), corre);
            nova.setTaxaBonus(taxa);
        }
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
