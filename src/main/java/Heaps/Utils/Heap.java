package Heaps.Utils;

public interface Heap< T extends Comparable<T> >{
    T extract(); // poll()
    T get();    // peek()

    T remove(int i);
    void add(T e);
    void update(int i, T e);
}
