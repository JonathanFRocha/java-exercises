package inheritance;

public class Manager extends Employee implements Authenticable {

    private String password = "2222";

    public Manager() {

    }

    public Manager(String name, String cpf, double salary) {
        super(name, cpf, salary);

    }

    @Override
    public double getBonus(){
        return 1000 + super.getSalary();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean authenticate(String password) {
        return this.password == password;
    }
}
