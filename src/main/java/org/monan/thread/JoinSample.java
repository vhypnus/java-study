package org.monan.thread;

public class JoinSample {



    static class A implements Runnable{

        Thread t ;

        public A(Thread t) {
            this.t = t;
        }

        @Override
        public void run() {
            System.out.println("A start.") ;
            for (int i = 0;i < 10000;i++){

            }
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("A end.");
        }
    }



    static class B implements Runnable {

        @Override
        public void run() {
            System.out.println("B start.") ;
            for (int i = 0;i < 10000;i++){

            }
            System.out.println("B end.");
        }
    }


    public static void main(String[] args) {
        B b = new B() ;
        Thread bt = new Thread(b);
        bt.start();


        A a = new A(bt) ;
        Thread at = new Thread(a) ;
        at.start();

    }
}
