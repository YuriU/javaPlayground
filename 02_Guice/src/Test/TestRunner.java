package Test;

import Scope.OperationScope;
import com.google.inject.Inject;
import com.google.inject.Injector;
import Service.Service;

public class TestRunner
{
    @Inject private OperationScope scope;

    @Inject private Injector injector;

    public void RunOperationTest() {
        for (int i = 0; i < 3; i++) {
            RunOperation();
        }
    }

    private void RunOperation() {
        scope.enter();
        try {
            Service service = injector.getInstance(Service.class);

            service.Execute();
        }
        finally {
            scope.exit();
        }
    }
}
