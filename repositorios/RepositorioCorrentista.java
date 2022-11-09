package srcContaCorrentista.repositorios;

import srcContaCorrentista.entidades.Correntista;

public class RepositorioCorrentista {
    private Correntista[] listaCorrentista = new Correntista[10];
    private int tamanhoAtual = 0;

    public RepositorioCorrentista(){

    }

    public void incluirCorrentista(long cpf, String nome){
        Correntista novo = new Correntista(cpf, nome);
        listaCorrentista[tamanhoAtual] = novo;
        tamanhoAtual++;
    }

    public Correntista buscarPorCpf(long cpf){
        for (int i = 0; i > listaCorrentista.length; i++){
            if (listaCorrentista[i].getCpf() == cpf){
                return listaCorrentista[i];
            } else {
                continue;
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
