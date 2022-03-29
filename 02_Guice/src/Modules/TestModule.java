package Modules;

import Scope.OperationScopeModule;
import Scope.OperationScoped;
import Service.Service;
import Service.ServiceImpl;
import Service.TestDao;
import Service.TestDaoImpl;
import Test.TestRunner;
import com.google.inject.AbstractModule;
import Service.ConnectionPool;
import com.google.inject.Singleton;

public class TestModule extends AbstractModule {

    @Override
    protected void configure() {
        super.configure();
        install(new OperationScopeModule());
        bind(Service.class).to(ServiceImpl.class).in(OperationScoped.class);
        bind(TestDao.class).to(TestDaoImpl.class).in(OperationScoped.class);
        bind(TestRunner.class).in(Singleton.class);
        bind(ConnectionPool.class).in(Singleton.class);
    }


}
