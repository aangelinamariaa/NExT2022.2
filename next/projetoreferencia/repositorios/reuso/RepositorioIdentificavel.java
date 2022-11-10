package next.projetoreferencia.repositorios.reuso;

import next.projetoreferencia.utilidades.Identificavel;

public class RepositorioIdentificavel {
	private Identificavel[] listaIdentificaveis = new Identificavel[100];
	private int tamanhoAtual = -1;
	public void incluir(Identificavel ident) {
		tamanhoAtual++;
		listaIdentificaveis[tamanhoAtual] = ident;		
	}
	public Identificavel buscar(long identificador) {
		for (Identificavel ident : listaIdentificaveis) {
			if (ident != null && ident.getIdentificador() == identificador) {
				return ident;
			}
		}
		return null;
	}
	public Identificavel[] consultarTodos() {
		Identificavel[] listaRetorno = new Identificavel[tamanhoAtual + 1];		
		for (int i=0; i<listaRetorno.length; i++) {
			listaRetorno[i] = listaIdentificaveis[i];
		}
		return listaRetorno;
	}
}
