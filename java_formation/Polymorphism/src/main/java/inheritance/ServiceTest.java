package inheritance;

public class ServiceTest {
    public static void main(String[] args){

        var manager = new Manager();
        var cliente = new Cliente();
        var adm = new Administrator();

        var si = new Service();
        si.authenticate(manager);
        si.authenticate(adm);
        si.authenticate(cliente);
    }
}
