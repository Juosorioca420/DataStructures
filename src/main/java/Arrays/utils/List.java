package Arrays.utils;

public interface List<T> extends Iterable<T> {
    void add(T e) throws Exception;
    void add(int index, T e) throws Exception;

    void clear();
    boolean contains(T e);

    T get(int index) throws Exception;
    int indexOf(T e);

    boolean isEmpty();

    T remove(int index) throws Exception;
    boolean remove(T e) throws Exception;
    
    int size();
}
