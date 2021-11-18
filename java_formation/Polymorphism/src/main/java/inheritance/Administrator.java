package inheritance;

public class Administrator extends Employee implements Authenticable {

    @Override
    public double getBonus() {
        return super.getSalary();
    }

    private String password = "1234";

    public Administrator() {

    }

    public Administrator(String name, String cpf, double salary) {
        super(name, cpf, salary);

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean authenticate(String password) {
        return password == this.password;
    }
}
