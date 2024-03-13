package LLD.LRU.interfaces.impl;

import LLD.LRU.interfaces.Node;
import LLD.LRU.interfaces.Queue;

import java.util.LinkedList;
import java.util.Objects;

public class DoublyLinkedList<T> implements Queue<T> {

    private Node<T> head;
    private Node<T> tail;
    private Integer capacity;
    private Integer size;

    public DoublyLinkedList(Integer capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    @Override
    public Boolean push(T value) {
        if(!isFull()) {
            Node<T> node = new LinkedListNode<>(value);
            if(head == null){
                head = node;
                tail = node;
                size += 1;
                return true;
            }
            node.setNext(head);
            head = node;
            size += 1;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Node<T> poll() {
        if(!isEmpty()){
           return remove(tail);
        }
        return new LinkedListNode<>();

    }

    @Override
    public Node<T> remove(Node<T> node) {
        Node<T> prevNode = node.getPrev();
        Node<T> nextNode = node.getNext();
        if(head == tail && head == node){ // removing only node i.e. head and tail point to same node
            head = null;
            tail = null;
        }else if(node == head){ // removing first node
            head = nextNode;
            nextNode.setPrev(null);
        } else if(node == tail){ // removing last node
            tail = prevNode;
            prevNode.setNext(null);
        }else{ // removing in between node
            nextNode.setPrev(prevNode);
            prevNode.setNext(nextNode);
        }
        node.remove();
        size -= 1;
        return node;
    }

    @Override
    public Boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Boolean isFull() {
        return Objects.equals(size, capacity);
    }
}
