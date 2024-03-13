package LLD.LRU.interfaces.impl;

import LLD.LRU.CacheElement;
import LLD.LRU.interfaces.Cache;
import LLD.LRU.interfaces.Node;

import java.util.Map;

public class LRU<K,V> implements Cache<K,V> {

    private Integer capacity;
    private Integer size;
    private Map<K, LinkedListNode<CacheElement<K,V>>> linkedMap;
    private DoublyLinkedList<CacheElement<K,V>> doublyLinkedList;



    @Override
    public CacheElement<K,V> get(K key) {
        if(linkedMap.containsKey(key)){
            Node<CacheElement<K,V>> node = linkedMap.get(key).getNext();
            return node.getValue();
        }else{
            //TODO: change it
            return null;
        }
    }

    @Override
    public Boolean set(K key, V value) {
        LinkedListNode<CacheElement<K, V>> node = new LinkedListNode<>(new CacheElement<>(key, value));
        if(!isFull()){
            if(linkedMap.containsKey(key)){

            }else {

                LinkedListNode<V> mapNode = new LinkedListNode<>();
                //TODO: change it
//                mapNode.setNext(node);
//                linkedMap.put(key, mapNode);
//                doublyLinkedList.push(node);
            }
        }

        return null;
    }

    @Override
    public Boolean isEmpty() {
        return null;
    }

    @Override
    public Boolean isFull() {
        return null;
    }
}
