package srcContaCorrentista.entidades;

public class ContaCorrente extends Conta {
    private double tarifa;

    public ContaCorrente(int nAgencia, long nConta, Correntista corre){
        super(nAgencia, nAgencia, corre);
        this.tarifa = 0.0;
    }

    @Override
    public void debitar(double valor){
        saldo = saldo - valor;
    }

    @Override
    public void creditar(double valor){
        saldo = saldo + valor;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    
}


