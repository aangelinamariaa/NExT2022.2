package next.projetoreferencia.entidades;

public class ProdutoEspecial extends Produto {
	private double fatorReducao;
	public ProdutoEspecial(long codigoEAN, String descricao, TipoProduto tipo, 
			double fatorReducao) {
		super(codigoEAN, descricao, tipo);
		this.fatorReducao = fatorReducao;
	}
	@Override
	public void aumentarPreco(double valor) {
		preco = preco + valor - fatorReducao;
	}
	@Override
	public void baixarPreco(double valor) {
		preco = preco - valor;
	}
	public double getFatorReducao() {
		return fatorReducao;
	}
	public void setFatorReducao(double fatorReducao) {
		this.fatorReducao = fatorReducao;
	}
}
