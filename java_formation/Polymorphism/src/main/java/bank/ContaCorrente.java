package bank;

public class ContaCorrente extends Account{
    public ContaCorrente(int agency, int number){
        super(agency, number);
    }

    @Override
    public boolean saca(double valor) {
        double valueToGet = valor + 0.2;
        return super.saca(valueToGet);
    }
}
