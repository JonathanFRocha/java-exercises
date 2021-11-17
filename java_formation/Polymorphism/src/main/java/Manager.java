public class Manager extends Employee {

    private String password;

    public Manager() {

    }

    public Manager(String name, String cpf, double salary) {
        super(name, cpf, salary);

    }

    @Override
    public double getBonus(){
        return super.getBonus() + super.getSalary();
    }

    public boolean authenticate(String password) {
        return password == this.password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
