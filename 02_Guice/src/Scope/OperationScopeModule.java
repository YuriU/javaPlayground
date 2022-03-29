package Scope;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class OperationScopeModule extends AbstractModule {

    private final OperationScope operationScope = new OperationScope();

    @Override
    protected void configure() {
        super.configure();
        bindScope(OperationScoped.class, operationScope);
    }

    @Provides
    OperationScope provideOperationScope() {
        return operationScope;
    }
}
