public class TestAccountWithCheckedException {

    public static void main(String[] args){
        var account = new Acc();

        try{
            account.deposit();
        }catch (MyException e) {
            System.out.println(e);
        }

    }
}
