package LLD.LRU.interfaces;

public interface Queue<T> {
    Boolean push(T value);
    Node<T> poll();
    Node<T> remove(Node<T> value);
    Boolean isEmpty();
    Boolean isFull();

}
