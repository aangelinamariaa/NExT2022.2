package next.projetoreferencia.entidades;

import next.projetoreferencia.utilidades.Comparavel;
import next.projetoreferencia.utilidades.Identificavel;

public abstract class Produto implements Comparavel, Identificavel {
	private long codigoEAN;
	private String descricao;
	private TipoProduto tipo;
	protected double preco; 
	public Produto(long codigoEAN, String descricao, TipoProduto tipo) {
		this.codigoEAN = codigoEAN;
		this.descricao = descricao;
		this.tipo = tipo;
		this.preco = 0.0;
	}
	public abstract void aumentarPreco(double valor);
	public abstract void baixarPreco(double valor);
	@Override
	public int comparar(Comparavel comp) {
		Produto outro = (Produto)comp;
		if (preco == outro.getPreco()) {
			return 0;
		} else if (preco > outro.getPreco()) {
			return 1;
		} else {
			return -1;
		}
	}
	@Override
	public long getIdentificador() {
		return codigoEAN;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public TipoProduto getTipo() {
		return tipo;
	}
	public void setTipo(TipoProduto tipo) {
		this.tipo = tipo;
	}
	public long getCodigoEAN() {
		return codigoEAN;
	}
	public double getPreco() {
		return preco;
	}
}
