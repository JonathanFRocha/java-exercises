package inheritance;

public class TestReferences {

    public static void main(String[] args){
        Manager g1 = new Manager("jonathan", "11234", 123.0);
        Employee g2 = new Manager("jonathan", "11234", 123.0);
        Employee e1 = new Manager("jonathan", "11234", 300.0);


        var bonusControl = new BonusControl();

        bonusControl.register(g1);
        bonusControl.register(g2);
        bonusControl.register(e1);


        System.out.println("total " +bonusControl.getSoma());
    }
}
