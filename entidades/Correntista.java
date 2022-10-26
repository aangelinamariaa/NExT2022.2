package srcContaCorrentista.entidades;

public class Correntista{
    private long cpf;
    private String nome;

    public Correntista(long cpf, String nome){
        this.cpf = cpf;
        this.nome = nome;
    }

    public long getCpf(){
        return this.cpf;
    }
    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
}