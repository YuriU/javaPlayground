package Service;

import com.google.inject.Inject;

import java.util.UUID;

public class PerfCounter {
    private final UUID uuid = UUID.randomUUID();

    @Inject
    private TestDao dao;

    public void measureDao() {
        System.out.printf("   PerfCounter.Start >>> %s \r\n", uuid.toString().replace("-","").substring(0,8));
        dao.DoDaoLogic();
        System.out.printf("   PerfCounter.End >>> %s \r\n", uuid.toString().replace("-","").substring(0,8));
    }
}
