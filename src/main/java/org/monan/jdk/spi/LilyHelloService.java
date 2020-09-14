package org.monan.jdk.spi;

public class LilyHelloService implements HelloService {

    @Override
    public String hello(String name) {
        System.out.println("hi "+name+". i am lili" ) ;
        return "lili";
    }
}
