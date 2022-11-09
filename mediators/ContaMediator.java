package srcContaCorrentista.mediators;

import srcContaCorrentista.entidades.Conta;
import srcContaCorrentista.entidades.Correntista;
import srcContaCorrentista.repositorios.FabricaRepositorio;
import srcContaCorrentista.repositorios.RepositorioConta;
import srcContaCorrentista.repositorios.RepositorioCorrentista;

public class ContaMediator {
    public static final int SUCESSO = 0;
    public static final int CONTA_JA_EXISTE = 1;
    public static final int DEBITO_MAIOR_QUE_SALDO = 2;
    public static final int AGENCIA_INVALIDA = 3;
    public static final int CONTA_INVALIDA = 4;
    public static final int CPF_INVALIDO = 5;
    public static final int CORRENTISTA_JA_CADASTRADO = 6;
    public static final int VALOR_INVALIDO = 7;
    private RepositorioConta repositorioConta;
    private RepositorioCorrentista repositorioCorrentista;

    
    public ContaMediator() {
        repositorioConta = FabricaRepositorio.getRepositorioConta();
        repositorioCorrentista = FabricaRepositorio.getRepositorioCorrentista();
    }

    public int incluirConta(int agencia, long conta, long cpf, int tipoConta, double taxa){
        if (cpf <= 0){
            return CPF_INVALIDO;
        } else {
            Correntista correAux = repositorioCorrentista.buscarPorCpf(cpf);
            if (correAux != null){
                if (agencia <= 0){
                    return AGENCIA_INVALIDA;
                } else if (conta <= 0){
                    return CONTA_INVALIDA;
                } else {
                    Conta contaAux = repositorioConta.buscarConta(agencia, conta);
                    if (conta == contaAux.getNumeroConta()){
                        return CONTA_JA_EXISTE;
                    } else {
                        contaAux.setCorrentista(correAux);
                        repositorioConta.incluirConta(contaAux, tipoConta, taxa, correAux);
                    }
                }
            } else {
                return CPF_INVALIDO;
            }
        }
        return SUCESSO;
    }

    public int debitar(int agencia, long conta, double valor){
        Conta contaAux = repositorioConta.buscarConta(agencia, conta);
        if (contaAux == null){
            return CONTA_INVALIDA;
        } else if (contaAux.getSaldo() - valor < 0){
            return DEBITO_MAIOR_QUE_SALDO;
        } else {
            contaAux.debitar(valor);
        }
        return SUCESSO;
    }

    public int creditar(int agencia, long conta, double valor){
        if (valor > 0){
            Conta contaAux = repositorioConta.buscarConta(agencia, conta);
            if (contaAux == null){
                return CONTA_INVALIDA;
            } else {
                contaAux.creditar(valor);
            }
        } else {
            return VALOR_INVALIDO;
        }
        return SUCESSO;
    }

    public Conta[] consultarOrdenadoPorSaldo(){
        Conta contas[] = repositorioConta.consultarTodos();
        for (int i = 0; i < contas.length; i++) {
			for (int k = i; k < contas.length; k++) {
				double saldo1 = contas[i].getSaldo();
				double saldo2 = contas[k].getSaldo();
				if (saldo1 > saldo2) {
					Conta aux = contas[i];
					contas[i] = contas[k];
					contas[k] = aux;
				}
			}
		}
        return contas;
    }
}
