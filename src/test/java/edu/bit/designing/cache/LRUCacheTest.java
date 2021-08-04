package edu.bit.designing.cache;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LRUCacheTest {

    LRUCache lruCache;

    @BeforeEach
    void setup() {
        lruCache = new LRUCache(2); // initialise before ecah test
    }

    @Test
    void testSuccessfulGet() {
        Assertions.assertFalse(lruCache.has(2));
        lruCache.put(4);
        lruCache.put(5);
        lruCache.put(4);
        Assertions.assertFalse(lruCache.has(6));
        Assertions.assertTrue(lruCache.has(5));
    }

    @Test
    void testReferringToValue() {
        lruCache.put(7);
        lruCache.put(8);
        lruCache.put(5);
        lruCache.refer(5);
        lruCache.refer(8);
        lruCache.put(9);
        Assertions.assertFalse(lruCache.has(5));
    }

    @Test
    void testPuttingValue() {
        lruCache.put(4);
        lruCache.put(5);
        lruCache.put(6);
        Assertions.assertFalse(lruCache.has(4));
        Assertions.assertTrue(lruCache.has(6));
    }
}