package inheritance;

public class Cliente implements Authenticable {

    private String password;

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean authenticate(String password) {
        return this.password == password;
    }
}
