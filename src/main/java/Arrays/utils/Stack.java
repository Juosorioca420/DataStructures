package Arrays.utils;

public abstract class Stack<T> implements Iterable<T> {
    public abstract boolean empty();
    public abstract T peek() throws Exception; // Top()
    public abstract T pop() throws Exception;
    public abstract void push(T e) throws Exception; // add()
    public abstract int search(T e);

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T e: this) {
            sb.append(e);
            sb.append("\n\u2193\n");
        }
        sb.replace(sb.length() - 2, sb.length(), "");
        return sb.toString();
    }
}
