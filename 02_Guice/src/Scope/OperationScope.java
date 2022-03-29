package Scope;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.inject.*;

import java.util.Map;

public class OperationScope implements Scope {

    private final ThreadLocal<Map<Key<?>, Object>> values = new ThreadLocal<>();

    public void enter() {
        Preconditions.checkState(values.get() == null, "Scope already entered.");
        values.set(Maps.<Key<?>, Object>newHashMap());
    }

    public void exit() {
        Preconditions.checkState(values.get() != null, "Scope not entered.");
        values.remove();
    }

    @Override
    public <T> Provider<T> scope(final Key<T> key, final Provider<T> unscoped) {
        Preconditions.checkArgument(unscoped != null,
                "Unscoped provider should not be null for key : " + key.getTypeLiteral());

        return new Provider<T>() {
            public T get() {
                Map<Key<?>, Object> scopedObjects = getScopedObjectMap();

                @SuppressWarnings("unchecked")
                T current = (T) scopedObjects.get(key);
                if (current == null && !scopedObjects.containsKey(key)) {
                    current = unscoped.get();

                    // don't remember proxies; these exist only to serve circular dependencies
                    if (Scopes.isCircularProxy(current)) {
                        return current;
                    }

                    scopedObjects.put(key, current);
                }
                return current;
            }
        };
    }

    /**
     * Gets scoped object map
     *
     * @param <T> type
     * @return scoped objects
     */
    public <T> Map<Key<?>, Object> getScopedObjectMap() {
        Map<Key<?>, Object> scopedObjects = values.get();
        if (scopedObjects == null) {
            throw new OutOfScopeException(new StringBuilder("Cannot access ")
                    .append(" outside of a scoping block.")
                    .toString());
        }
        return scopedObjects;
    }

}
