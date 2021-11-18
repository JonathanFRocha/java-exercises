package bank;

public class ContaPoupanca extends Account {
    public ContaPoupanca(int agencia, int numero) {
        super(agencia, numero);
    }

    @Override
    public boolean saca(double valor) {
        double valueToGet = valor + 10;
        return super.saca(valueToGet);
    }
}
