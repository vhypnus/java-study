package org.monan.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GuavaCacheSample {

    public static void main(String[] args) {
        Cache cache = CacheBuilder.newBuilder().build() ;
        Lock lock = new ReentrantLock() ;
        lock.newCondition() ;
    }
}
