package inheritance;

public class Service {

    private String password = "2222";

    public void authenticate(Authenticable m) {
        var authResponse = m.authenticate(password);
        if(authResponse){
            System.out.println("can login");
        }else {
            System.out.println("cant login");
        }
    }
}
