package srcContaCorrentista.entidades;

public abstract class Conta {
    private int numeroAgencia;
    private long numeroConta;
    private Correntista correntista;
    protected double saldo;

    public Conta(int nAgencia, int nConta, Correntista correntista){
        this.numeroAgencia = nAgencia;
        this.numeroConta = nConta;
        this.correntista = correntista;
        this.saldo = 0.0;
    }

    public abstract void debitar(double valor);
    public abstract void creditar(double valor);

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public long getNumeroConta() {
        return numeroConta;
    } 
    
    public double getSaldo(){
        return this.saldo;
    }

    public Correntista getCorrentista() {
        return correntista;
    }

    public void setCorrentista(Correntista correntista) {
        this.correntista = correntista;
    }
}
