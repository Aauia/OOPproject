package Education;

import java.util.Comparator;

public class ByAlphabetComparator<T> implements Comparator<T> {
    private final StringGetter<T> getter;

    // Constructor to accept a method reference to the attribute
    public ByAlphabetComparator(StringGetter<T> getter) {
        this.getter = getter;
    }

    @Override
    public int compare(T o1, T o2) {
        String s1 = getter.getString(o1);
        String s2 = getter.getString(o2);
        return s1.compareToIgnoreCase(s2); // Case-insensitive comparison
    }

    // Functional interface for accessing string attributes
    @FunctionalInterface
    public interface StringGetter<T> {
        String getString(T obj);
    }
}
