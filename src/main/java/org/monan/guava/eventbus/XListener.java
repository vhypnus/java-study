package org.monan.guava.eventbus;

import com.google.common.eventbus.Subscribe;

public class XListener {

    @Subscribe
    public void x(XEvent event){
        System.out.println("i am x") ;
    }
}
