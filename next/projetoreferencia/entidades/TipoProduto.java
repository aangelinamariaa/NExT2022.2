package next.projetoreferencia.entidades;

import next.projetoreferencia.utilidades.Comparavel;
import next.projetoreferencia.utilidades.Identificavel;

public class TipoProduto implements Comparavel, Identificavel {
	private int codigo;
	private String nome;
	public TipoProduto(int codigo, String nome) {	
		this.codigo = codigo;
		this.nome = nome;
	}

	@Override
	public int comparar(Comparavel comp) {
		TipoProduto outro = (TipoProduto)comp;
		return nome.compareTo(outro.getNome());
	}		
	@Override
	public long getIdentificador() {
		return codigo;
	}	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCodigo() {
		return codigo;
	}
}
