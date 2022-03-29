package Service;

import java.util.UUID;

public class ConnectionPool {
    private final UUID uuid = UUID.randomUUID();

    public void getConnection() {
        System.out.printf("         ConnectionPool >>> %s \r\n", uuid.toString().replace("-","").substring(0,8));
    }
}
