package LLD.LRU.interfaces;

import LLD.LRU.CacheElement;

public interface Cache<K,V> {
    CacheElement<K,V> get(K key);
    Boolean set(K key, V value);
    Boolean isEmpty();
    Boolean isFull();



}
