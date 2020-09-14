package org.monan.jdk;

public class ShutDownHookSample {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
                System.out.println("hello world");
        }));

        System.out.println("i will exitx.") ;

        System.exit(0);

        // not print
        System.out.println("i am out");
    }
}
