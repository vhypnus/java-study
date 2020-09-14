package org.monan.jdk;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AutoReferenceSample {

    public static void main(String[] args) throws Exception {
        AtomicReferenceFieldUpdater updater = AtomicReferenceFieldUpdater.newUpdater(Dog.class, String.class, "name");
        Dog dog1 = new Dog("dog1");
//        Dog dog2 = dog1 ;
//        System.out.println(dog1.hashCode()) ;
//        System.out.println(dog2.hashCode()) ;
        System.out.println(updater.compareAndSet(dog1, "dog1", "compareAndSet"));
        System.out.println(dog1.getName());
        System.out.println(updater.getAndSet(dog1, "getAndSet"));
        System.out.println(dog1.getName());
//
//        AtomicStampedReference<Dog> stampedReference = new AtomicStampedReference(dog1,0) ;
//
//        stampedReference.getReference().name = "" ;
//        stampedReference.com
    }

    static class Dog {

        private volatile String name = "dog1";

        public Dog(String name) {
            this.name = name ;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
