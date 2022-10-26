package srcContaCorrentista.repositorios;

import srcContaCorrentista.entidades.Correntista;

public class RepositorioCorrentista {
    private Correntista[] listaCorrentista;
    private int tamanhoAtual = 0;

    public void incluirCorrentista(Correntista correntista){
        listaCorrentista[tamanhoAtual] = correntista;
        tamanhoAtual++;
    }

    public Correntista buscarPorCpf(long cpf){
        for (Correntista item : listaCorrentista){
            if (item.getCpf() == cpf){
                return item;
            }
        }
        return null;
    }

    public Correntista[] consultarTodos(){
        Correntista[] listaAux = new Correntista[tamanhoAtual];
        int i = 0;
        for (Correntista item : listaCorrentista){
            if (item != null){
                listaAux[i] = item;
                i++;
            }
        }
        return listaAux;
    }
}
