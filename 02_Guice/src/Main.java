import Modules.TestModule;
import Service.Service;
import Test.TestRunner;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new TestModule());

        TestRunner runner = injector.getInstance(TestRunner.class);
        runner.RunOperationTest();

    }
}
