package org.monan.jdk.spi;

public class LucyHelloService implements HelloService {


    @Override
    public String hello(String name) {

        System.out.println("hi "+name+". i am lucy" ) ;
        return "lucy";
    }
}
