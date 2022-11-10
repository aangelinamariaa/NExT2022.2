package next.projetoreferencia.telas;

import java.util.Scanner;

import next.projetoreferencia.entidades.Produto;
import next.projetoreferencia.entidades.ProdutoEspecial;
import next.projetoreferencia.entidades.ProdutoPerecivel;
import next.projetoreferencia.entidades.TipoProduto;
import next.projetoreferencia.mediators.ProdutoMediator;
import next.projetoreferencia.mediators.TipoProdutoMediator;

public class TelaSistema {
	private final Scanner ENTRADA = new Scanner(System.in);
	private TipoProdutoMediator tipoProdutoMediator;
	private ProdutoMediator produtoMediator;
	public TelaSistema() {
		tipoProdutoMediator = new TipoProdutoMediator();
		produtoMediator = new ProdutoMediator();
	}
	public void executarTela() {
		boolean continua;
		do {
			continua = menuPrincipal();
		} while(continua);		
	}
	private boolean menuPrincipal() {
		System.out.println("1- Incluir tipo produto");
		System.out.println("2- Incluir produto");
		System.out.println("3- Aumenta preço produto");
		System.out.println("4- Baixar preço produto");
		System.out.println("5- Listar tipos produtos");
		System.out.println("6- Listar produtos");
		System.out.println("7- Sair");
		int opcao = ENTRADA.nextInt();
		boolean ret = true;
		switch (opcao) { 
		case 1:
			incluirTipoProduto();
			break;
		case 2:
			incluirProduto();
			break;
		case 3:
			aumentarPreco();
			break;
		case 4:
			baixarPreco();
			break;
		case 5:
			listarTiposProdutos();
			break;
		case 6:
			listarProdutos();
			break;
		case 7:
			ret = false;
			break;
		}
		return ret;
	}
	private void incluirTipoProduto() {
		System.out.println("Digite o código: ");
		int codigo = ENTRADA.nextInt();
		System.out.println("Digite o nome: ");
		String nome = ENTRADA.next();
		TipoProduto tipoProduto = new TipoProduto(codigo, nome);
		int ret = tipoProdutoMediator.incluir(tipoProduto);
		mostrarSucessoNaoSucesso("Tipo produto incluído ", "Tipo produto não incluído ", 
				TipoProdutoMediator.SUCESSO, ret);		
	}
	private void incluirProduto() {
		Produto prod = null;
		double fatorReducao = 0.0;
		int prazoVencimento = 0;
		System.out.println("Digite 1 para Produto Perecível e 2 para Produto Especial");
		int opcProduto = ENTRADA.nextInt();
		System.out.println("Digite o código EAN: ");
		long codigoEAN = ENTRADA.nextLong();
		System.out.println("Digite a descrição: ");
		String nome = ENTRADA.next();
		System.out.println("Digite o código do tipo de produto: ");
		int codigoTipoProduto = ENTRADA.nextInt(); 
		if (opcProduto == 1) {
			System.out.println("Digite o prazo vencimento: ");
			prazoVencimento = ENTRADA.nextInt();
			prod = new ProdutoPerecivel(codigoEAN, nome, null, prazoVencimento);
		} else {
			System.out.println("Digite o fator de redução: ");
			fatorReducao = ENTRADA.nextDouble();
			prod = new ProdutoEspecial(codigoEAN, nome, null, fatorReducao);
		}
		int ret = produtoMediator.incluir(prod, codigoTipoProduto);
		mostrarSucessoNaoSucesso("Produto incluído ", "Produto não incluído ", 
				ProdutoMediator.SUCESSO, ret);
	}
	private void aumentarPreco() {
		System.out.println("Digite o código EAN: ");
		long codigoEAN = ENTRADA.nextLong();
		System.out.println("Digite o valor: ");
		double valor = ENTRADA.nextDouble();
		int ret = produtoMediator.aumentarPreco(codigoEAN, valor);
		mostrarSucessoNaoSucesso("Preço aumentado", "Preço não aumentado", 
				ProdutoMediator.SUCESSO, ret);
	}
	private void baixarPreco() {
		System.out.println("Digite o código EAN: ");
		long codigoEAN = ENTRADA.nextLong();
		System.out.println("Digite o valor: ");
		double valor = ENTRADA.nextDouble();
		int ret = produtoMediator.baixarPreco(codigoEAN, valor);
		mostrarSucessoNaoSucesso("Preço baixado", "Preço não baixado", 
				ProdutoMediator.SUCESSO, ret); 
	}
	private void listarTiposProdutos() {
		TipoProduto[] tiposProdutos = tipoProdutoMediator.consultarOrdenadoPorNome();
		for (TipoProduto tipoProduto : tiposProdutos) {
			System.out.println(tipoProduto.getNome() + " , " 
					+ tipoProduto.getCodigo());			
		}
	}
	private void listarProdutos() {
		Produto[] produtos = produtoMediator.consultarOrdenadoPorPreco();
		for (Produto produto : produtos) {
			System.out.println(produto.getPreco()+ " , " 
					+ produto.getDescricao() + " , "
					+ produto.getCodigoEAN());			
		}
	}	
	private void mostrarSucessoNaoSucesso(String msgSucesso, String msgNaoSucesso, 
			int codigoSucesso, int ret) {
		if (ret == codigoSucesso) {
			System.out.println(msgSucesso + " com sucesso");
		} else {
			System.out.println(msgNaoSucesso + ", cod retorno: " + ret);
		}		
	}
}
