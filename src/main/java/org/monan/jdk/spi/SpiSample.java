package org.monan.jdk.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SpiSample {

    public static void main(String[] args) {
        ServiceLoader<HelloService> services = ServiceLoader.load(HelloService.class) ;

//        services.forEach((HelloService action)->action.hello("YUewen"));
        Iterator<HelloService> iterator = services.iterator() ;
        while(iterator.hasNext()){
            iterator.next().hello("Yuewen") ;
        }
    }
}
