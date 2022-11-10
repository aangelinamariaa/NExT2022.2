package next.projetoreferencia.entidades;

public class ProdutoPerecivel extends Produto {
	private int prazoVencimento;
	public ProdutoPerecivel(long codigoEAN, String descricao, TipoProduto tipo, 
			int prazoVencimento) {
		super(codigoEAN, descricao, tipo);
		this.prazoVencimento = prazoVencimento;
	}
	@Override
	public void aumentarPreco(double valor) {
		preco = preco + valor;
	}
	@Override
	public void baixarPreco(double valor) {
		preco = preco - valor;
	}
	public int getPrazoVencimento() {
		return prazoVencimento;
	}
	public void setPrazoVencimento(int prazoVencimento) {
		this.prazoVencimento = prazoVencimento;
	}
}
