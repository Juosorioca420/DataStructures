package Arrays.utils;

public abstract class Queue<T> implements Iterable<T> {
    public abstract boolean empty();
    public abstract void add(T e) throws Exception;
    public abstract T peek() throws Exception;
    public abstract T poll() throws Exception;
    public abstract int search(T e);


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[ ");

        for (T e: this) {
            s.append(e);
            s.append(" <- ");
        }
        int lastIndex = s.lastIndexOf("<");
        if( lastIndex != -1 ){ s.delete(lastIndex, lastIndex + 3); }

        s.append("]");
        return s.toString().trim();
    }

}
