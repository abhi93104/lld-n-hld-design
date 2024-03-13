package LLD.LRU.interfaces;

public interface Node<T> {

    Boolean setValue(T value);
    void setNext(Node<T> node);

    Boolean setPrev(Node<T> node);
    Node<T> getNext();

    T getValue();
    Node<T> getPrev();

    Boolean remove();





}
