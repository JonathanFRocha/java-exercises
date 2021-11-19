package connection;

public class Connection implements AutoCloseable {

    public Connection() {
        System.out.println("Opening connection");
    }

    public void readData() {
        System.out.println("Receiving data");
        throw new IllegalStateException("data corrupted!");
    }

    public void closeConnection() {
        System.out.println("Closing connection");
    }

    @Override
    public void close() throws Exception {
        closeConnection();
    }
}
