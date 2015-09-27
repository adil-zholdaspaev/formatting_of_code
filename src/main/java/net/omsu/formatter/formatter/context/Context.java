package net.omsu.formatter.formatter.context;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Class contain some metadata.
 */
public class Context {

    private final Map<String, Object> values;

    public Context() {
        values = new HashMap<>();
    }

    public void set(String key, Object value) {
        //assert !values.containsKey(key);
        values.put(key, value);
    }

    public void remove(final String key) {
        values.remove(key);
    }

    public Optional<Object> get(String key) {
        return Optional.ofNullable(values.get(key));
    }

    public <T> Optional<T> get(String key, Class<T> c) {
        return get(key).flatMap(value -> Optional.ofNullable(c.cast(value)));
    }

    public Optional<String> getString(String key) {
        return get(key, String.class);
    }

    public Optional<Boolean> getBoolean(String key) {
        return get(key, Boolean.class);
    }

    public Optional<Integer> getInteger(String key) {
        return get(key, Integer.class);
    }

    public Optional<Long> getLong(String key) {
        return get(key, Long.class);
    }

    public Optional<Double> getDouble(String key) {
        return get(key, Double.class);
    }
}
