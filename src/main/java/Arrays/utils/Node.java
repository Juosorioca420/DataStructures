package Arrays.utils;

public class Node<T> {
    //Property which store the value of a specific element in the list
    private T key;
    //Property which store a pointer to the following element in the list
    private Node<T> next;

    
    public Node(T key) {
        this.key = key;
        next = null;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

}
