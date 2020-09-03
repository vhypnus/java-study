package org.monan.guava.eventbus;

import com.google.common.eventbus.EventBus;

public class TestEventBus {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus("test");

        EventListener listener = new EventListener();

        eventBus.register(listener);
        eventBus.register(new XListener());

        eventBus.post(new TestEvent(200));
        eventBus.post(new TestEvent(300));
        eventBus.post(new TestEvent(400));
        eventBus.post(new XEvent());

        System.out.println("LastMessage:"+listener.getLastMessage());

//        eventBus
    }
}
