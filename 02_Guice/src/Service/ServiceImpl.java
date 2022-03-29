package Service;

import com.google.inject.Inject;
import com.google.inject.Provider;

import java.util.UUID;

public class ServiceImpl implements Service {
    private final UUID uuid = UUID.randomUUID();

    @Inject private Provider<PerfCounter> counterProvider;

    @Override
    public void Execute() {
        System.out.printf("ServiceImpl >>> %s \r\n", uuid.toString().replace("-","").substring(0,8));

        PerfCounter counter1 = counterProvider.get();
        counter1.measureDao();

        PerfCounter counter2 = counterProvider.get();
        counter2.measureDao();
    }
}
