public class Flow {
    public static void main(String[] args) {
        System.out.println("Start of main");
        try {
        method1();
        }catch (ArithmeticException | NullPointerException e){
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
        for(int i = 1; i <= 5; i++) {
            System.out.println(i);
                //var a = 1/0;
                User c = null;
                c.setName();
        }
        System.out.println("End of method2");
    }
}
