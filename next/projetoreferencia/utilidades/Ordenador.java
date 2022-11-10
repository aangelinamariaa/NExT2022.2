package next.projetoreferencia.utilidades;

public class Ordenador {
	public static void ordenar(Comparavel[] lista) {
		Comparavel aux = null;
		for(int i=0; i<lista.length; i++) {
			for(int k=i; k<lista.length; k++) {				
				if (lista[i].comparar(lista[k]) > 0) {
					aux = lista[i];
					lista[i] = lista[k];
					lista[k] = aux;
				}
			}
		}
	}
}
