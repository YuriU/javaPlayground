package Service;

import com.google.inject.Inject;

import java.util.UUID;

public class TestDaoImpl implements TestDao {
    private final UUID uuid = UUID.randomUUID();

    @Inject private ConnectionPool connectionPool;

    @Override
    public void DoDaoLogic() {
        System.out.printf("     TestDaoImpl >>> %s \r\n", uuid.toString().replace("-","").substring(0,8));
        connectionPool.getConnection();
    }
}
