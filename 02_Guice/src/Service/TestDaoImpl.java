package Service;

import java.util.UUID;

public class TestDaoImpl implements TestDao {
    private final UUID uuid = UUID.randomUUID();

    @Override
    public void DoDaoLogic() {
        System.out.printf("     TestDaoImpl >>> %s \r\n", uuid.toString().replace("-","").substring(0,8));
    }
}
