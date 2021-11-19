import bank.MyException;

public class FlowWithExceptions {
    public static void main(String[] args) {
        System.out.println("Start of main");
        try {
        method1();
        }catch (MyException | NullPointerException e){
            System.out.println(e);
        }
        System.out.println("End of main");
    }

    private static void method1() {
        System.out.println("Start of method1");
        method2();
        System.out.println("End of method1");
    }

    private static void method2() {
        System.out.println("Start of method2");

        throw new MyException("RIP");
        //System.out.println("End of method2");
    }
}
