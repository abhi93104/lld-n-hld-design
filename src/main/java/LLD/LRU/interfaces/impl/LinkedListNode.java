package LLD.LRU.interfaces.impl;

import LLD.LRU.interfaces.Node;

public class LinkedListNode<T> implements Node<T> {

    private T value;
    private Node<T> next;
    private Node<T> prev;

    public LinkedListNode() {
    }
    public LinkedListNode(T value) {
        this.value = value;
    }

    @Override
    public Boolean setValue(T value) {
        return null;
    }

    @Override
    public void setNext(Node<T> node) {
        this.next = node;
    }

    public Boolean setPrev(Node<T> node) {
        return null;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    @Override
    public Boolean remove() {
        this.next = null;
        this.prev = null;
        return true;
    }
}
