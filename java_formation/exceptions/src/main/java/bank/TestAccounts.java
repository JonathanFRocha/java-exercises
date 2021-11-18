package bank;

public class TestAccounts {
    public static void main(String[] args){

        ContaCorrente another = null;


        var cc = new ContaCorrente(100, 100);
        cc.deposita(500);
        var cp = new ContaPoupanca(200, 200);
        cp.deposita(200);

        cc.transfere(200,cp);

        System.out.println(cc.getSaldo());
    }
}
