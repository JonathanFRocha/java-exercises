public class TestAccountWithCheckedException {

    public static void main(String[] args) throws CheckedException{
        var account = new Acc();

        try{
            account.deposit();
        }catch (Exception e) {
            System.out.println(e);
        }

    }
}
