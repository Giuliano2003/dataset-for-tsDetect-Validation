package com.example.evosuite.advanced;

import java.util.LinkedHashMap;
import java.util.Map;

/** LRU cache thread-unsafe basata su LinkedHashMap con statistiche. */
public class LRUCache<K,V> extends LinkedHashMap<K,V> {
    private final int capacity;
    private long hits = 0, misses = 0;

    public LRUCache(int capacity) {
        super(Math.max(2, capacity), 0.75f, true);
        if (capacity <= 0) throw new IllegalArgumentException("capacity");
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return size() > capacity;
    }

    @Override
    public V get(Object key) {
        V v = super.get(key);
        if (v == null) misses++; else hits++;
        return v;
    }

    public long getHits() { return hits; }
    public long getMisses() { return misses; }
    public int capacity() { return capacity; }
}
