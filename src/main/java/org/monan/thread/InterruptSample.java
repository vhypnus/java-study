package org.monan.thread;

public class InterruptSample {


    static class A implements  Runnable {

        @Override
        public void run() {
            System.out.println("interrupt flag =>"+ Thread.currentThread().isInterrupted() ) ;
            int i = 0 ;
            for (;;){
                System.out.println(i++) ;
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("interrupted i am out.interrupted flag =>"+Thread.currentThread().isInterrupted()) ;
                    break ;
                }
            }

            System.out.println(Thread.interrupted()) ;
            System.out.println(Thread.currentThread().isInterrupted()) ;


        }
    }


    public static void main(String[] args) {
        A a = new A() ;
        Thread t = new Thread(a) ;
        t.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
    }
}
