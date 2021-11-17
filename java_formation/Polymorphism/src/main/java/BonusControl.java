public class BonusControl {

    private double soma;

    public void register(Employee g){
        var bonus = g.getBonus();
        soma = soma + bonus;
    }

    public double getSoma() {
        return soma;
    }

    public void setSoma(double soma) {
        this.soma = soma;
    }
}
