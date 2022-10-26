package srcContaCorrentista.telas;

import java.util.Scanner;

import srcContaCorrentista.entidades.Conta;
import srcContaCorrentista.entidades.ContaCorrente;
import srcContaCorrentista.entidades.ContaPoupanca;
import srcContaCorrentista.entidades.Correntista;
import srcContaCorrentista.mediators.ContaMediator;
import srcContaCorrentista.mediators.CorrentistaMediator;

public class TelaSistemaConta {
    private final Scanner ENTRADA = new Scanner(System.in);
    private ContaMediator mediadorConta;
	
    private CorrentistaMediator mediadorCorrentista;
	int retorno;

    public TelaSistemaConta(CorrentistaMediator mediadorCorrentista){
        mediadorConta = new ContaMediator();
        //mediadorCorrentista = new CorrentistaMediator();
		this.mediadorCorrentista = mediadorCorrentista;
    }

    public void executarTela(){
        boolean continua;
        do {
            continua = opcaoMenuSistema();
        } while (continua == true);
    }

    private boolean opcaoMenuSistema(){
        int opcao;
        boolean retorno = true;
        System.out.println("1- Incluir Correntista");
		System.out.println("2- Incluir Conta");
		System.out.println("3- Realizar um Crédito em Conta");
		System.out.println("4- Realizar um Débito em Conta");
		System.out.println("5- Listar Correntistas");
		System.out.println("6- Listar Contas");
		System.out.println("7- Sair");
        opcao = ENTRADA.nextInt();
        switch(opcao){
            case 1:
			    incluirCorrentista();
			    break;
		    case 2:
		    	incluirConta();
		    	break;
		    case 3:
		    	creditarValor();
		    	break;
		    case 4:
		    	debitarValor();
		    	break;
		    case 5:
		    	listarCorrentistas();
		    	break;
		    case 6:
		    	listarContas();
		    	break;
		    case 7:
		    	retorno = false;
		    	break;
		}
		return retorno;
    }

	private void incluirCorrentista(){
		System.out.println("Digite o CPF - Apenas números");
		long cpf = ENTRADA.nextLong();
		System.out.println("Digite o nome do correntista");
		String nome = ENTRADA.next();
		Correntista novo = new Correntista(cpf, nome);
		retorno = mediadorCorrentista.incluirCorrentista(novo);
	}

	private void incluirConta(){
		Conta nova = null;
		double taxa = 0.00;
		System.out.println("Digite 1 para Conta Corrente ou 2 para Conta Poupança");
		int tipoConta = ENTRADA.nextInt();
		System.out.println("Digite o número da agência: ");
		int agencia = ENTRADA.nextInt();
		System.out.println("Digite o número da conta:");
		long conta = ENTRADA.nextLong();
		System.out.println("Digite o CPF do titular da conta:");
		long cpf = ENTRADA.nextLong();
		if (tipoConta == 1){
			nova = new ContaCorrente(agencia, conta, null);
			System.out.println("Informe a taxa tarifária:");
			taxa = ENTRADA.nextDouble();
		} else {
			nova = new ContaPoupanca(agencia, conta, null);
			System.out.println("Informe a taxa bonificadora:");
			taxa = ENTRADA.nextDouble(); 
		}
		retorno = mediadorConta.incluirConta(nova, cpf, taxa);
	}

	private void creditarValor(){
		System.out.println("Digite a agência que a conta pertence");
		int agencia = ENTRADA.nextInt();
		System.out.println("Digite o número da conta que será credita");
		long conta = ENTRADA.nextLong();
		System.out.println("Digite o valor a ser creditado");
		double valor = ENTRADA.nextInt();
		retorno = mediadorConta.creditar(agencia, conta, valor);
	}

	private void debitarValor(){
		System.out.println("Digite a agência que a conta pertence");
		int agencia = ENTRADA.nextInt();
		System.out.println("Digite o número da conta que será debitada");
		long conta = ENTRADA.nextLong();
		System.out.println("Digite o valor a ser debitado");
		double valor = ENTRADA.nextInt();
		retorno = mediadorConta.debitar(agencia, conta, valor);
	}

	private void listarCorrentistas(){
		Correntista[] lista = mediadorCorrentista.consultarOrdenadoPorNome();
		for (int i = 0; i >= lista.length; i++){
			System.out.println(lista[i]);
		}
	}

	private void listarContas(){
		Conta[] lista = mediadorConta.consultarOrdenadoPorSaldo();
		for (int i = 0; i >= lista.length; i++){
			System.out.println(lista[i]);
		}
	}

}
