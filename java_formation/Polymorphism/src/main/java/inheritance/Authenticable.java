package inheritance;

public interface Authenticable {

    public  String getPassword();

    public void setPassword(String password);
    public boolean authenticate(String password);
}
