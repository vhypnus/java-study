package org.monan.jdk;

public class ThreadLocalSample {

    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal() ;
        threadLocal.set("hello world");
        threadLocal.set("xxxx");
        System.out.println(threadLocal.get()) ;
    }
}
