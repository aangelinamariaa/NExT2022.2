package srcContaCorrentista.entidades;

public class ContaPoupanca extends Conta {
    private double taxaBonus;

    public ContaPoupanca(int nAgencia, long nConta, Correntista corre){
        super(nAgencia, nAgencia, corre);
        this.taxaBonus = 0.0;
    }

    @Override
    public void debitar(double valor){
        saldo = saldo - valor;
    }

    @Override
    public void creditar(double valor){
        saldo = saldo + (valor * (1 + this.taxaBonus));
    }

    public double getTaxaBonus() {
        return taxaBonus;
    }

    public void setTaxaBonus(double taxaBonus) {
        this.taxaBonus = taxaBonus;
    }

    
}