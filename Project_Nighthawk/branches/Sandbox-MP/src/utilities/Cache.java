/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Mike
 */
public class Cache<K,V> {

    private int lifetime;
    private int maxCapacity;
    private LinkedHashMap<K, V> cache;

    public Cache(int maxCapacity) {
        cache = new LinkedHashMap<K, V>(maxCapacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > Cache.this.maxCapacity;
            }
        };
        
        this.maxCapacity = maxCapacity;
    }
    
    public synchronized V get(K key) {
        return cache.get(key);
    }
    
    public synchronized void put(K key, V value) {
        cache.put(key, value);
    }
    
    public synchronized void clear() {
        cache.clear();
    }
    
    public synchronized int size() {
        return cache.size();
    }
    
    public synchronized Collection<Map.Entry<K, V>> getAll() {
        return new ArrayList<>(cache.entrySet());
    }
}